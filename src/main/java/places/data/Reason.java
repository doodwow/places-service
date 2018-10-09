package places.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public final class Reason {

    private Integer count;
    private List<ReasonItem> items;
	
	private Map<String, Object> metadata = new HashMap<>();

	@JsonAnyGetter
	public Map<String, Object> any() {
		return metadata;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		this.metadata.put(name, value);
	}

    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<ReasonItem> getItems() {
		return items;
	}

	public void setItems(List<ReasonItem> items) {
		this.items = items;
	}
}
