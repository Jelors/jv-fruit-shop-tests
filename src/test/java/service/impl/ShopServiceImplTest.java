package service.impl;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.ShopService;

class ShopServiceImplTest {
    private static ShopService shopService;

    @BeforeAll
    static void setUp() {
        shopService = new ShopServiceImpl(null);
    }

    @Test
    void process_nullInputList_notOk() {
        assertThrows(RuntimeException.class, () -> shopService.process(null));
    }

    @Test
    void process_fruitTransactionObjectIsNull_notOk() {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        fruitTransactionList.add(null);
        assertThrows(RuntimeException.class, () -> shopService.process(fruitTransactionList));
    }

    @Test
    void process_fruitNameEqualsNull_notOk() {
        List<FruitTransaction> transactionList = List.of(
                new FruitTransaction(FruitTransaction.Operation.BALANCE, null, 25));
        assertThrows(RuntimeException.class, () -> shopService.process(transactionList));
    }
}
