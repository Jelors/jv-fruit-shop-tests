package strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.FruitTransaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import strategy.OperationHandler;

class ReturnOperationTest {
    private static OperationHandler operation;

    @BeforeAll
    static void setUp() {
        operation = new ReturnOperation();
    }

    @Test
    void getOperation_nullData_notOk() {
        assertThrows(RuntimeException.class, () -> operation.getOperation(null, 0));
    }

    @Test
    void getOperation_negativeAmount_notOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        assertThrows(RuntimeException.class, () -> operation.getOperation(fruitTransaction, -50));
    }

    @Test
    void getOperation_negativeDataQuantity_notOK() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setQuantity(-50);
        assertThrows(RuntimeException.class, () -> operation.getOperation(fruitTransaction, 20));
    }

    @Test
    void getOperation_returnsCorrectQuantity_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setQuantity(20);
        assertEquals(40, operation.getOperation(fruitTransaction,20));
    }
}
