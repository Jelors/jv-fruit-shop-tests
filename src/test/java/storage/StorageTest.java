package storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StorageTest {

    @Test
    void storage_storeCorrectly() {
        Storage.getFruitDbResult().put("banana", 42);

        assertEquals(42, Storage.getFruitDbResult().get("banana"));
    }
}
