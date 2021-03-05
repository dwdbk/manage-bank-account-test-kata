package org.sg.bankaccount.printers.impl;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.domain.Client;
import org.sg.bankaccount.printers.Printer;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.impl.printers
 */
public class ClientPrinter implements Printer<Client> {


    public static final String NAME = "Name";
    public static final String LAST = "Last";
    public static final String BIRTH_DATE = "Birth Date";
    public static final String YYYYMMDD = "YYYYMMDD";

    @Override
    public void print(Client toPrint) {
        System.out.println(String.format(PRINTING_PATTERN + PRINTING_PATTERN+ PRINTING_PATTERN, NAME, LAST, BIRTH_DATE));
        System.out.println(
                        String.format(
                                PRINTING_PATTERN + PRINTING_PATTERN+ PRINTING_PATTERN,
                                toPrint.getName(),
                                toPrint.getLastName(),
                                formatDate(toPrint.getBirthDate())
                        )
        );
    }

    private String formatDate(OffsetDateTime offsetDateTime) {
        return offsetDateTime.format(DateTimeFormatter.ofPattern(YYYYMMDD));
    }
}
