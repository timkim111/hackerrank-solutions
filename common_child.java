// a solution to https://www.hackerrank.com/challenges/common-child on hackerrank
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int longestS(String s, String t) {
      int sLength = s.length();
      int tLength = t.length();
      int i = 0;
      int j = 0; 
      int[][] M = new int[sLength+1][tLength+1];
      for(i = sLength; i >= 0; i--) {
        M[i][0] = 0;
      }
      for(j = tLength; j >= 0; j--) {
        M[0][j] = 0;
      }
      for(i = 1; i <= sLength; i++) {
        for(j = 1; j <= tLength; j++) {
          if (s.charAt(i-1) == t.charAt(j-1)) {
            M[i][j] = 1 + M[i-1][j-1];
          }
          else {
            M[i][j] = Math.max(M[i-1][j], M[i][j-1]);
          }
        }
      } 
      return M[sLength][tLength];
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        String t = scan.nextLine().trim();
        System.out.println(longestS(s, t));
    }
}


