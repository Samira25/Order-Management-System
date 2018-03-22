package co.innoweb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    @ManyToOne
    private Customer customer_id;

    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @ManyToOne
    private Product product_id;

    @Column(name = "quantity", nullable = true, length = 55)
    private Integer quantity;

    @Column(name = "total_price", nullable = true, length = 55)
    private Double total_price;

    @Column(name = "delivery_date", nullable = true, length = 55)
    private Date delivery_date;

    public Order() {
    }

    public Order(Customer customer_id, Product product_id, Integer quantity, Double total_price, Date delivery_date) {
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.delivery_date = delivery_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", total_price=" + total_price +
                ", delivery_date=" + delivery_date +
                '}';
    }
}
