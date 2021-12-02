class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        std::map<std::string,int> m1;
        return no_of_paths(obstacleGrid,0,0,obstacleGrid.size(),obstacleGrid[0].size(),m1);
    }
    
    int no_of_paths(vector<vector<int>>& obstacle_arr,int src_row,int src_col,int dest_row,int dest_col,std::map<std::string,int>& m1){
        if( src_row>=dest_row || src_col>=dest_col){
            return 0;
        }
        
        if(obstacle_arr[src_row][src_col] ){
            return 0;
        }
        
        if(src_row==dest_row-1 && src_col==dest_col-1 && obstacle_arr[src_row][src_col]==0){
            return 1;
        }
        std::string key=to_string(src_row)+"_"+to_string(src_col);
        if(m1[key]!=0){
            return m1[key];
        }
        int right=no_of_paths(obstacle_arr,src_row,src_col+1,dest_row,dest_col,m1);
        int down=no_of_paths(obstacle_arr,src_row+1,src_col,dest_row,dest_col,m1);
        m1[key]= right+down;
        return m1[key];
    }
};