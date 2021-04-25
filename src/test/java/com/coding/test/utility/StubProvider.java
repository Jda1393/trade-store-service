package com.coding.test.utility;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coding.test.model.TradesModel;

public class StubProvider {
	
	public ResponseEntity postStubSuccessResponse() {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	public ResponseEntity postStubResponseInvalidVersion() {
		return new ResponseEntity<>("Version is Invalid",HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity postStubResponseInvalidMaturityDate() {
		return new ResponseEntity<>("Maturity Date is invalid",HttpStatus.BAD_REQUEST);
	}
	
	public Map<String,TradesModel> getStubResponse(){
		Map<String,TradesModel> testMap=new HashMap<>();
		TradesModel tm=new TradesModel();
		tm.setVersion(1);
		tm.setCounterPartyId("CP-1");
		tm.setBookId("B1");
		tm.setMaturityDate(LocalDate.of(2021, 05, 25));
		tm.setCreatedDate(LocalDate.now());
		tm.setExpired("N");
		testMap.put("T1", tm);
		return testMap;
		
	}

}
