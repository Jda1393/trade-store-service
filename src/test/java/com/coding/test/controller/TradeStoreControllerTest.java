package com.coding.test.controller;

import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.coding.test.model.TradesModel;
import com.coding.test.service.TradeStoreService;
import com.coding.test.service.TradeStoreServiceImpl;
import com.coding.test.utility.StubProvider;

@SpringBootTest
public class TradeStoreControllerTest {
	
	@InjectMocks
	private TradeStoreController tradeStoreController;
	
	@Mock
	private TradeStoreServiceImpl tradeStoreService;
	
	StubProvider stubProvider= new StubProvider();
	
	@Test
	public void testAddTrade() {
		Mockito.when(this.tradeStoreService.addTrade(ArgumentMatchers.any())).thenReturn(stubProvider.postStubSuccessResponse());
		ResponseEntity res=tradeStoreController.addTrade(ArgumentMatchers.any());
		Assert.assertNotNull(res);
	}
	
	@Test
	public void testGetAllTrades() {
		Mockito.when(this.tradeStoreService.getAllTrades()).thenReturn(stubProvider.getStubResponse());
		Map<String,TradesModel> response=tradeStoreController.getAllTrades();
		Assert.assertNotNull(response);
	}
	
	
	
	

}
