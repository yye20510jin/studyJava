import java.util.*;
class Solution {
    
    public String solution(String X, String Y) {
        
        String answer = "";
        
        int[] x = new int[10], y = new int[10];
        
        for(int i = 0; i < X.length(); i++){x[X.charAt(i)-'0']++;}
        for(int i = 0; i < Y.length(); i++){y[Y.charAt(i)-'0']++;}
        
        for(int i = 9; i >= 0; i--){
            if(x[i] >= 1 && y[i] >= 1){
                while(x[i] != 0 && y[i] !=0){
                    answer += i+"";
                    x[i]--;
                    y[i]--;
                }
            }
        }
        
        if(answer.isEmpty()){
            answer = "-1";
        }else if(answer.matches("[0]+")){
            answer = "0";
        }
        
        return answer;
    }
}