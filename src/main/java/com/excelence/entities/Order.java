package com.excelence.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.type.descriptor.jdbc.ObjectNullAsNullTypeJdbcType;

import com.excelence.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
//	Troca pra dizer ao banco de dados que vai gravar um número inteiro
//	private OrderStatus orderStatus;
	
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
//	Cascade usado por pedido e pagamento ter o mesmo id
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)	
	private Paymant payment;
	
	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

//	Recebe um orderStatus inteiro / interno, e converte para orderStatus
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (!Objects.isNull(orderStatus)) {
		this.orderStatus = orderStatus.getCode();
	}
}
	
	public void setClient(User client) {
		this.client = client;
	}
	
	
	
	public Paymant getPayment() {
		return payment;
	}

	public void setPayment(Paymant payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public Double getTotal() {
		double sum = 0.0;
		for (OrderItem x : items) {
			sum += x.getSubtotal();
		}
		return sum;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
