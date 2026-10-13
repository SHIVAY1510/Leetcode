class Solution {
    public int[] productExceptSelf(int[] nums) {
    //     int n=nums.length;
    //     int[] ans=new int[nums.length];
    //   for(int i=0;i<n;i++){
    //     int p=1;
    //     for(int j=0;j<n;j++){
    //       if(i==j){
    //        continue;
    //       } 
    //       p*=nums[j];
    //     }
    //     ans[i]=p;
    //   }
    //   return ans;
    // int n=nums.length;
    // int[] prefix=new int[nums.length];
    // prefix[0]=1;
    // int suffix=1;
    // for(int i=1;i<n;i++){
    //     prefix[i]=prefix[i-1]*nums[i-1];
    // }
    // for(int i=n-2;i>=0;i--){
    //     suffix*=nums[i+1];
    //     prefix[i]*=suffix;
    // }
    // return prefix;
    int n=nums.length;
    int [] a=new int[nums.length];
    a[0]=1;
    for(int i=1;i<n;i++){
        a[i]=a[i-1]*nums[i-1];
    }
    int suffix=1;
    for(int i=n-1;i>=0;i--){
        a[i]=a[i]*suffix;
        suffix=suffix*nums[i];
    }
    return a;
    }
}