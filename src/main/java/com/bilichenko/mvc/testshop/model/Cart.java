package com.bilichenko.mvc.testshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "carts")
@NamedEntityGraph(name = "Cart.products",
        attributeNodes = @NamedAttributeNode("products"))
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    private User user;

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(name = "carts_products",
            joinColumns = @JoinColumn(name = "fk_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_product_id"))
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public Cart(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public double totalPrice() {
        return this.products.stream()
                .map(p -> p.getPrice())
                .reduce((pr1, pr2) -> pr1 + pr2)
                .orElse(0.0);
    }

    public int size() {
        return products.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(user, cart.user) &&
                Objects.equals(products, cart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, products);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}