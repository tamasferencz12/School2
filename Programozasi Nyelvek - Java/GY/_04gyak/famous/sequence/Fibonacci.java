package _04gyak.famous.sequence;

public class Fibonacci{
    public static int fib(int n){
        return n == 0 ? 0 : n == 1 ? 1 : fib(n-1) + fib(n-2);
    }
}

// javac ./_04gyak/famous/sequence/Fibonacci.java 
//  -- forditjuk a tesztelendo Fibonacci.java-t
//javac -cp .:junit5all.jar:checkthat.jar ./_04gyak/famous/sequence/FibonacciStructureTest.java 
//  -- forditjuk a FibonacciStructureTest.java-t :junit5all.jar:checkthat.jar ezek segitsegevel(eszkozkeszletek), ugy hogy nezze az eddig forditottakat ".:"
//java -jar junit5all.jar -cp .:checkthat.jar -c _04gyak.famous.sequence.FibonacciStructureTest
//  -- Testelest futtatjuk -c vel hozzafuzzuk a testelendo filet