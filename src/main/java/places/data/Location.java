package places.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Location {
	private Double lat;
	private Double lng;
	private Integer distance;
	private String address;
	private String crossStreet;
	private String postalCode;
	private String cc;
	private String city;
	private String state;
	private String country;
	private List<LabeledLatLng> labeledLatLngs;
	private List<String> formattedAddress;

    @JsonProperty("Lat")
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

    @JsonProperty("Lng")
	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

    @JsonProperty("Distance")
	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

    @JsonProperty("Address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    @JsonProperty("CrossStreet")
	public String getCrossStreet() {
		return crossStreet;
	}

	public void setCrossStreet(String crossStreet) {
		this.crossStreet = crossStreet;
	}

    @JsonProperty("PostalCode")
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

    @JsonProperty("Cc")
	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

    @JsonProperty("City")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    @JsonProperty("State")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

    @JsonProperty("Country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

    @JsonProperty("LabeledLatLngs")
	public List<LabeledLatLng> getLabeledLatLngs() {
		return labeledLatLngs;
	}

	public void setLabeledLatLngs(List<LabeledLatLng> labeledLatLngs) {
		this.labeledLatLngs = labeledLatLngs;
	}

    @JsonProperty("FormattedAddress")
	public List<String> getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(List<String> formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

}
