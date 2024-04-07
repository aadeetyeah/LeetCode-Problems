class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolution(board);
    }
    
    private boolean sudokuSolution(char[][] board){
        for(int itr1=0;itr1<board.length;itr1++){
            for(int itr2=0;itr2<board[0].length;itr2++){
                if(board[itr1][itr2]=='.'){
                    
                    for(char val='1';val<='9';val++){
                        
                        if(valid(board,itr1,itr2,val)){
                            board[itr1][itr2]   =   val;
                            if(sudokuSolution(board)){
                                return true;
                            }else{
                                board[itr1][itr2]   =   '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean valid(char board[][],int row,int col,char val){
        
        int fin_row = row/3;
        int fin_col = col/3;
        
        for(int itr1=0;itr1<board.length;itr1++){
            if(board[itr1][col]==val){
                return false;
            }
            
            if(board[row][itr1]==val){
                return false;
            }
            
            if(board[(3*fin_row)+(itr1/3)][(3*fin_col)+(itr1%3)]==val){
                return false;
            }
            
        }
        return true;
    }
}