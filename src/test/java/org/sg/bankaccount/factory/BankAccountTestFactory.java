package org.sg.bankaccount.factory;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.domain.Client;
import org.sg.bankaccount.domain.Transaction;
import org.sg.bankaccount.domain.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.factory
 */
public class BankAccountTestFactory {


    public static final BigDecimal AMOUNT = new BigDecimal(10);
    public static final String FIRST_DEPOSIT = "First deposit";
    public static final String IBAN = "FR68BARC20040163953777";
    public static final String DAOUD = "Daoud";
    public static final String BALLOUK = "Ballouk";

    private BankAccountTestFactory() {
        // Do nothing
    }

    public static BankAccount a_bank_account_with_deposit_transaction_of_ten() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(
                TransactionTypeEnum.DEPOSIT,
                AMOUNT,
                FIRST_DEPOSIT,
                OffsetDateTime.now()));
        return new BankAccount(
                IBAN,
                new Client(DAOUD, BALLOUK, OffsetDateTime.now()),
                transactions
        );
    }

    public static BankAccount a_bank_account_with_multiple_transaction() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(
                TransactionTypeEnum.DEPOSIT,
                new BigDecimal(100),
                FIRST_DEPOSIT,
                OffsetDateTime.now()));

        transactions.add(new Transaction(
                TransactionTypeEnum.WITHDRAWAL,
                new BigDecimal(20),
                FIRST_DEPOSIT,
                OffsetDateTime.now()));

        transactions.add(new Transaction(
                TransactionTypeEnum.WITHDRAWAL,
                new BigDecimal(35),
                FIRST_DEPOSIT,
                OffsetDateTime.now()));

        transactions.add(new Transaction(
                TransactionTypeEnum.DEPOSIT,
                new BigDecimal(12),
                FIRST_DEPOSIT,
                OffsetDateTime.now()));
        return new BankAccount(
                IBAN,
                new Client(DAOUD, BALLOUK, OffsetDateTime.now()),
                transactions
        );
    }


}
