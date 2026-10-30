class Solution {
    public int maxVowels(String s, int k) {
        // int n=s.length();
        // int maxCount=0;
        // for(int i=0;i<=n-k;i++){
        //     int Count=0;
        //     for(int j=i;j<i+k;j++){
        //         char ch=s.charAt(j);
        //         if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
        //             Count++;
        //         }
        //     }
        //     maxCount=Math.max(maxCount,Count);
        // }
        // return maxCount;
        int n=s.length();
        int maxcount=0;
        int start=0;
        int count=0;
        for(int e=0;e<n;e++){
            char ch=s.charAt(e);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
            if(e>=k-1){
                maxcount=Math.max(maxcount,count);
                char f=s.charAt(start);
                if(f=='a'||f=='e'||f=='i'||f=='o'||f=='u'){
                    count--;
                }
                 start++;
            }
        }
        return maxcount;
    }
}