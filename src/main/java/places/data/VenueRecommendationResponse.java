package places.data;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class VenueRecommendationResponse {

	private String suggestedRadius;
	private String headerLocation;
	private String headerFullLocation;
	private String headerLocationGranularity;
	private String totalResults;
	private String state;
	private Warning warning;
	private SuggestedBounds suggestedBounds;

	private Map<String, Object> metadata = new HashMap<>();

	public VenueRecommendationResponse() {
		// DEFAULT CONSTRUCTOR NEEDED FOR JACKSON UNMARSHALLING
	}

	public String getSuggestedRadius() {
		return suggestedRadius;
	}

	public void setSuggestedRadius(String suggestedRadius) {
		this.suggestedRadius = suggestedRadius;
	}

	public String getHeaderLocation() {
		return headerLocation;
	}

	public void setHeaderLocation(String headerLocation) {
		this.headerLocation = headerLocation;
	}

	public String getHeaderFullLocation() {
		return headerFullLocation;
	}

	public void setHeaderFullLocation(String headerFullLocation) {
		this.headerFullLocation = headerFullLocation;
	}

	public String getHeaderLocationGranularity() {
		return headerLocationGranularity;
	}

	public void setHeaderLocationGranularity(String headerLocationGranularity) {
		this.headerLocationGranularity = headerLocationGranularity;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Warning getWarning() {
		return warning;
	}

	public void setWarning(Warning warning) {
		this.warning = warning;
	}

	public SuggestedBounds getSuggestedBounds() {
		return suggestedBounds;
	}

	public void setSuggestedBounds(SuggestedBounds suggestedBounds) {
		this.suggestedBounds = suggestedBounds;
	}

	@JsonAnyGetter
	public Map<String, Object> any() {
		return metadata;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		this.metadata.put(name, value);
	}
}
