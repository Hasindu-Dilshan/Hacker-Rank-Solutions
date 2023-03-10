import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    
        int gcd = a.get(0);
        int lcm = a.get(0);
        
        for(int i = 1; i < a.size(); i++) {
            gcd = findGCD(lcm, a.get(i));
            lcm = lcm * a.get(i) / gcd;
            System.out.println("GCD, LCM : " + gcd + " " + lcm);
        }

        
        int max_a = getMax(a);
        int min_b = getMin(b);
        
        int factor_count = 0;
        
        for(int i = lcm; i <= min_b; i += max_a) {
            int divisible_count = 0;
            
            for(int j: b) {
                
                if(j % i == 0) {
                    divisible_count++;
                }
            }
            
            if(divisible_count == b.size())
                factor_count++;
        }
        
        System.out.println();

        return factor_count;
    }
    
    private static int findGCD(int a, int b) {
        if(a == 0) {
            return b;
        }
        
        return findGCD(b % a, a);
    }
    
    private static int getMax(List<Integer> a) {
        int max = a.get(0);
        
        for(int i: a) {
            if(max < i)
                max = i;
        }
        
        return max;
    }
    
    private static int getMin(List<Integer> b) {
        int min = b.get(0);
        
        for(int i: b) {
            if(min > i)
                min = i;
        }
        
        return min;
    }
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
