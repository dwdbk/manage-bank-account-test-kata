package org.sg.bankaccount.services;

import org.sg.bankaccount.domain.TransactionTypeEnum;

import java.math.BigDecimal;

/**
 * Created by daoud Ballouk, on 05/03/2021, in org.sg.bankaccount.services
 */
public class MakeWithdrawal extends AbstractMakeTransaction {

    @Override
    public TransactionTypeEnum getTransactionType() {
        return TransactionTypeEnum.WITHDRAWAL;
    }

    @Override
    public boolean isNegativeValuePossible() {
        return false;
    }


}
