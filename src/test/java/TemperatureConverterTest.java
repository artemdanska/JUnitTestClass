import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001);

        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001);

        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), 0.001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);

        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001);

        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), 0.001);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-50));

        assertTrue(converter.isExtremeTemperature(60));

        assertFalse(converter.isExtremeTemperature(-10));

        assertFalse(converter.isExtremeTemperature(25));
    }

    @Test
    void testKelvinToCelsius() {

        assertEquals(26.85, converter.kelvinToCelsius(300), 0.001);

        assertEquals(-273.15, converter.kelvinToCelsius(0), 0.001);

        assertEquals(36.85, converter.kelvinToCelsius(310), 0.001);
    }
}
