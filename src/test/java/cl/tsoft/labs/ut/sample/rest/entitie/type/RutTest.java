package cl.tsoft.labs.ut.sample.rest.entitie.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RutTest {


        // creating a new instance of Rut with valid number and digit should succeed
        @Test
        public void test_create_rut_with_valid_number_and_digit() {
            long number = 12345678;
            char digit = 'K';

            Rut rut = new Rut(number, digit);

            assertNotNull(rut);
            assertEquals(number, rut.getNumber());
            assertEquals(digit, rut.getDigit());
        }

        // calling isValid() method with valid number and digit should return true
        @Test
        public void test_isValid_with_valid_number_and_digit_should_return_true() {
            long number = 12345678;
            char digit = '5';

            Rut rut = new Rut(number, digit);

            assertTrue(rut.isValid());
        }

        // calling calculateDigit() with valid number should return a valid digit
        @Test
        public void test_calculateDigit_with_valid_number_should_return_valid_digit() {
            long number = 12345678;

            char digit = Rut.calculateDigit(number);

            assertTrue(Rut.isValid(number, digit));
        }
    @Test
    @DisplayName("create empty rut")
    void create_empty_rut() {
        // Given
        Rut rut;

        // When
        rut = new Rut();

        // Then
        assertNotNull(rut);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/valid-ruts.csv")
    @DisplayName("should return true with valid rut")
    void should_return_true_with_valid_rut(long number, char digit) {
        // Given
        Rut rut = new Rut(number, digit);

        // When
        boolean isValid = rut.isValid();

        // Then
        assertTrue(isValid);
    }

}

