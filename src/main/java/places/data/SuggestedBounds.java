package places.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SuggestedBounds {

	GeoCodeGeoPt ne; // northeast
	GeoCodeGeoPt sw; // southwest

    @JsonProperty("Ne")
	public GeoCodeGeoPt getNe() {
		return ne;
	}

	public void setNe(GeoCodeGeoPt ne) {
		this.ne = ne;
	}

    @JsonProperty("Sw")
	public GeoCodeGeoPt getSw() {
		return sw;
	}

	public void setSw(GeoCodeGeoPt sw) {
		this.sw = sw;
	}

}
