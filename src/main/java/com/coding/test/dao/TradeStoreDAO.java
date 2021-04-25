package com.coding.test.dao;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.coding.test.model.TradeObject;
import com.coding.test.model.TradesModel;

public interface TradeStoreDAO {
	
	public ResponseEntity addTradeInStore(TradeObject trade);
	
	public Map<String,TradesModel> getAllTradesFromStore();

}
