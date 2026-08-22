class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0;
        int totalcost=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalgas<totalcost){
            return -1;
        }
        int curgas=0,si=0;
        for(int i=0;i<gas.length;i++){
           curgas+=gas[i]-cost[i];
           if(curgas<0){
            curgas=0;
            si=i+1;
           }
        }
        return si;
    }
}
