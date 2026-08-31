package com.stock.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="account")
public class Account {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="UserID",nullable=false)
private int userID;
public int getUserID() {
	return userID;
}

//@GeneratedValue(strategy=GenerationType.IDENTITY) // we cant use that for non pk

@Column(name="Username")
private String username;

@Column(name="Password")
private String password;


@OneToMany(mappedBy="account", orphanRemoval=true, cascade=CascadeType.ALL)
private List<StockHolding> stockHolding;
}

