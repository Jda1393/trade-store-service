package com.coding.test.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coding.test.dao.TradeStoreDAO;
import com.coding.test.model.TradeObject;
import com.coding.test.model.TradesModel;

@Service
public class TradeStoreServiceImpl implements TradeStoreService {
	
	@Autowired
	private TradeStoreDAO tradeStoreDAO;

	@Override
	public ResponseEntity addTrade(TradeObject trade) {
		// TODO Auto-generated method stub
		
		return tradeStoreDAO.addTradeInStore(trade);
	}

	@Override
	public Map<String,TradesModel> getAllTrades() {
		// TODO Auto-generated method stub
		return tradeStoreDAO.getAllTradesFromStore();
	}

	public void setTradeStoreDAO(TradeStoreDAO tradeStoreDAO) {
		this.tradeStoreDAO = tradeStoreDAO;
	}
	
	

}
