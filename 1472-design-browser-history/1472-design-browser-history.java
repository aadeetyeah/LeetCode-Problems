class BrowserHistory {

    ArrayList<String> history = new ArrayList<>();
    int index;
    
    public BrowserHistory(String homepage) {
        history.add(homepage);    
        index = history.size()-1;
    }
    
    public void visit(String url) {
        int size = history.size();
        
        if(index+1<size){
            history.subList(index+1,size).clear();
        }       
        history.add(url);
        index = index +1;    
    }
    
    public String back(int steps) {
        if(index-steps<=0){
            index = 0;
            return history.get(0);
        }
        index = index - steps;
        return history.get(index);
    }
    
    public String forward(int steps) {
        int size = history.size();
        if(steps+index>=size){
            index= size -1;
            return history.get(index);
        }
        index = index+steps;
        return history.get(index);
    }
    
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */