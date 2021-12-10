class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        std::vector<std::vector<std::vector<int>>> v1(piles.size(),std::vector<std::vector<int>>(piles.size(),std::vector<int>(2,-1)));
        int num= stone_game(0,piles.size()-1,piles,1,v1);
        if(num>0){
            return true;
        }
        return false;
    }
    
    int stone_game(int start,int end,std::vector<int>& piles,int chance,std::vector<std::vector<std::vector<int>>>& v1){
        
        if(start>end){
            return 0;
        }
        std::string key=to_string(start)+"_"+to_string(end)+"_"+to_string(chance);
        if(v1[start][end][chance]!=-1){
            return v1[start][end][chance];
        }
        if(chance){
            int front=piles[start]+stone_game(start+1,end,piles,0,v1);
            int back=piles[end]+stone_game(start,end-1,piles,0,v1);
            v1[start][end][chance]=std::max(front,back);
            return v1[start][end][chance];
        }else{
            int front=-piles[start]+stone_game(start+1,end,piles,1,v1);
            int back=-piles[end]+stone_game(start,end-1,piles,1,v1);
            v1[start][end][chance]= std::min(front,back);
            return v1[start][end][chance];
        }
    }
};