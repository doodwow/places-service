package places.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public final class Reason {

    private Integer count;
    private List<ReasonItem> items;

	@JsonProperty("Count")
    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("Items")
	public List<ReasonItem> getItems() {
		return items;
	}

	public void setItems(List<ReasonItem> items) {
		this.items = items;
	}
}
