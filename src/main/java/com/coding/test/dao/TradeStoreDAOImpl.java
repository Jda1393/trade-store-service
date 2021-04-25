package com.coding.test.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.coding.test.exception.BusinessException;
import com.coding.test.model.TradeObject;
import com.coding.test.model.TradesModel;

@Service
public class TradeStoreDAOImpl implements TradeStoreDAO {
	

	private HashMap<String,TradesModel> tradeStore;
	
	

	public TradeStoreDAOImpl(HashMap<String, TradesModel> tradeStore) {
		this.tradeStore = tradeStore;
	}

	@Override
	public ResponseEntity addTradeInStore(TradeObject trade) {
		
		if(trade.getTrade().getMaturityDate().isBefore(LocalDate.now())){
			throw new BusinessException("Maturity Date is invalid");
		}
		else if(tradeStore.containsKey(trade.getTradeId())) {
			TradesModel existingTrade=tradeStore.get(trade.getTradeId());
			if(trade.getTrade().getVersion()<existingTrade.getVersion())
				throw new BusinessException("Version is invalid");
			
		}
		tradeStore.put(trade.getTradeId(), trade.getTrade());
		return new ResponseEntity<>(HttpStatus.CREATED);
	
	}

	@Override
	public Map<String,TradesModel> getAllTradesFromStore() {
		// TODO Auto-generated method stub
		return tradeStore;
	}
	
	@Scheduled(cron = "0 0 0 * * *")
		public void updateExpiry() {
			HashMap<String,TradesModel> filteredMap=(HashMap<String,TradesModel>)tradeStore.entrySet().stream().filter(map->map.getValue().getMaturityDate().isEqual(LocalDate.now())).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
			for(Map.Entry<String, TradesModel> entry: filteredMap.entrySet()) {
				TradesModel expiredTrade= (TradesModel)entry.getValue();
				expiredTrade.setExpired("Y");
				tradeStore.put((String)entry.getKey(), expiredTrade);
			}
		}



	public void setTradeStore(HashMap<String, TradesModel> tradeStore) {
		this.tradeStore = tradeStore;
	}
	
	

}
