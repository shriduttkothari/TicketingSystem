package com.thoughworks.ticketingapi.model;

import java.util.Currency;

public class Price {
	private int value;
	private Currency currency;

	public Price(int value, Currency currency) {
		super();
		this.value = value;
		this.currency = currency;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
