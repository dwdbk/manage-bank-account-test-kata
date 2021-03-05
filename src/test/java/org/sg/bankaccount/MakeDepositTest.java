package org.sg.bankaccount;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.factory.BankAccountTestFactory;
import org.sg.bankaccount.services.AbstractMakeTransaction;
import org.sg.bankaccount.services.GetAccountBalance;
import org.sg.bankaccount.services.MakeDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount
 */
public class MakeDepositTest {
    private MakeDeposit makeDeposit;

    @BeforeEach
    void beforeEach() {
        makeDeposit = new MakeDeposit();
    }


    @Test
    void should_calculate_new_balance_after_deposit_transaction() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When
        makeDeposit.makeTransaction(bankAccount, new BigDecimal(25), "Deposit 25 euros");

        // Then
        assertEquals(new BigDecimal(35), GetAccountBalance.getAccountBalance(bankAccount));
    }

    @Test
    void should_throw_exception_when_negative_amount() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> makeDeposit.makeTransaction(bankAccount, new BigDecimal(25).negate(), "Deposit 25 euros"));

        // Then
        assertTrue(exception instanceof IllegalArgumentException);

        assertEquals(exception.getMessage(), AbstractMakeTransaction.ERROR_MESSAGE);

    }


}
