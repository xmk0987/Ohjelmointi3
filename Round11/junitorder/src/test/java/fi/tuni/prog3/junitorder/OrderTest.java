package fi.tuni.prog3.junitorder;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class OrderTest {

    @Test
    void testisEmpty(){

    }

    @Test
    void testaddItems(){

        Order.Item testi = new Order.Item("pieru", 5);

        assertThrows(IllegalArgumentException.class, () ->
                new Order.Item("pieru", -2));

        assertThrows(IllegalStateException.class, () ->
                new Order.Item("pieru", 3));

        assertThrows(NoSuchElementException.class, () ->
                new Order.Item("paska", -2));
    }


}
