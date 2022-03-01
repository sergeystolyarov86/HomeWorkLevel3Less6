import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Tests {
    TestApp testsApp;

    @BeforeEach
    void init() {
        testsApp = new TestApp();
    }


    @Test
    @DisplayName("тест с правильным массивом method1")
    public void testMethod1() {
        int[] expected = new int[]{1, 7};
        int[] arr = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] actual = testsApp.method1(arr);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("тест на Exception с массивом без 4 method1")
    public void testExceptionMethod1() {
        int[] arr = {1, 2, 3};
        Assertions.assertThrows(RuntimeException.class, () -> testsApp.method1(arr));
    }

    @ParameterizedTest
    @MethodSource("dataForTestTrueArrays")
    @DisplayName(" тестирование method1 через MethodSource")
    public void testTrueArraysMethod1(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, testsApp.method1(array));
    }

    public static Stream<Arguments> dataForTestTrueArrays() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{5, 13, 4, 2}, new int[]{2}));
        out.add(Arguments.arguments(new int[]{2, 2, 2, 8, 4}, new int[]{}));
        out.add(Arguments.arguments(new int[]{4, 1, 5, 3, 2, 3}, new int[]{1, 5, 3, 2, 3}));
        out.add(Arguments.arguments(new int[]{10, 10, 5, 6, 4, 7, 8, 9}, new int[]{7, 8, 9}));
        out.add(Arguments.arguments(new int[]{10, 5, 4, 4, 7, 8, 6}, new int[]{7, 8, 6}));
        return out.stream();
    }

    @Test
    @DisplayName("тест с правильным массивом method2")
    public void testMethod2TrueArr() {
        int[] arr = new int[]{1, 1, 4, 4, 4, 4, 4, 1};
        boolean val = testsApp.method2(arr);
        Assertions.assertTrue(val);
    }
    @Test
    @DisplayName("тест с неправильным массивом method2")
    public void testMethod2FalseArr() {
        int[] arr = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        boolean val = testsApp.method2(arr);
        Assertions.assertFalse(val);
    }

    @ParameterizedTest
    @MethodSource("dataForTestArrays")
    @DisplayName(" тест method2 с помощью MethodSource")
    public void testMethod2Arrays(int[] array, boolean result) {
        Assertions.assertEquals(result, testsApp.method2(array));
    }

    public static Stream<Arguments> dataForTestArrays() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{5, 13, 4, 2}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{8, 6, 5, 3, 2, 3}, false));
        out.add(Arguments.arguments(new int[]{10, 1, 4, 4, 1, 4, 1}, false));
        out.add(Arguments.arguments(new int[]{1, 1, 4, 4, 1, 4, 1}, true));
        out.add(Arguments.arguments(new int[]{}, false));
        return out.stream();
    }


}
