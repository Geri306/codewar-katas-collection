package com.codecool.abfindtheuniquestring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private static Stream<Arguments> provideRandomStringArrays() {
        return Stream.of(
                Arguments.of(new String[]{"Aa", "aaa", "aaaaa", "BbBb", "Aaaa", "AaAaAa", "a"}, "BbBb"),
                Arguments.of(new String[]{"abc", "acb", "bac", "foo", "bca", "cab", "cba"}, "foo"),
                Arguments.of(new String[]{"silvia", "vasili", "victor"}, "victor"),
                Arguments.of(new String[]{"Tom Marvolo Riddle", "I am Lord Voldemort", "Harry Potter"}, "Harry Potter"),
                Arguments.of(new String[]{"    ", "a", " "}, "a"),
                Arguments.of(new String[]{"foobar", "    ", "barfo", "fobara", "fobra", "oooofrab"}, "    ")

        );
    }

    @ParameterizedTest
    @MethodSource("provideRandomStringArrays")
    void should_return_string_that_has_different_character_than_all_other_strings(String[] arr, String expected) {

        // given

        // when
        String actual = Main.findUniq(arr);

        // then
        assertEquals(expected, actual);
    }
}