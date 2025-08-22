package service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CsvFileWriter;

class CsvFileWriterImplTest {
    private static CsvFileWriter fileWriter;

    @BeforeEach
    void setUp() {
        fileWriter = new CsvFileWriterImpl();
    }

    @Test
    void write_NullContent_notOk() {
        assertThrows(RuntimeException.class, () -> fileWriter.write(null, "file.csv"));
    }

    @Test
    void write_NullFilePath_notOk() {
        assertThrows(RuntimeException.class, () -> fileWriter.write("content", null));
    }

    @Test
    void write_ContentEmpty_notOK() {
        assertThrows(RuntimeException.class, () -> fileWriter.write("", "file.csv"));
    }

    @Test
    void write_FilePathEmpty_notOk() {
        assertThrows(RuntimeException.class, () -> fileWriter.write("content", ""));
    }
}
