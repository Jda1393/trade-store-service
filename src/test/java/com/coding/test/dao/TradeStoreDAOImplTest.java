package com.coding.test.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.InitBinder;

import com.coding.test.model.TradeObject;
import com.coding.test.model.TradesModel;
import com.coding.test.utility.StubProvider;

@SpringBootTest
public class TradeStoreDAOImplTest {
	
	@InjectMocks
	private TradeStoreDAOImpl tradeStoreDaoImpl;
	
	private HashMap<String,TradesModel> tradeStoreTest;
	
	StubProvider stubProvider = new StubProvider();
	
	@BeforeEach
	public void setUp() {
		tradeStoreTest= (HashMap<String, TradesModel>)stubProvider.getStubResponse();
		tradeStoreDaoImpl.setTradeStore(tradeStoreTest);
		
	}
	
	@Test
	public void testAddTradeInStore() {
		
		ResponseEntity resp= tradeStoreDaoImpl.addTradeInStore(getStubRequest());
		Assert.assertNotNull(resp);
	}
	
	@Test
	public void testGetAllTradesFromStore() {
		Map<String,TradesModel> testTradeStoreRes= tradeStoreDaoImpl.getAllTradesFromStore();
		Assert.assertNotNull(testTradeStoreRes);
	}
	
	
	
	
	private TradeObject getStubRequest() {
		TradeObject tobj= new TradeObject();
		TradesModel tmobj= new TradesModel();
		tobj.setTradeId("T2");
		tmobj.setVersion(1);
		tmobj.setCounterPartyId("CP-1");
		tmobj.setBookId("B1");
		tmobj.setMaturityDate(LocalDate.of(2021, 05, 25));
		tmobj.setCreatedDate(LocalDate.now());
		tmobj.setExpired("N");
		tobj.setTrade(tmobj);
		return tobj;
	}

}
