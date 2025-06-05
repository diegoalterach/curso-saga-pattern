package com.alterach.inventory.config.usecase;

import com.alterach.inventory.adapters.out.FindInventoryByProductIdAdapter;
import com.alterach.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase inventoryByProductIdUseCase(FindInventoryByProductIdAdapter findInventoryByProductIdAdapter){
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }
}
