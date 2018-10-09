package places.service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import places.data.VenueRecommendationResponse;
import places.exception.ErrorData;
import places.exception.FoursquareFailedException;
import places.exception.ResourceAccessException;

@Service
@DefaultProperties(defaultFallback = "fallback")
public class FoursquareServiceImpl implements FoursquareService {

	@Value("${foursquareVenuesUrl}")
	private String requestURL;

	@Override
	@HystrixCommand(commandKey = "foursquareService", ignoreExceptions = { FoursquareFailedException.class })
	public Optional<VenueRecommendationResponse> findVenuesRecommendation(String name) {
		RestTemplate restTemplate = new RestTemplate();
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
