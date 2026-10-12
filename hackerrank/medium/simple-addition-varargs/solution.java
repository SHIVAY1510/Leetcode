import java.io.*;
import java.util.*;

class Add{
    void add(int a, int b){
        int sum=a+b;
        System.out.println(a+"+"+b+"="+sum);
    }
    void add(int a,int b,int c){
        int sum=a+b+c;
        System.out.println(a+"+"+b+"+"+c+"="+sum);
    }
    void add(int a,int b,int c,int d,int e){
        int sum=a+b+c+d+e;
        System.out.println(a+"+"+b+"+"+c+"+"+d+"+"+e+"="+sum);
    }
    void add(int a,int b,int c,int d,int e,int f){
        int sum=a+b+c+d+e+f;
        System.out.println(a+"+"+b+"+"+c+"+"+d+"+"+e+"+"+f+"="+sum);
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int e=sc.nextInt();
        int f=sc.nextInt();
        Add ob=new Add();
        ob.add(a,b);
        ob.add(a, b,c);
        ob.add(a, b,c,d,e);
        ob.add(a, b,c,d,e,f);
    }
}
