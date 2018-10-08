package places.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public final class GroupItem {

	private Reason reasons;
	private Venue venue;

    @JsonProperty("Reasons")
	public Reason getReasons() {
		return reasons;
	}

	public void setReasons(Reason reasons) {
		this.reasons = reasons;
	}

    @JsonProperty("Venue")
	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

}
