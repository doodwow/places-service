package places.service;

import java.util.Optional;

import places.data.VenueRecommendationResponse;

public interface FoursquareService {

	public Optional<VenueRecommendationResponse> findVenuesRecommendation(String name);
}
