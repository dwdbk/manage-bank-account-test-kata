package org.sg.bankaccount;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.domain.TransactionTypeEnum;
import org.sg.bankaccount.factory.BankAccountTestFactory;
import org.sg.bankaccount.printers.impl.BankAccountPrinter;
import org.sg.bankaccount.printers.Printer;
import org.sg.bankaccount.services.GetAccountBalance;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount
 */
class BankAccountTest {

    private Printer<BankAccount> bankAccountPrinter = new BankAccountPrinter();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void beforeTests() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterTests() {
        System.setOut(originalOut);
        System.out.print(outContent);
    }

    @Test
    void should_retrieve_ten_as_the_first_deposit() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When
        BigDecimal balance = GetAccountBalance.getAccountBalance(bankAccount);

        // Then
        assertEquals(new BigDecimal(10), balance);
    }

    @Test
    void should_calculate_bank_account_balance() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_multiple_transaction();

        // When
        BigDecimal balance = GetAccountBalance.getAccountBalance(bankAccount);

        // Then
        assertNotNull(balance);
    }

    @Test
    void should_print_transactions_history() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_multiple_transaction();

        // When

        // Then
        bankAccountPrinter.print(bankAccount);
        assertNotNull(bankAccount);

        assertTrue(outContent.toString().contains(BankAccountTestFactory.AMOUNT.toString()));

        assertTrue(outContent.toString().contains(BankAccountTestFactory.DAOUD));

        assertTrue(outContent.toString().contains(BankAccountTestFactory.BALLOUK));

        assertTrue(outContent.toString().contains(BankAccountTestFactory.IBAN));

        assertTrue(outContent.toString().contains(TransactionTypeEnum.DEPOSIT.toString()));
    }
}