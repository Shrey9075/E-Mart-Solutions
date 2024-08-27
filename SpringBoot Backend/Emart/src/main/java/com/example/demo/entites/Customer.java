package com.example.demo.entites;

import java.util.List;

import org.aspectj.lang.annotation.RequiredTypes;
import org.hibernate.annotations.processing.Pattern;

import jakarta.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_ID")
	private int custID;
	
	
	@Column(nullable = false)
	private String custName;
	
	
	@Column(nullable = false)
	private String custAddress;
	
	
	
	@Column(nullable = false)
	private String custPhone;
	
	private String custEmail; 
	
	
	@Column(nullable = false)
	private String custPassword;
	
	@Column(nullable = false)
	private boolean cardHolder;
	
	@Column(nullable = false)
	private int points;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "custID")
	private List<Invoice> invoiceList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private List<Order> orderList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "custID")
	private List<Cart> cartList;
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	@Column(nullable = false)
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(nullable = false)
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	@Column(nullable = false)
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	@Column(nullable = false)
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	@Column(nullable = false)
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	
	@Column(nullable=false)
	public boolean isCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(boolean isCardHolder) {
		this.cardHolder = isCardHolder;
	}
	
	@Column(nullable = false)
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CustID")
	public List<Invoice> getIlist() {
		return invoiceList;
	}
	public void setIlist(List<Invoice> ilist) {
		this.invoiceList = ilist;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CustID")
	public List<Order> getOlist() {
		return orderList;
	}
	public void setOlist(List<Order> olist) {
		this.orderList = olist;
	}
}
