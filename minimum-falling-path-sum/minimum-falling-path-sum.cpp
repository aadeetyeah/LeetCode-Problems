class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int min_path=INT_MAX;
        std::map<std::string,int> m1;
        for(int itr1=0;itr1<matrix[0].size();itr1++){
            min_path=std::min(min_path,min_path_sum(matrix,0,itr1,m1));
        }
        return min_path;
    }
    
    int min_path_sum(std::vector<vector<int>>& matrix,int src_row,int src_col,std::map<std::string,int>& m1){
        if(src_row<0 || src_col<0 || src_row>=matrix.size() || src_col>=matrix[0].size()){
            return INT_MAX;
        }
        if(src_row==matrix.size()-1){
            return matrix[src_row][src_col];
        }
        std::string key=to_string(src_row)+"_"+to_string(src_col);
        if(m1[key]!=0){
            return m1[key];
        }
        int diag_right=min_path_sum(matrix,src_row+1,src_col+1,m1);
        int diag_left=min_path_sum(matrix,src_row+1,src_col-1,m1);
        int down=min_path_sum(matrix,src_row+1,src_col,m1);
        int res=std::min(diag_right,diag_left);
        res=std::min(res,down);
        m1[key]= res+matrix[src_row][src_col];
        return m1[key];
    }
};