class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int num = 0;
        for(int itr1=0;itr1<operations.length;itr1++){
            char ch = operations[itr1].charAt(0);
            if(ch == 'X'){
                ch = operations[itr1].charAt(1);
            }
            if(ch == '+'){
                num++;
            }
            if(ch == '-'){
                num--;
            }
        }
        return num;
    }
}