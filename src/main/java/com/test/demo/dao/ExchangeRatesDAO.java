package com.test.demo.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.test.demo.model.ExRatesModel;

@Repository
public class ExchangeRatesDAO implements IExchangeRatesDAO{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public HashMap getExchangeRates(String url) throws Exception {
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ExRatesModel exRatesModel = new ExRatesModel();
        try {
        	ResponseEntity<ExRatesModel> response = restTemplate.exchange(url, HttpMethod.GET,entity,ExRatesModel.class);
        	return response.getBody().getRates();
        }
        catch(Exception ex) {
        	throw ex; 
        }
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	

}
