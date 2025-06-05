package com.alterach.sale.config.usecase;

import com.alterach.sale.adapters.out.SaveSaleAdapter;
import com.alterach.sale.application.core.usecase.CancelSaleUseCase;
import com.alterach.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(FindSaleByIdUseCase findSaleByIdUseCase,
                                                SaveSaleAdapter saveSaleAdapter){
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }


}
