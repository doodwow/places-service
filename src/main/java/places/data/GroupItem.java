package places.data;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public final class GroupItem {

	private Reason reasons;
	private Venue venue;
	
	private Map<String, Object> metadata = new HashMap<>();

	@JsonAnyGetter
	public Map<String, Object> any() {
		return metadata;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		this.metadata.put(name, value);
	}

	public Reason getReasons() {
		return reasons;
	}

	public void setReasons(Reason reasons) {
		this.reasons = reasons;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

}
