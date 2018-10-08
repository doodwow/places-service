package places.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ReasonItem {
	
	private String summary;
	private String type;
	private String reasonName;

	@JsonProperty("Summary")
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}

    @JsonProperty("Type")
	public String getType() {
		return type;
	}
    
	public void setType(String type) {
		this.type = type;
	}

    @JsonProperty("ReasonName")
	public String getReasonName() {
		return reasonName;
	}
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

}
