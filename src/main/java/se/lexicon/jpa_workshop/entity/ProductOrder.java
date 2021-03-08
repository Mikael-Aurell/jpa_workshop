package se.lexicon.jpa_workshop.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ProductOrder {
    private int id;
    private LocalDateTime orderDateTime;
    private AppUser customer;

    @OneToMany(mappedBy = "productOrder")
    private List<OrderItem> orderItems;

    //convince methods
    public void addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        orderItem.setProductOrder(this);
        orderItems.add(orderItem);
    }

    public ProductOrder() {
    }

    // convince methods
    public void removeOrderItem(OrderItem orderItem) {
        if (orderItem != null) {
            orderItem.setProductOrder(null);
            orderItems.remove(orderItem);
        }
        // check if is not null then you can remove

    }

    public double calculateTotalPrice(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(x -> x.calculatePrice(x.getProduct(), x.getQuantity()))
                .reduce(0.0, Double::sum);
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return id == that.id && Objects.equals(orderDateTime, that.orderDateTime) && Objects.equals(customer, that.customer) && Objects.equals(orderItems, that.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDateTime, customer, orderItems);
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", orderDateTime=" + orderDateTime +
                ", customer=" + customer +
                ", orderItems=" + orderItems +
                '}';
    }
}
