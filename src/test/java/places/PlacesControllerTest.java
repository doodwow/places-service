package places;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import places.controller.PlacesController;
import places.data.Group;
import places.data.Meta;
import places.data.Response;
import places.data.VenueRecommendationResponse;
import places.service.FoursquareService;

@RunWith(SpringRunner.class)
@WebMvcTest(PlacesController.class)
public class PlacesControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
    private FoursquareService service;

    @Before
    public void setUp() throws Exception {
    }

	@Test
	public void getVenuesTest() throws Exception {
		VenueRecommendationResponse resp = new VenueRecommendationResponse();
		Response response = new Response();
		response.setTotalResults(new Integer(230));
		Group group = new Group();
		group.setName("recommended");
		response.setGroups(Arrays.asList(group));
		Meta meta = new Meta();
		meta.setCode(new Integer(200));
		resp.setMeta(meta);
		resp.setResponse(response);
		Optional<VenueRecommendationResponse> output = Optional.of(resp);
		given(service.findVenuesRecommendation("london")).willReturn(output);
		MvcResult result = mvc.perform(get("/places?name=london")
				.contentType(MediaType.APPLICATION_JSON))
                .andReturn();
		
		mvc.perform(asyncDispatch(result))
				.andExpect(status().isOk())
				.andExpect(jsonPath("meta.code").value(meta.getCode()))
				.andExpect(jsonPath("response.totalResults").value(response.getTotalResults()))
				.andExpect(jsonPath("response.groups[0].name").value(group.getName()));
		reset(service);
	}
}
