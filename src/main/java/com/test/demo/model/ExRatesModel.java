package com.test.demo.model;

import java.util.*;

public class ExRatesModel {

	private String base;
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public HashMap getRates() {
		return rates;
	}
	public void setRates(HashMap rates) {
		this.rates = rates;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private HashMap rates;
	private String date;
}
