class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer,Integer> m1=new TreeMap<>();
        int no;
        int num;
        int counter=0;
        for(int itr1=lo;itr1<=hi;itr1++){
            no=itr1;
            while(no!=1){
                if(no%2==0){
                    counter+=1;
                    no=no/2;
                }else{
                    counter+=1;
                    no=(3*no)+1;
                }
            }
            m1.put(itr1,counter);
            counter=0;
        }
        Map<Integer,Integer> m2=new TreeMap<>((i1,i2)->{ int comp=m1.get(i1)-m1.get(i2);
                                                       if(comp==0){
                                                           return 1;
                                                       }
                                                       return comp;});
        m2.putAll(m1);
        int temp=0;
        k--;
        System.out.println(m1.size());
        for(Map.Entry<Integer,Integer> e1 : m2.entrySet()){
            System.out.println(e1.getKey()+"---------"+e1.getValue());
           if(k==0){
                temp= e1.getKey();
                break;
            }
            k--;
        }
        return temp;
    }
}