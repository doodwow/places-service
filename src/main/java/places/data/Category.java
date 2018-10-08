package places.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Category {
	private Integer id;
	private String name;
	private String pluralName;
	private String shortName;
	private ReasonItem icon;
	private Boolean primary;

    @JsonProperty("Id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    @JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @JsonProperty("PluralName")
	public String getPluralName() {
		return pluralName;
	}

	public void setPluralName(String pluralName) {
		this.pluralName = pluralName;
	}

    @JsonProperty("ShortName")
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

    @JsonProperty("Icon")
	public ReasonItem getIcon() {
		return icon;
	}

	public void setIcon(ReasonItem icon) {
		this.icon = icon;
	}

    @JsonProperty("Primary")
	public Boolean isPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

}
