package com.bookstore.payment2.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.NullChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.channel.RendezvousChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class CacheConfig {
	
	@Bean(name = "channelTest")
	public MessageChannel get() {
		return new DirectChannel();
	//	return MessageChannels.direct().wireTap("channelTest").get();
	}
	


//	@Bean
//	public CacheManager getCacheManager() {
//		return new SimpleCacheManager();
//	}
	
}
