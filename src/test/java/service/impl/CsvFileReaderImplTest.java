package service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.CsvFileReader;
import service.FruitDao;

class CsvFileReaderImplTest {
    private static CsvFileReader fileReader;
    private static FruitDao fruitDao;

    @BeforeAll
    static void setUp() {
        fileReader = new CsvFileReaderImpl();
    }

    @Test
    void read_NullFilePath_notOk() {
        assertThrows(RuntimeException.class, () -> fileReader.read(null, fruitDao));
    }

    @Test
    void read_FilePathIsEmpty_notOk() {
        assertThrows(RuntimeException.class, () -> fileReader.read("", fruitDao));
    }
}
