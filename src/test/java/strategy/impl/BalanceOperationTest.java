package strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.FruitTransaction;
import org.junit.jupiter.api.Test;
import strategy.OperationHandler;

class BalanceOperationTest {

    @Test
    void getOperation_nullData_notOk() {
        OperationHandler balanceOperation = new BalanceOperation();
        assertThrows(RuntimeException.class, () -> balanceOperation.getOperation(null, 0));
    }

    @Test
    void getOperation_correctInput_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler balanceOperation = new BalanceOperation();
        fruitTransaction.setQuantity(25);
        assertEquals(25, balanceOperation.getOperation(fruitTransaction, 0));
    }

    @Test
    void getOperation_returnsCorrectQuantity_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler balanceOperation = new BalanceOperation();
        fruitTransaction.setQuantity(25);
        assertEquals(fruitTransaction.getQuantity(),
                balanceOperation.getOperation(fruitTransaction,0));
    }
}
