package places.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Warning {

	private String text;

    @JsonProperty("Text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
