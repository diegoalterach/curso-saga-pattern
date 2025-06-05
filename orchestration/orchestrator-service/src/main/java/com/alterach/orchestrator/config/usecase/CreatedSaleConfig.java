package com.alterach.orchestrator.config.usecase;


import com.alterach.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.alterach.orchestrator.application.core.usecase.CreatedSaleUseCase;
import com.alterach.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatedSaleConfig {
        @Bean
        public CreatedSaleUseCase createdSaleUseCase (SendSaleToTopicAdapter sendSaleToTopicAdapter){
            return new CreatedSaleUseCase(sendSaleToTopicAdapter);
        }

}
