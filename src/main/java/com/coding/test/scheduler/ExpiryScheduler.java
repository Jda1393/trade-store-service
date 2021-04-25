package com.coding.test.scheduler;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.coding.test.model.TradesModel;

@Component
public class ExpiryScheduler {
	
	//@Scheduled(cron = "10 * * * * *")
	//public void updateExpiry() {
		//System.out.println("In scheduler");
		/*Map<Object,Object> filteredMap=tradeStore.entrySet().stream().filter(map->map.getValue().getMaturityDate().isEqual(LocalDate.now())).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		for(Map.Entry<Object, Object> entry: filteredMap.entrySet()) {
			TradesModel expiredTrade= (TradesModel)entry.getValue();
			expiredTrade.setExpired("Y");
			tradeStore.put((String)entry.getKey(), expiredTrade);
		}*/
		
	//}

}
