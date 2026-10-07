class Solution {
    int getsum(int n){
         int sum=0;
         int digit=0;
            while(n>0){
                digit=n%10;
                sum+=digit*digit;
                n=n/10;
            }
            return sum;
        }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=getsum(slow);
            fast=getsum(getsum(fast));
        }while(slow!=fast);
        return slow==1;
    }
}