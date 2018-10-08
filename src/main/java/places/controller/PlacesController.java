package places.controller;

import java.util.Optional;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import places.data.VenueRecommendationResponse;
import places.service.FoursquareService;

@RestController
public class PlacesController {
	
	@Autowired
	private FoursquareService fourSquareService;
    
	/**
     * Get places request for provided query parameter
     * @return Callable<VenueRequestOutputResponse> List of venues
     */
    @RequestMapping(value = "/places", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Callable<VenueRecommendationResponse> getVenues(
            final HttpServletRequest request, HttpServletResponse response,
            @RequestParam(required = true) final String name) {
        return () -> {
            Optional<VenueRecommendationResponse> venueRequestData = fourSquareService.findVenuesRecommendation(name);
            
            return venueRequestData.isPresent() ? venueRequestData.get() : new VenueRecommendationResponse();
        };
    }
    
}
