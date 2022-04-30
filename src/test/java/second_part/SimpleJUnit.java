package second_part;

import org.junit.jupiter.api.*;

import java.lang.reflect.*;


public class SimpleJUnit {

    public static void main(String[] args)  throws Exception{
        Method beforeAll = null;
        Method beforeEach = null;
        Method afterAll = null;
        Method afterEach = null;
        Method[] declaredMethods = ExampleTestsForSimpleJUnit.class.getDeclaredMethods();

        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (method.getAnnotation(BeforeEach.class) != null) {
                beforeEach = method;
            }
            if (method.getAnnotation(BeforeAll.class) != null) {
                beforeAll = method;
            }
            if (method.getAnnotation(AfterEach.class) != null) {
                afterEach = method;
            }
            if (method.getAnnotation(AfterAll.class) != null) {
                afterAll = method;
            }
        }

        runMethodWithAnnotation(beforeAll);

        for (Method method : declaredMethods) {
            method.setAccessible(true);
            Test testAnnotation = method.getAnnotation(Test.class);
            Disabled disabled = method.getAnnotation(Disabled.class);
            if(testAnnotation != null && disabled == null){
                runMethodWithAnnotation(beforeEach);
                try{
                    method.invoke(ExampleTestsForSimpleJUnit.class.getDeclaredConstructor().newInstance());
                } catch (InvocationTargetException e) {
                    System.out.println("Тест упал: " + e.getCause().getMessage());
                    e.printStackTrace();
                }
                runMethodWithAnnotation(afterEach);
            }
        }
        runMethodWithAnnotation(afterAll);
    }

    static void runMethodWithAnnotation(Method method) throws Exception {
        if (method != null) {
            try {
                method.invoke(ExampleTestsForSimpleJUnit.class.getDeclaredConstructor().newInstance());
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
