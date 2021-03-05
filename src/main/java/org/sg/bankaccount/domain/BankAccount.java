package org.sg.bankaccount.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.domain
 */
public class BankAccount {
    private String IBAN;
    private Client client;
    private List<Transaction> transactions;

    public BankAccount(String IBAN, Client client, List<Transaction> transactions) {
        this.IBAN = IBAN;
        this.client = client;
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Client getClient() {
        return client;
    }

    public String getIBAN() {
        return IBAN;
    }
}
