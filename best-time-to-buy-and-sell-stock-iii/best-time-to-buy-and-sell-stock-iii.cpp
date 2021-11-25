class Solution {
public:
    int maxProfit(vector<int>& prices) {
    int trx_cnt=2;
        std::vector<std::vector<std::vector<int>>> v1(prices.size(),std::vector<std::vector<int>>(2,std::vector<int>(trx_cnt+1,-1)));
        return bestBuyAndSell(0,prices,1,trx_cnt,v1);
    }
    
    int bestBuyAndSell(int start,std::vector<int>& prices,int canBuy,int TRX_CNT,std::vector<std::vector<std::vector<int>>>& v1){
        if(TRX_CNT==0 || start>=prices.size()){
            return 0;
        }
        //std::string key=to_string(start)+"_"+to_string(canBuy)+"_"+to_string(TRX_CNT);
        if(v1[start][canBuy][TRX_CNT]!=-1){
            return v1[start][canBuy][TRX_CNT];
        }
        int idle=bestBuyAndSell(start+1,prices,canBuy,TRX_CNT,v1);
        if(canBuy){
            int buy=-prices[start]+bestBuyAndSell(start+1,prices,0,TRX_CNT,v1);
            v1[start][canBuy][TRX_CNT]= std::max(idle,buy);
            
        }else{
            int sell=prices[start]+bestBuyAndSell(start+1,prices,1,TRX_CNT-1,v1);
            v1[start][canBuy][TRX_CNT]= std::max(idle,sell);
        }
        return v1[start][canBuy][TRX_CNT];
    }
};