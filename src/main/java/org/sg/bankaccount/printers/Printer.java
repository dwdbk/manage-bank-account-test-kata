package org.sg.bankaccount.printers;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.printers
 */
public interface Printer<T> {
    static final String PRINTING_PATTERN = "%-40s | ";

    void print(T toPrint);
}
