package com.alterach.orchestrator.config.usecase;


import com.alterach.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.alterach.orchestrator.application.core.usecase.InventoryPreparedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryPreparedConfig {
        @Bean
        public InventoryPreparedUseCase inventoryPreparedUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter){
            return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
        }

}
