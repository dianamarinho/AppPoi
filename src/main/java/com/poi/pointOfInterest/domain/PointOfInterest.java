package com.poi.pointOfInterest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * The Point Of Interest model entity
 */
@Table("point_of_interest")
public class PointOfInterest {

    @Id
    private Integer id;

    private String name;
    private String description;
    private String addressName;
    private String city;
    private String zipCode;
    private String poiType;
    private long latitude;
    private long longitude;

    /**
     * Gets the id of the Point Of Interest
     *
     * @return the Point Of Interest id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the Point Of Interest
     *
     * @param id id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the Point Of Interest
     *
     * @return the Point Of Interest name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Point Of Interest
     *
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address name of the Point Of Interest
     *
     * @return the Point Of Interest address name
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * Sets the address name of the Point Of Interest
     *
     * @param addressName address name to set
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * Gets the city of the Point Of Interest
     *
     * @return the Point Of Interest city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the Point Of Interest
     *
     * @param city city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the zip code of the Point Of Interest
     *
     * @return the Point Of Interest zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code of the Point Of Interest
     *
     * @param zipCode zip code to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the type of the Point Of Interest
     *
     * @return the Point Of Interest type
     */
    public String getPoiType() {
        return poiType;
    }

    /**
     * Sets the type of the Point Of Interest
     *
     * @param poiType type to set
     */
    public void setPoiType(String poiType) {
        this.poiType = poiType;
    }

    /**
     * @see Object#equals(Object)
     *
     * @param o the object to compare
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOfInterest that = (PointOfInterest) o;
        return latitude == that.latitude && longitude == that.longitude && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(addressName, that.addressName) && Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && Objects.equals(poiType, that.poiType);
    }

    /**
     * @see Object#hashCode()
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, addressName, city, zipCode, poiType, latitude, longitude);
    }

    /**
     * @see Object#toString()
     * @return the string
     */
    @Override
    public String toString() {
        return "PointOfInterest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", addressName='" + addressName + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", poiType='" + poiType + '\'' +
                ", lat=" + latitude +
                ", lon=" + longitude +
                '}';
    }
}
