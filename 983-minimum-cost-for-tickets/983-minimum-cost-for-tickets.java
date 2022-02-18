class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer,Integer> m1=new HashMap<>();
        return minCost(days,costs,0,m1);
    }
    
    private int minCost(int[] days,int[] costs,int dayNo,Map<Integer,Integer> m1){
        
        
        if(days.length<=dayNo){
            return 0;
        }
        if(m1.containsKey(dayNo)){
            return m1.get(dayNo);
        }
        int oneDayPass=costs[0]+minCost(days,costs,dayNo+1,m1);
        
        int itr1=dayNo;
        for(;itr1<days.length;itr1++){
            if(days[itr1]>=days[dayNo]+7){
                break;
            }
        }
        int weekPass=costs[1]+minCost(days,costs,itr1,m1);
        int itr2=dayNo;
        for(;itr2<days.length;itr2++){
            if(days[itr2]>=days[dayNo]+30){
                break;
            }
        }
        
        int monthPass=costs[2]+minCost(days,costs,itr2,m1);
        
        m1.put(dayNo, Math.min(monthPass,Math.min(oneDayPass,weekPass)));
        return m1.get(dayNo);
    }
}