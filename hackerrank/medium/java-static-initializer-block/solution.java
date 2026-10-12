import java.io.*;
import java.util.*;

public class Solution {
    static int area;

    static {
        Scanner sc = new Scanner(System.in);
        int B = sc.nextInt();
        int H = sc.nextInt();

        try {
            if (B <= 0 || H <= 0) {
                throw new Exception("Breadth and height must be positive");
            }
            area = B * H;
        } catch (Exception e) {
            System.out.print(e);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            System.out.print(area);
    }
}
