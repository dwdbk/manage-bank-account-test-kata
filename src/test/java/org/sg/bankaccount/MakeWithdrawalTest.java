package org.sg.bankaccount;

import org.sg.bankaccount.domain.BankAccount;
import org.sg.bankaccount.factory.BankAccountTestFactory;
import org.sg.bankaccount.services.GetAccountBalance;
import org.sg.bankaccount.services.MakeWithdrawal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount
 */
public class MakeWithdrawalTest {
    private MakeWithdrawal makeWIthdrawal;

    @BeforeEach
    void beforeEach() {
        makeWIthdrawal = new MakeWithdrawal();
    }


    @Test
    void should_calculate_new_balance_after_deposit_transaction() throws Exception {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When
        makeWIthdrawal.makeTransaction(bankAccount, new BigDecimal(35), "Withdrawal 35 euros");

        // Then
        assertEquals(new BigDecimal(-25), GetAccountBalance.getAccountBalance(bankAccount));
    }
}
