package com.test.models;

import javax.persistence.*;
import java.sql.Timestamp;

//below is a test
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by trina2 on 8/4/17.
 */
@Entity
@Table(name = "RegisForm", schema = "HelloWorld", catalog = "")
public class RegisFormEntity {
    private int idRegisForm;
  //this is a test with @Null
    @NotNull(message = "name cannot be null")
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zipCode;
    private String country;
    private Timestamp date;

    @Id
    @Column(name = "idRegisForm", nullable = false)
    public int getIdRegisForm() {
        return idRegisForm;
    }

    public void setIdRegisForm(int idRegisForm) {
        this.idRegisForm = idRegisForm;
    }

    @Basic
    @Column(name = "FirstName", nullable = false, length = 55)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName", nullable = false, length = 55)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Address1", nullable = false, length = 55)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "Address2", nullable = false, length = 55)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "City", nullable = false, length = 55)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "State", nullable = false, length = 20)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "ZipCode", nullable = false)
    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "Country", nullable = false, length = 15)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "Date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisFormEntity that = (RegisFormEntity) o;

        if (idRegisForm != that.idRegisForm) return false;
        if (zipCode != that.zipCode) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRegisForm;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + zipCode;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
