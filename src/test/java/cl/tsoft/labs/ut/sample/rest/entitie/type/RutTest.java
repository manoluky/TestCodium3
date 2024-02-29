package cl.tsoft.labs.ut.sample.rest.entitie.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

    public class RutTest {


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
            char digit = 'K';

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

        // creating a new instance of Rut with invalid number should fail
        @Test
        public void test_create_rut_with_invalid_number_should_fail() {
            long number = -12345678;
            char digit = 'K';

            assertThrows(IllegalArgumentException.class, () -> new Rut(number, digit));
        }

        // creating a new instance of Rut with invalid digit should fail
        @Test
        public void test_create_rut_with_invalid_digit_should_fail() {
            long number = 12345678;
            char digit = 'A';

            assertThrows(IllegalArgumentException.class, () -> new Rut(number, digit));
        }

        // calling calculateDigit() with invalid number should fail
        @Test
        public void test_calculateDigit_with_invalid_number_should_fail() {
            long number = -12345678;

            assertThrows(IllegalArgumentException.class, () -> Rut.calculateDigit(number));
        }

    }

