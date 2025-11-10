import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        List<Integer> x = new ArrayList<>(),y = new ArrayList<>(),arr = new ArrayList<>();
        
        // String X -> List<Integer> x
        for(int i = 0; i < X.length(); i++){
            int num = X.charAt(i) - '0';
            x.add(i,num);
        }
        
        // tring Y -> List<Integer> y
        for(int i = 0; i < Y.length(); i++){
            int num = Y.charAt(i) - '0';
            y.add(i,num);
        }
          
        // 리스트 x,y에 같은 값 있는지 확인
        if(x.size() > y.size()){
            for(int i = 0; i < y.size(); i++){
                for(int j = 0; j < x.size(); j++){
                    if(y.get(i) == x.get(j)){
                        arr.add(y.get(i));
                        y.remove(i);
                        x.remove(j);
                    }
                }
            }
        }else if(x.size() < y.size()){ 
            for(int i = 0; i < x.size(); i++){ 
                for(int j = 0; j < y.size(); j++){ 
                    if(x.get(i) == y.get(j)){  
                        arr.add(x.get(i));
                        x.remove(i);
                        y.remove(j);
                    }
                }
            }
        }
        
           
        
        String answer = "";
        return answer;
    }
}