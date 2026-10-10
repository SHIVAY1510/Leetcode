class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
       int n=nums1.length;
       int[] diff=new int[n];
       long t=0;
       int MD=0;
       for(int i=0;i<n;i++){
        diff[i]=Math.abs(nums1[i]-nums2[i]);
        t+=diff[i];
        MD=Math.max(MD,diff[i]);
       }
       int k=k1+k2;
       if(t<=k){
        return 0;
       }
       int[] freq= new int[MD+1];
       for(int d:diff){
        freq[d]++;
       }
       for(int d=MD;d>0 &&k>0;d--){
        int t1 =Math.min(freq[d],k);
        freq[d]-=t1;
        freq[d-1]+=t1;
        k-=t1;
       }
       long ans=0;
       for(int d=0;d<freq.length;d++){
        ans+=(long) d*d*freq[d];
       }
       return ans;
    }
}