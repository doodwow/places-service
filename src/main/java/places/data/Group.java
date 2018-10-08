package places.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public final class Group {

    private String type;
    private String name;
    private List<GroupItem> items;

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Type")
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    @JsonProperty("Items")
	public List<GroupItem> getItems() {
		return items;
	}

	public void setItems(List<GroupItem> items) {
		this.items = items;
	}
}
