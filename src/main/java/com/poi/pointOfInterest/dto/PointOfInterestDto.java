package com.poi.pointOfInterest.dto;

import java.util.Objects;
import com.poi.pointOfInterest.domain.PointOfInterest;

/**
 * The {@link PointOfInterest} data transfer object
 */
public class PointOfInterestDto {

    private Integer id;
    private String name;
    private String addressName;
    private String city;
    private String zipCode;
    private String poiType;

    /**
     * Gets the id of the Point Of Interest DTO
     *
     * @return the Point Of Interest DTO id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the Point Of Interest DTO
     *
     * @param id id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the Point Of Interest DTO
     *
     * @return the Point Of Interest DTO name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Point Of Interest DTO
     *
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address name of the Point Of Interest DTO
     *
     * @return the Point Of Interest DTO address name
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * Sets the address name of the Point Of Interest DTO
     *
     * @param addressName address name to set
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * Gets the city of the Point Of Interest DTO
     *
     * @return the Point Of Interest DTO city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the Point Of Interest DTO
     *
     * @param city city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the zip code of the Point Of Interest DTO
     *
     * @return the Point Of Interest DTO zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code of the Point Of Interest DTO
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
     * @see Object#toString()
     * @return the string
     */
    @Override
    public String toString() {
        return "PointOfInterestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressName='" + addressName + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", poiType='" + poiType + '\'' +
                '}';
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
        PointOfInterestDto that = (PointOfInterestDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(addressName, that.addressName) && Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && Objects.equals(poiType, that.poiType);
    }

    /**
     * @see Object#hashCode()
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressName, city, zipCode, poiType);
    }


}
