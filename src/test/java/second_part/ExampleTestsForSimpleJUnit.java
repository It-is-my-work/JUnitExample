package second_part;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTestsForSimpleJUnit {

    @BeforeAll
    static void exampleBeforeAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void exampleBeforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void exampleAfterEach() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void exampleAfterAll() {
        System.out.println("AfterAll");
    }

    @Test
    void exampleTest1() {
        System.out.println("Test 1");
        assertTrue(true);
    }

    @Test
    void exampleTest2() {
        System.out.println("Test 2");
        assertTrue(true);
    }
}
