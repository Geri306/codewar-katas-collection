package com.codecool.aafindtheuniquenumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void should_return_1() {

        // given
        double[] arr = {0, 0, 1, 0, 0};
        double expected = 1;

        // when
        double actual = Main.findUniq(arr);

        // then
        assertEquals(expected, actual);
    }
}