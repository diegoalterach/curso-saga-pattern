package com.alterach.orchestrator.application.core.domain.enums;

public enum SaleEvent {
    CREATED_SALE,
    CANCEL_SALE,
    FINALIZE_SALE,
    EXECUTE_PAYMENT,
    PAYMENT_EXECUTED,
    PAYMENT_FAILED,
    PREPARE_INVENTORY,
    INVENTORY_PREPARED,
    EXECUTE_ROLLBACK,
    INVENTORY_ERROR;
}
