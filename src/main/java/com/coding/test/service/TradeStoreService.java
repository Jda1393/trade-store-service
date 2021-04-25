package com.coding.test.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.coding.test.model.TradeObject;
import com.coding.test.model.TradesModel;

public interface TradeStoreService {
	
	public ResponseEntity addTrade(TradeObject trade);
	
	public Map<String,TradesModel> getAllTrades();

}
