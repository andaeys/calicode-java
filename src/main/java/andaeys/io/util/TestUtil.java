package andaeys.io.util;

public class TestUtil {

    public static <T> void test(T input, T expected, T result){
        System.out.println("result: "+result+" | correct: "+(expected.equals(result)));
        assert expected.equals(result);
    }

    public static <T> void test(T[] input, T expected, T result){
        System.out.println("result: "+result+" | correct: "+(expected.equals(result)));
        assert expected.equals(result);
    }

    public static <T> void test(T[] input1, T[] input2, T expected, T result){
        System.out.println("result: "+result+" | correct: "+(expected.equals(result)));
        assert expected.equals(result);
    }

    public static <T> void test(T[] input1, T input2, T expected, T result){
        System.out.println("result: "+result+" | correct: "+(expected.equals(result)));
        assert expected.equals(result);
    }

    public static <T> void test(T input1, T input2,T input3,T expected, T result){
        System.out.println("result: "+result+" | correct: "+(expected.equals(result)));
        assert expected.equals(result);
    }
}
