class Solution {
    public int reverse(int x) {
       int reverse=0;
       while(x!=0){
        int d=x%10;
        if(reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && d > 7)) {
            return 0;
        }
        if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && d < -8)) {
            return 0;
        }
        reverse=reverse*10+d;
        x/=10;
       }
       return reverse;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x= sc.nextInt();
        Solution sol = new Solution();      
        int result = sol.reverse(x); 
        System.out.println(result);
    }
}