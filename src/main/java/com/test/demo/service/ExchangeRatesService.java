package com.test.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.dao.IExchangeRatesDAO;

@Service
public class ExchangeRatesService implements IExchangeRatesService{

	@Autowired
	IExchangeRatesDAO iExchangeRatesDAO;
	
	@Override
	public HashMap getExchangeRates(String url) throws Exception{
		try {
			return iExchangeRatesDAO.getExchangeRates(url);
		} catch (Exception e) {
			throw e;
		}
	}

}
