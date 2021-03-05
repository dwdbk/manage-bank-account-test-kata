package org.sg.bankaccount.services;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.domain.TransactionTypeEnum;

import java.math.BigDecimal;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.services
 */
public class GetAccountBalance {

    public static BigDecimal getAccountBalance(BankAccount bankAccount) {
        BigDecimal result = bankAccount.getTransactions()
                .stream()
                .map(transaction -> {
                    if (transaction.getTransactionTypeEnum().equals(TransactionTypeEnum.WITHDRAWAL)) {
                        return transaction.getAmount().negate();
                    }
                    return transaction.getAmount();
                })
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        return result;
    }
}
