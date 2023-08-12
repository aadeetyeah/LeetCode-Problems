class Solution {
    public List<List<Integer>> generate(int numRows) {

     List<List<Integer>> resultArr = new ArrayList<>();
     
     List<Integer> arrMain = new ArrayList<>();
     arrMain.add(1);
     resultArr.add(arrMain);

     if(numRows==1){
         return resultArr;
     }
    
    for(int itr1=1;itr1<numRows;itr1++){
        List<Integer> arr = new ArrayList<>();
        int size = resultArr.get(itr1-1).size();
        
        for(int itr2=0;itr2<=size;itr2++){
            int prev=itr2-1;
            int next=itr2;

            if(prev>=0 && next<size){
                int sum=resultArr.get(itr1-1).get(prev)+resultArr.get(itr1-1).get(next);
                arr.add(sum);
            }
            if(next>=size){
                int num=resultArr.get(itr1-1).get(prev);
                arr.add(num);
            }
            if(prev<0){
                int num=resultArr.get(itr1-1).get(next);
                arr.add(num);
            }           
        }
        resultArr.add(arr);
    }

        return resultArr;
    }
}