package places.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public final class Venue {

    private String id;
    private String name;
    private Location location;
    private List<Category> categories;
    private VenuePage venuePage;
    
    private Map<String, Object> metadata = new HashMap<>();

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    public void setId(String venueRequestExternalIdentifier) {
        this.id = venueRequestExternalIdentifier;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Location")
    public Location getLocation() {
        return location;
    }

	public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("Categories")
    public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

    @JsonProperty("VenuePage")
    public VenuePage getVenuePage() {
		return venuePage;
	}

	public void setVenuePage(VenuePage venuePage) {
		this.venuePage = venuePage;
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
