class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor){
            return image;
        }
        changeColor(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    
    private void changeColor(int image[][],int sr,int sc,int currColor,int newColor){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length  || image[sr][sc]!=currColor ){
            return;
        }
        image[sr][sc]=newColor;
        changeColor(image,sr+1,sc,currColor,newColor);
        changeColor(image,sr-1,sc,currColor,newColor);
        changeColor(image,sr,sc+1,currColor,newColor);
        changeColor(image,sr,sc-1,currColor,newColor);
        return;
    }
}