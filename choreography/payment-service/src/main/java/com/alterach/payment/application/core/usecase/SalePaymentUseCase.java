package com.alterach.payment.application.core.usecase;

import com.alterach.payment.application.core.domain.Payment;
import com.alterach.payment.application.core.domain.Sale;
import com.alterach.payment.application.core.domain.enums.SaleEvent;
import com.alterach.payment.application.ports.in.FindUserByIdInputPort;
import com.alterach.payment.application.ports.in.SalePaymentInputPort;
import com.alterach.payment.application.ports.out.SavePaymentOutputPort;
import com.alterach.payment.application.ports.out.SendToKafkaOutputPort;
import com.alterach.payment.application.ports.out.UpdateUserOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public SalePaymentUseCase(FindUserByIdInputPort findUserByIdInputPort, UpdateUserOutputPort updateUserOutputPort, SavePaymentOutputPort savePaymentOutputPort, SendToKafkaOutputPort sendValidatedPaymentOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendToKafkaOutputPort = sendValidatedPaymentOutputPort;
    }

    @Override
    public void payment(Sale sale){
        try {
            var user = findUserByIdInputPort.find(sale.getUserId());
            if (user.getBalance().compareTo(sale.getValue()) < 0) {
                throw new RuntimeException("Not enough money");
            }
            user.debitBalance(sale.getValue());
            updateUserOutputPort.update(user);
            savePaymentOutputPort.save(buildPayment(sale));
            sendToKafkaOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
        }catch (Exception e){
            log.error("Payment problems");
            sendToKafkaOutputPort.send(sale, SaleEvent.FAILED_PAYMENT);
        }
    }

    private Payment buildPayment(Sale sale){
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }
}
