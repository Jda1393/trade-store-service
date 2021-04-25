package com.coding.test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.test.model.TradeObject;
import com.coding.test.model.TradesModel;
import com.coding.test.service.TradeStoreService;

@RestController
@RequestMapping("/api")
public class TradeStoreController {
	
	@Autowired
	private TradeStoreService tradeStoreService;
	
	@PostMapping("/trade")
	public ResponseEntity addTrade(@RequestBody TradeObject trade) {
		return tradeStoreService.addTrade(trade);
	}
	
	@GetMapping("/trades")
	public Map<String,TradesModel> getAllTrades(){
		return tradeStoreService.getAllTrades();
	}
}
