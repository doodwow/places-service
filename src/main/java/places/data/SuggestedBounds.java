package places.data;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SuggestedBounds {

	GeoCodeGeoPt ne; // northeast
	GeoCodeGeoPt sw; // southwest
	
	private Map<String, Object> metadata = new HashMap<>();

	@JsonAnyGetter
	public Map<String, Object> any() {
		return metadata;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		this.metadata.put(name, value);
	}

	public GeoCodeGeoPt getNe() {
		return ne;
	}

	public void setNe(GeoCodeGeoPt ne) {
		this.ne = ne;
	}

	public GeoCodeGeoPt getSw() {
		return sw;
	}

	public void setSw(GeoCodeGeoPt sw) {
		this.sw = sw;
	}

}
