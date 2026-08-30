package com.stock.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stocksholding")
public class StockHolding {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="StocksholdingID")
private int stocksholdingID;
@Column(name="PurchasePrice")
private double purchasePrice;
@Column(name="TradeActions")
private String tradeAction;
@Column(name="CompanyTicker")
private String companyTicker;
@Column(name="Quantity")
private int quantity;
@Column(name="CompanyName")
private String companyName;
@Column(name="TransactionID")
private int transactionID;
@Column(name="UserID")
private int userID;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="userID",nullable=false)
private Account account;

}



