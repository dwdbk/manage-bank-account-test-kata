package org.sg.bankaccount.utils;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.domain.HistoryLine;
import org.sg.bankaccount.domain.Transaction;
import org.sg.bankaccount.domain.TransactionTypeEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.utils
 */
public class TransformBankAccountToHistoryLine {

    public static List<HistoryLine> transform(BankAccount bankAccount) {
        Iterator<Transaction> iterator = bankAccount.getTransactions().iterator();

        BigDecimal balance = BigDecimal.ZERO;

        List<HistoryLine> historyLines = new ArrayList<HistoryLine>();

        while (iterator.hasNext()) {
            Transaction transaction = iterator.next();
            balance = transaction.getTransactionTypeEnum()
                    .equals(TransactionTypeEnum.DEPOSIT) ?
                    balance.add(transaction.getAmount()) :
                    balance.subtract(transaction.getAmount());
            historyLines.add(new HistoryLine(transaction, balance));

        }

        return historyLines;
    }
}
