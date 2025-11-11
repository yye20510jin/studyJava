import java.util.*;
class Solution {
    
    public List<Integer> function(List<Integer>small, List<Integer>big){
        int count = 0;
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < small.size(); i++){
            if(big.contains(small.get(i))){
                arr.add(small.get(i));
                big.remove(big.indexOf(small.get(i)));
                small.remove(i);
                i = -1;
            }else{
                final int idx = i;
                small.removeIf(n -> n == small.get(idx));
                i = -1;
            }
        }
        
        return arr;
    }
    
    public String solution(String X, String Y) {
        
        List<Integer> x = new ArrayList<>(),y = new ArrayList<>(), arr = new ArrayList<>();

        String answer = "";
        
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
        if(x.size() >= y.size()){
            arr = function(y,x);
        }else if(x.size() < y.size()){ 
          arr = function(x,y);
        }
        
        if(arr.size() == 0){
            answer = "-1";
        }else{
            arr.sort(Comparator.reverseOrder());
            for(int i = 0; i < arr.size(); i++){
                answer += arr.get(i) + "";
            }
        }
        
        
        if (answer.matches("[0]+")){
            answer = "0";
        }
        
        return answer;
    }
}