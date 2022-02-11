class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int itr1=0;itr1<edges.length;itr1++){
            hmap.put(edges[itr1][0],hmap.getOrDefault(edges[itr1][0],0)+1);
            hmap.put(edges[itr1][1],hmap.getOrDefault(edges[itr1][1],0)+1);
        }
        int val=0;
        for(Map.Entry<Integer,Integer> e1 : hmap.entrySet()){
            if(e1.getValue()==edges.length){
                 val=e1.getKey();
                break;
            }
        }
        return val;
    }
}