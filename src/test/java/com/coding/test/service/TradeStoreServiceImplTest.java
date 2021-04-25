package com.coding.test.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;

import com.coding.test.dao.TradeStoreDAOImpl;
import com.coding.test.model.TradeObject;
import com.coding.test.model.TradesModel;
import com.coding.test.utility.StubProvider;

@SpringBootTest
public class TradeStoreServiceImplTest {
	
	@InjectMocks
	private TradeStoreServiceImpl tradeStoreServicetest;
	
	@Mock
	private TradeStoreDAOImpl tradeStoreDAOtest;
	
	StubProvider stubProvider= new StubProvider();
		
	@Test
	public void testServiceAddTrade() {
		Mockito.when(this.tradeStoreDAOtest.addTradeInStore(ArgumentMatchers.any())).thenReturn(stubProvider.postStubSuccessResponse());
		ResponseEntity res=tradeStoreServicetest.addTrade(ArgumentMatchers.any());
		Assert.assertNotNull(res);
	}
	
	@Test
	public void testServiceGetAllTrades() {
		Mockito.when(this.tradeStoreDAOtest.getAllTradesFromStore()).thenReturn(stubProvider.getStubResponse());
		Map<String,TradesModel> response=tradeStoreServicetest.getAllTrades();
		Assert.assertNotNull(response);
	}

}
