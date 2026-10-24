class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int start=Math.max(day(arriveAlice),day(arriveBob));
        int end=Math.min(day(leaveAlice),day(leaveBob));
        return Math.max(0,end-start+1);
    }
    public int day(String s){
        int[] days={0,31,59,90,120,151,181,212,243,273,304,334};
        int m=Integer.parseInt(s.substring(0,2));
        int d=Integer.parseInt(s.substring(3,5));
        return days[m-1]+d;
    }
}