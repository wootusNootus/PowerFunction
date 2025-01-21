public class PowerFunctions {
    public static void main(String[] args) throws Exception {
        System.err.println("Naive Power Function Check: " + ((naivePower(2,3) == 8) ? "Correct" : "Incorrect"));
        System.err.println("Unoptimized DC Power Function Check: " + ((unoptimizedDCPower(2,3) == 8) ? "Correct" : "Incorrect"));
        System.err.println("Optimized DC Power Function Check: " + ((optimizedDCPower(2,3) == 8) ? "Correct" : "Incorrect"));
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
}
