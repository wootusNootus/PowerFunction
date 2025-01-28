public class PowerFunctions {
    public static void main(String[] args) throws Exception {
        System.err.println("Naive Power Function Check: " + ((naivePower(2,3) == 8) ? "Correct" : "Incorrect"));
        System.err.println("Unoptimized DC Power Function Check: " + ((unoptimizedDCPower(2,3) == 8) ? "Correct" : "Incorrect"));
        System.err.println("Optimized DC Power Function Check: " + ((optimizedDCPower(2,3) == 8) ? "Correct" : "Incorrect"));

        // Testing for large x
        System.out.println("Testing large x value execution time:");
        testRuntime(() -> naivePower(1_000_000, 10));
        testRuntime(() -> unoptimizedDCPower(1_000_000, 10));
        testRuntime(() -> optimizedDCPower(1_000_000, 10));

        // Testing for large n
        System.out.println("Testing large x value execution time:");
        testRuntime(() -> naivePower(2, 10000));
        testRuntime(() -> unoptimizedDCPower(2, 10000));
        testRuntime(() -> optimizedDCPower(2, 10000));
    }

    public static int naivePower(int x, int n){
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        return x * naivePower(x, n - 1);
    }

    public static int unoptimizedDCPower(int x, int n){
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n % 2 == 0){
            return unoptimizedDCPower(x, n/2) * unoptimizedDCPower(x, n/2);
        }
        else{
            return x * unoptimizedDCPower(x, n/2) * unoptimizedDCPower(x, n/2);
        }
    }

    public static int optimizedDCPower(int x, int n){
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }

        int temp = optimizedDCPower(x, n/2);
        if(n % 2 == 0){
            return temp * temp;
        }
        else{
            return x * temp * temp;
        }
    }

    // Used the following website for tutorial
    // https://www.tutorialspoint.com/how-to-implement-the-runnable-interface-using-lambda-expression-in-java
    public static void testRuntime(Runnable function) {
        // Testing runtime for x
        long startTime = System.nanoTime();

        // Running the function
        function.run();

        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1_000_000.0;
        System.out.println("Execution time: "+ duration + "ms");
    }
}
