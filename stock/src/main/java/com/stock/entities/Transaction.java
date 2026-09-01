package com.stock.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TransactionID")
	private int transactionID;
	@Column(name="OrderDateTime")
	private LocalDate orderDate;
	@Column(name="Status")
	private String status;
	@Column(name="Transaction")
	private String transaction;
	@Column(name="Quantity")
	private int quantity;
	@Column(name="PurchasePrice")
	private double purchasePrice;
	@Column(name="Action_")
	private String action;
	@Column(name="UserID")
	private int userID;
	@Column(name="CompanyTicker")
	private String companyTicker;
}
