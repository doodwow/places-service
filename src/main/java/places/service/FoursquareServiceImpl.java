package places.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import places.data.VenueRecommendationResponse;
import places.exception.ErrorData;
import places.exception.FoursquareFailedException;
import places.exception.ResourceAccessException;
import org.apache.commons.io.IOUtils;

@Service
@DefaultProperties(defaultFallback = "fallback")
public class FoursquareServiceImpl implements FoursquareService {

	@Value("${foursquareVenuesUrl}")
	private String requestURL;

	@Override
	@HystrixCommand(commandKey = "foursquareService", ignoreExceptions = { FoursquareFailedException.class })
	public Optional<VenueRecommendationResponse> findVenuesRecommendation(String name) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return (!HttpStatus.OK.equals(response.getStatusCode()));
            }
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                try {
                    InputStream body = response.getBody();
                    StringWriter writer = new StringWriter();
                    IOUtils.copy(body, writer, StandardCharsets.UTF_8);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String content = writer.toString();
                    TypeReference<Map<String,ErrorData>> typeRef
                            = new TypeReference<Map<String, ErrorData>>() {};
                    Map<String,ErrorData> map = objectMapper.readValue(content, typeRef);
                    ErrorData errorData = map.get("error");
                    throw new FoursquareFailedException(errorData);
                } catch (IOException ioe) {
                    throw new FoursquareFailedException(new ErrorData(Long.valueOf(response.getRawStatusCode()), null, "Could not get venues" ));
                }
            }
        });
		ResponseEntity<VenueRecommendationResponse> itemResponseEntity = restTemplate.getForEntity(
				requestURL, VenueRecommendationResponse.class, name);
		if (itemResponseEntity.getStatusCode() == HttpStatus.OK) {
			return Optional.ofNullable(itemResponseEntity.getBody());
		} else {
			return Optional.empty();
		}
	}

	public Optional<VenueRecommendationResponse> fallback(Throwable ex) {
		if (ex instanceof ExecutionException) {
			Throwable cause = ex.getCause();
			if (cause instanceof FoursquareFailedException) {
				FoursquareFailedException exception = (FoursquareFailedException) cause;
				throw exception;
			}
		}
		ErrorData errorData = new ErrorData(Long.valueOf(HttpStatus.SERVICE_UNAVAILABLE.toString()), "API_ERR_503",
				ex.getMessage());
		throw new ResourceAccessException(errorData, ex);
	}

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	
}
