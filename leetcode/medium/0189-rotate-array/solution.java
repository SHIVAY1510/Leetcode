class Solution {
    public void rotate(int[] nums, int k) {
       int n=nums.length;
       k=k%n;
       int i=n-k;
       int j=0;
       int[] temp = new int[n];
       for(i=n-k;i<n;i++){
        temp[j++]=nums[i];
       }
       for(i=0;i<n-k;i++){
        temp[j++]=nums[i];
       }
       for(i=0;i<n;i++){
        nums[i]=temp[i];
       }
    }
}