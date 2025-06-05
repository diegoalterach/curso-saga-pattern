package com.alterach.inventory.config.usecase;

import com.alterach.inventory.adapters.out.SendToKafkaAdapter;
import com.alterach.inventory.adapters.out.UpdateInventoryAdapter;
import com.alterach.inventory.application.core.usecase.DebitInventoryUseCase;
import com.alterach.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {
    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase inventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter) {
        return new DebitInventoryUseCase(inventoryByProductIdUseCase,
                updateInventoryAdapter,
                sendToKafkaAdapter);
    }

}
