class Solution {
public:
    int maxProfit(vector<int>& prices) {
   std::vector<std::vector<int>> v1(prices.size(),std::vector<int>(2,-1));
        return bestBuyAndSell(0,prices,1,v1);
    }
    
    int bestBuyAndSell(int start,std::vector<int>& prices,int canBuy,std::vector<std::vector<int>>& v1){
        if( start>=prices.size()){
            return 0;
        }
        //std::string key=to_string(start)+"_"+to_string(canBuy)+"_"+to_string(TRX_CNT);
        if(v1[start][canBuy]!=-1){
            return v1[start][canBuy];
        }
        int idle=bestBuyAndSell(start+1,prices,canBuy,v1);
        if(canBuy){
            int buy=-prices[start]+bestBuyAndSell(start+1,prices,0,v1);
            v1[start][canBuy]= std::max(idle,buy);
            
        }else{
            int sell=prices[start]+bestBuyAndSell(start+1,prices,1,v1);
            v1[start][canBuy]= std::max(idle,sell);
        }
        return v1[start][canBuy];
    }
};