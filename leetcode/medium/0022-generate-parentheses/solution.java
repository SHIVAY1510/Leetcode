class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        char[] arr=new char[2*n];
        backtrack(ans,arr,0,0,0,n);
        return ans;
    }
    void backtrack(List<String>ans,char[] arr,int index, int open,int close,int n){
        if(index==2*n){
            ans.add(new String(arr));
            return;
        }
        if(open<n){
            arr[index]='(';
            backtrack(ans,arr,index+1,open+1,close,n);
        }
        if(close<open){
            arr[index]=')';
            backtrack(ans,arr,index+1,open,close+1,n);
        }
    }
}