class Solution {
    public int[] findRedundantConnection(int[][] edges) {
            int parent[]=new int[edges.length+1];
            int rank[]=new int[edges.length+1];

            for(int itr1=1;itr1<=edges.length;itr1++){
                parent[itr1]=itr1;
            }

            ArrayList<Integer> ans=new ArrayList<>();

            Arrays.fill(rank,0);

            for(int itr1=0;itr1<edges.length;itr1++){
                int u=edges[itr1][0];
                int v=edges[itr1][1];

                int parent_u=findParent(u,parent);
                int parent_v=findParent(v,parent);

                if(parent_u==parent_v){
                    ans.add(u);
                    ans.add(v);
                }

                if(rank[parent_u]>rank[parent_v]){
                    parent[parent_v]=parent_u;
                }else if(rank[parent_u]<rank[parent_v]){
                    parent[parent_u]=parent_v;
                }else{
                    parent[parent_u]=parent_v;
                    rank[parent_v]++;
                }
            }


            int answer[]=new int[ans.size()];

            int itr2=0;
            for(Integer i : ans){
                answer[itr2]=i;
                itr2++;
            }
            return answer;
    }
    
    
    int findParent(int node,int parent[]){
        if(parent[node]==node){
            return node;
        }
        parent[node]=findParent(parent[node],parent);
        return parent[node];
    }
}