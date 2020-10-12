package com.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.test.demo.service.IExchangeRatesService;

@Controller
public class ExchangeRatesController {

	@Autowired
	IExchangeRatesService iExchangeRatesService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage() {
		return "rates-list";
	}
	
	@RequestMapping(value = "/today", consumes = MediaType.ALL_VALUE , method = RequestMethod.GET)
	public String getTodayExchangeRates(@RequestParam(name = "id", required = false) String id, ModelMap model ) throws Exception {
		
		try {
			model.put("exRates", iExchangeRatesService.getExchangeRates(id));
		} catch (Exception e) {
			model.put("error", e);
			throw e;
		}
		return "rates-list";
	}
	@RequestMapping(value = "/past", consumes = MediaType.ALL_VALUE , method = RequestMethod.GET)
	public String getPastExchangeRates(@RequestParam(name = "id", required = false) String id, ModelMap model ) {
		
		try {
			model.put("exRates", iExchangeRatesService.getExchangeRates(id));
		} catch (Exception e) {
			model.put("error", e);
		}
		return "rates-list";
	}
}
