class Solution {
    public int totalNQueens(int n) {
    char board[][]=new char[n][n];
        for(int itr1=0;itr1<n;itr1++){
            for(int itr2=0;itr2<n;itr2++){
                board[itr1][itr2]='.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        return nQueensSolution(0,board,0);
        //return ans.size();    
    }


    
    
    private int nQueensSolution(int column,char[][] board,int ans){
        
        if(column==board.length){
            ans++;
            return ans;
        }
        
        int cnt =0;
        for(int itr1=0;itr1<board.length;itr1++){
            if(isSafe(column,itr1,board)){
                board[itr1][column]='Q';
                cnt += nQueensSolution(column+1,board,ans);
                board[itr1][column]='.';
            }
        }
        return cnt;
    }
    
    // List<String> construct(char[][] board){
    //     List<String> result = new ArrayList<>();
    //     for(int itr1=0;itr1<board.length;itr1++){
    //         String str1 = new String(board[itr1]);
    //         result.add(str1);
    //     }
    //     return result;
    // }
    
    private boolean isSafe(int column,int row,char[][] board){
        
        //check up
        int dupCol = column;
        int dupRow = row;
        while(dupCol>=0 && dupRow<board.length){
            if(board[dupRow][dupCol]=='Q'){
                return false;
            }
            dupRow++;
            dupCol--;
        }
        
        //check left
        dupCol = column;
        while(dupCol>=0){
            if(board[row][dupCol]=='Q'){
                return false;
            }
            dupCol--;
        }
        
        //check diagonal
        dupRow = row;
        dupCol = column;
        
        while(dupRow>=0 && dupCol>=0){
            if(board[dupRow][dupCol]=='Q'){
                return false;
            }
            dupRow--;
            dupCol--;
        }
        
        return true;
    }
}