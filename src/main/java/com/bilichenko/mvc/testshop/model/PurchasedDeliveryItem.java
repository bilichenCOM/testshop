package com.bilichenko.mvc.testshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "purchased_delivery_items")
@NamedEntityGraph(name = "PurchasedDeliveryItem.products",
        attributeNodes = @NamedAttributeNode("products"))
public class PurchasedDeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "purchased_delivery_items_products",
            joinColumns = @JoinColumn(name = "fk_purchased_delivery_item_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_product_id"))
    private List<Product> products;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    private String country;
    private String city;
    private String street;
    private String firstName;
    private String lastName;
    private String zip;

    public static class PurchasedDeliveryItemBuiler {
        private List<Product> products;
        private User user;
        private String country;
        private String city;
        private String street;
        private String firstName;
        private String lastName;
        private String zip;

        public PurchasedDeliveryItemBuiler withUser(User user) {
            this.user = user;
            return this;
        }

        public PurchasedDeliveryItemBuiler withProducts(List<Product> products) {
            this.products = products;
            return this;
        }

        public PurchasedDeliveryItemBuiler withCountry(String country) {
            this.country = country;
            return this;
        }

        public PurchasedDeliveryItemBuiler withCity(String city) {
            this.city = city;
            return this;
        }

        public PurchasedDeliveryItemBuiler withStreet(String street) {
            this.street = street;
            return this;
        }

        public PurchasedDeliveryItemBuiler withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PurchasedDeliveryItemBuiler withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PurchasedDeliveryItemBuiler withZip(String zip) {
            this.zip = zip;
            return this;
        }

        public PurchasedDeliveryItem build() {
            PurchasedDeliveryItem pdi = new PurchasedDeliveryItem();
            pdi.setUser(user);
            pdi.setProducts(products);
            pdi.setCountry(country);
            pdi.setCity(city);
            pdi.setStreet(street);
            pdi.setFirstName(firstName);
            pdi.setLastName(lastName);
            pdi.setZip(zip);
            return pdi;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasedDeliveryItem that = (PurchasedDeliveryItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(country, that.country) &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, country, city, street, firstName);
    }

    @Override
    public String toString() {
        return "PurchasedDeliveryItem{" +
                "id=" + id +
                ", products=" + products +
                ", user=" + user +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
