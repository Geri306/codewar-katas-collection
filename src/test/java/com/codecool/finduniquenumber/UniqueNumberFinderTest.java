package com.codecool.finduniquenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

class UniqueNumberFinderTest {
    UniqueNumberFinder finder = new UniqueNumberFinder();

    public static Stream<Arguments> provideArraysWithUniqueElement() {
        return Stream.of(
                of(1, new double[]{0, 0, 1, 0, 0}),
                of(3, new double[]{-2, 3, -2, -2, -2}),
                of(3, new double[]{2, 3, 2, 2, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysWithUniqueElement")
    void should_Find_Unique_Number(double expected, double[] numbers) {
        double actual = finder.findUnique(numbers);

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> provideArraysWithoutUniqueElement() {
        return Stream.of(
                of(new double[]{0.1, 1.1, 0.1, 1.1}),
                of(new double[]{-0.1, 1.1, -0.1, 1.1}),
                of(new double[]{0, 0, 1, 1}),
                of(new double[]{0, 0, 1, 1, 2, 2})
        );

    }

    @ParameterizedTest
    @MethodSource("provideArraysWithoutUniqueElement")
    void shouldThrowExceptionIfNoUniqueElement(double[] numbers) {
        assertThrows(NoSuchElementException.class, () -> finder.findUnique(numbers));
    }
}