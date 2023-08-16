class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        
        //first row's columns iteration
        for(int itr1=1;itr1<matrix[0].length;itr1++){
            count+=matrix[0][itr1];
        }
        
        //first column's rows iteration
        for(int itr2=0;itr2<matrix.length;itr2++){
            count+=matrix[itr2][0];
        }
        
        for(int itr1=1;itr1<matrix.length;itr1++){
            for(int itr2=1;itr2<matrix[0].length;itr2++){
                if(matrix[itr1][itr2]==1){
                    matrix[itr1][itr2]=Math.min(matrix[itr1-1][itr2],Math.min(matrix[itr1-1][itr2-1],matrix[itr1][itr2-1]))+1;
                }
                count+=matrix[itr1][itr2];
            }
        }
        return count;
    }
}