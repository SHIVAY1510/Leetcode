class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
    //     ArrayList<Integer> ans=new ArrayList<>();
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         boolean found=false;
    //         for(int j=i+1;j<n;j++){
    //             if(arr[j]>arr[i]){
    //                 found=true;
    //                 break;
    //             }
    //         }
    //         if(found==false){
    //             ans.add(arr[i]);
    //         }
    //     }
    //     return ans;
    // }
    ArrayList<Integer> ans=new ArrayList<>();
    int n=arr.length;
    int i=n-1;
    int maxrt=arr[i];
    ans.add(arr[i]);
    for(i=n-2;i>=0;i--){
        if(arr[i]>=maxrt){
            ans.add(arr[i]);
            maxrt=arr[i];
        }
        }
        Collections.reverse(ans);
        return ans;
    }
}
