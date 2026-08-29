package com.springcomerce.orderservice.dao;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oid;
	private String status;
	private Double price;
	
	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "csname",column = @Column(name="customerName")),
			@AttributeOverride(name = "csemail",column = @Column(name="email")),
			@AttributeOverride(name = "csaddress",column = @Column(name="address"))
	})
	private Customer customer;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
	private Set<OrderItems> orderItems;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItems> orderItems) {
		if(orderItems!=null) {
			orderItems.forEach(item->item.setOrder(this));
		}
		this.orderItems = orderItems;
	}
	
}
