package org.sg.bankaccount.domain;

import org.sg.bankaccount.domain.Transaction;

import java.math.BigDecimal;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.domain
 */
public class HistoryLine {
    private Transaction transaction;
    private BigDecimal balance;

    public HistoryLine(Transaction transaction, BigDecimal balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
