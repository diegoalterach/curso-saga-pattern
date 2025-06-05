package com.alterach.inventory.config.usecase;

import com.alterach.inventory.adapters.out.UpdateInventoryAdapter;
import com.alterach.inventory.application.core.usecase.CreditInventoryUseCase;
import com.alterach.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {
    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase inventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter) {
        return new CreditInventoryUseCase(inventoryByProductIdUseCase,
                updateInventoryAdapter);
    }

}
