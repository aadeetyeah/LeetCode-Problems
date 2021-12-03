class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
       int min_path=INT_MAX;
        //std::map<std::string,int> m1;
        std::vector<std::vector<int>> v1(grid.size(),std::vector<int>(grid.size(),0));
        for(int itr1=0;itr1<grid[0].size();itr1++){
            min_path=std::min(min_path,min_path_sum(grid,0,itr1,v1));
        }
        return min_path;
    }
    
    int min_path_sum(std::vector<vector<int>>& matrix,int src_row,int src_col,std::vector<std::vector<int>>& v1){
        if(src_row<0 || src_col<0 || src_row>=matrix.size() || src_col>=matrix[0].size()){
            return INT_MAX;
        }
        if(src_row==matrix.size()-1){
            return matrix[src_row][src_col];
        }
        
        if(v1[src_row][src_col]!=0){
            return v1[src_row][src_col];
        }
        int res=INT_MAX;
        for(int itr1=0;itr1<matrix[0].size();itr1++){
            if(itr1==src_col){
                continue;
            }
         res=std::min(res,min_path_sum(matrix,src_row+1,itr1,v1));
        }
        
        if(res==INT_MAX){
            return INT_MAX;
        }
        v1[src_row][src_col]= res+matrix[src_row][src_col];
        return v1[src_row][src_col];
    }
};