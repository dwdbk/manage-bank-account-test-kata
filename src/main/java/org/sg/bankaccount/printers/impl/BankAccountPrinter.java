package org.sg.bankaccount.printers.impl;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.domain.Client;
import org.sg.bankaccount.domain.Transaction;
import org.sg.bankaccount.domain.TransactionTypeEnum;
import org.sg.bankaccount.domain.HistoryLine;
import org.sg.bankaccount.printers.Printer;
import org.sg.bankaccount.utils.TransformBankAccountToHistoryLine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.impl.printers
 */
public class BankAccountPrinter implements Printer<BankAccount> {

    public static final String IBAN = "IBAN : ";

    private final Printer<Client> clientPrinter;
    private final Printer<List<HistoryLine>> historyLinePrinterPrinter;

    public BankAccountPrinter() {
        clientPrinter = new ClientPrinter();
        historyLinePrinterPrinter = new HistoryLinePrinter();
    }

    @Override
    public void print(BankAccount bankAccount) {

        clientPrinter.print(bankAccount.getClient());

        System.out.println();

        System.out.println(IBAN + bankAccount.getIBAN());

        System.out.println();

        historyLinePrinterPrinter.print(TransformBankAccountToHistoryLine.transform(bankAccount));
    }


}
