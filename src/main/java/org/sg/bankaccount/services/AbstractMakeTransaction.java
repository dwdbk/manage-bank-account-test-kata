package org.sg.bankaccount.services;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.domain.Transaction;
import org.sg.bankaccount.domain.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.services
 */
public abstract class AbstractMakeTransaction {
    public static String ERROR_MESSAGE = "Unauthorized Value";

    public void makeTransaction(BankAccount bankAccount, BigDecimal amout, String label) throws IllegalArgumentException {
        if (amout.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        Transaction transaction = new Transaction(getTransactionType(), amout, label, OffsetDateTime.now());
        bankAccount.getTransactions().add(transaction);
    };

    public abstract TransactionTypeEnum getTransactionType();

    public abstract boolean isNegativeValuePossible();

}
