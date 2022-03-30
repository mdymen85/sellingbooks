package com.bookstore.payment2.aggregator;

import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.store.MessageGroup;

@MessageEndpoint
public class ConstumReleaseStrtegy implements ReleaseStrategy{

	@Override
	public boolean canRelease(MessageGroup group) {
		// TODO Auto-generated method stub
		return false;
	}

}
