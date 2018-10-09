package places;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import places.data.VenueRecommendationResponse;
import places.exception.FoursquareFailedException;
import places.service.FoursquareServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FoursquareServiceTest {
	
	@InjectMocks
	@Spy
	private FoursquareServiceImpl service;

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8081);
	
	@Test
	public final void findVenuesRecommendationTest() {
		String url = "http://localhost:8081";
		stubFor(get(urlEqualTo("/"))
	                .withHeader("Accept", equalTo("application/json, application/*+json"))
	                .willReturn(aResponse()
	                    .withStatus(200)
	                    .withHeader("Content-Type", "application/json")
	                    .withBody(successJson())));
		service.setRequestURL(url);
		Optional<VenueRecommendationResponse> res = service.findVenuesRecommendation("london");
		VenueRecommendationResponse result = res.isPresent() ? res.get() : new VenueRecommendationResponse();
		assertEquals(new Integer(230), result.getResponse().getTotalResults());
		assertEquals(new Integer(200), result.getMeta().getCode());
		assertEquals("globalInteractionReason", result.getResponse().getGroups().get(0).getItems().get(0).getReasons().getItems().get(0).getReasonName());
		assertEquals(new Double(-73.98829148466851), result.getResponse().getGroups().get(0).getItems().get(0).getVenue().getLocation().getLabeledLatLngs().get(0).getLng());
		assertEquals("179 E Houston St (btwn Allen & Orchard St)", result.getResponse().getGroups().get(0).getItems().get(0).getVenue().getLocation().getFormattedAddress().get(0));
		assertEquals(".png", result.getResponse().getGroups().get(0).getItems().get(0).getVenue().getCategories().get(0).getIcon().getSuffix());
		
	}
	
	@Test(expected=FoursquareFailedException.class)
	public final void findVenuesRecommendationTestFailure404() {
		String url = "http://localhost:8081";
		stubFor(get(urlEqualTo("/"))
	                .withHeader("Accept", equalTo("application/json, application/*+json"))
	                .willReturn(aResponse()
	                    .withStatus(404)
	                    .withHeader("Content-Type", "application/json")
	                    .withBody(failJson())));
		service.setRequestURL(url);
		service.findVenuesRecommendation("london");
		
	}

    private byte[] failJson() {
        String res = "{\n" +
                "    \"error\": {\n" +
                "        \"statusCode\": 404,\n" +
                "        \"code\": \"EES_API_ERR_004\",\n" +
                "        \"message\": \"Entitlement not found\"\n" +
                "    }\n" +
                "}";
        return res.getBytes();
    }

	private byte[] successJson() {

        StringWriter responseWriter = new StringWriter();
        
        char[] buf = new char[1024];
        int l = 0;
        
        InputStream in = this.getClass().getResourceAsStream("/explore_2.json");
        InputStreamReader reader = new InputStreamReader(in);
        try {
			while ((l = reader.read(buf)) > 0) {
			  responseWriter.write(buf, 0, l);
			}
	        responseWriter.flush();
	        responseWriter.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
        
	    String res = responseWriter.toString();
	    return res.getBytes();
	}
}
