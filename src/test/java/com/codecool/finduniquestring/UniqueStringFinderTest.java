package com.codecool.finduniquestring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class UniqueStringFinderTest {

    UniqueStringFinder uniqueStringFinder = new UniqueStringFinder();

    private static Stream<Arguments> provideRandomStringArrays() {
        return Stream.of(
                of("a", new String[]{"a", "b", "b"}),
                of("a", new String[]{"b", "a", "b"}),
                of("a", new String[]{"b", "b", "a"}),
                of("a", new String[]{"b", "b ", "a"}),
                of("a", new String[]{"b", " b", "a"}),
                of("a", new String[]{"b", " b ", "a"}),
                of("a", new String[]{"b", " b    ", "a"}),
                of("a", new String[]{"bb", "bb", "a"}),
                of("a", new String[]{"bb ", " b  b  ", "a"}),
                of("x", new String[]{"abc ", " a  b       c ", "x", "abc"}),
                of("BbBb", new String[]{"Aa", "aaa", "aaaaa", "BbBb", "Aaaa", "AaAaAa", "a"}),
                of("foo", new String[]{"abc", "acb", "bac", "foo", "bca", "cab", "cba"}),
                of("victor", new String[]{"silvia", "vasili", "victor"}),
                of("Harry Potter", new String[]{"Tom Marvolo Riddle", "I am Lord Voldemort", "Harry Potter"}),
                of("a", new String[]{"    ", "a", " "}),
                of("    ", new String[]{"foobar", "    ", "barfo", "fobara", "fobra", "oooofrab"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideRandomStringArrays")
    void shouldReturnStringThatHasDifferentCharacterThanAllOtherStrings(String expected, String[] strings) {
        String actual = uniqueStringFinder.findUnique(strings);

        assertEquals(expected, actual);
    }

    @Test
    void throwsExceptionIfNoSingleUniqueStringElementInArray() {
        String[] strings = {"asd", "asd", "qwe", "qwe"};

        assertThrows(NoSuchElementException.class, () -> uniqueStringFinder.findUnique(strings));
    }
}