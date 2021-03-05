package org.sg.bankaccount.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.domain
 */
public class Transaction {
    private TransactionTypeEnum transactionTypeEnum;
    private BigDecimal amount;
    private String label;
    private OffsetDateTime createdDate;

    public Transaction(TransactionTypeEnum transactionTypeEnum, BigDecimal amount, String label, OffsetDateTime createdDate) {
        this.transactionTypeEnum = transactionTypeEnum;
        this.amount = amount;
        this.label = label;
        this.createdDate = createdDate;
    }

    public TransactionTypeEnum getTransactionTypeEnum() {
        return transactionTypeEnum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getLabel() {
        return label;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }
}
