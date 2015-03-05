//a solution to https://www.hackerrank.com/challenges/is-fibo on hackerrank
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long find_max(long[] array) {
        long largest_number = Long.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest_number) {
                largest_number = array[i];
            }
        }
        return largest_number;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine().trim());
        long[] nums = new long[T];
        for (int i = 0; i < T; i++) {
            nums[i] = Long.parseLong(scan.nextLine().trim());
        }
        
        long largest_number = find_max(nums);
        HashMap<Long, Long> fib_map = new HashMap<Long, Long>();
        fib_map.put(0l, 0l);
        fib_map.put(1l, 1l);
        long n = 2;
        while (fib_map.get(n - 1) < largest_number) {
            fib_map.put(n, fib_map.get(n - 1) + fib_map.get(n - 2));
            n++;
        }
        Collection<Long> fibs = fib_map.values();
        for (int i = 0; i < T; i++) {
            if (fibs.contains(nums[i])) {
                System.out.println("IsFibo");
            }
            else {
                System.out.println("IsNotFibo");
            }
        }
    }
}
