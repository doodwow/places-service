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

	private Meta meta;
	private Response response;
	
	private Map<String, Object> metadata = new HashMap<>();


	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
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
