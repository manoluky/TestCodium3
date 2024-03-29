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
    public void test_isValid_with_minimum_valid_number_and_digit() {
        // Given
        long number = 1;
        char digit = '0';

        // When
        boolean isValid = Rut.isValid(number, digit);

        // Then
        assertFalse(isValid);
    }
    @Test
    public void test_isValid_with_maximum_valid_number_and_digit() {
        // Given
        long number = 99999999;
        char digit = 'K';

        // When
        boolean isValid = Rut.isValid(number, digit);

        // Then
        assertFalse(isValid);
    }
    @Test
    public void test_valueOf_with_empty_string_should_return_null() {
        // Given
        String rutEmpty = "";

        // When
        Rut rut = Rut.valueOf(rutEmpty);

        // Then
        assertNull(rut);
    }
    @Test
    public void test_valueOf_with_string_with_more_than_8_digits_should_fail() {
        // Given
        String rutString = "123456789-K";

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Rut.valueOf(rutString));

        // Then
        assertEquals("rut has an invalid format", exception.getMessage());
    }
    @Test
    public void test_invalid_digit_should_return_false() {
        // Given
        long number = 12345678;
        char digit = 'A';

        // When
        boolean isValid = Rut.isValid(number, digit);

        // Then
        assertFalse(isValid);
    }
    @Test
    public void test_isValid_with_number_less_than_minimum_valid_number_should_fail() {
        // Given
        long number = 0;
        char digit = 'K';

        // When
        boolean isValid = Rut.isValid(number, digit);

        // Then
        assertFalse(isValid);
    }
    @Test
    public void test_isValid_with_number_greater_than_maximum_valid_number_should_fail() {
        // Given
        long number = 100000000;
        char digit = '0';

        // When
        boolean isValid = Rut.isValid(number, digit);

        // Then
        assertFalse(isValid);
    }

}

