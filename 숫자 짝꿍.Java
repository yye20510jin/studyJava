import java.util.*;
class Solution {
    
    public String solution(String X, String Y) {
        
        int[] x = new int[10], y = new int[10];
        
        for(int i = 0; i < X.length(); i++){x[X.charAt(i)-'0']++;}
        for(int i = 0; i < Y.length(); i++){y[Y.charAt(i)-'0']++;}
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9; i >= 0; i--){
            
            int cnt = Math.min(x[i],y[i]);
            
            while(cnt-- > 0){
                sb.append(i);
            }
            
        }
        
        if(sb.length() == 0) return "-1";
        if(sb.charAt(0) == '0') return "0";
        
        
        return sb.toString();
    }
}