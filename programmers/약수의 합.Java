class Solution {
    public int solution(int n) {
        
     int answer = 0;
     int num = n;
        
        for(int i = 1; i <= n; i++){
             for(int j = num; j >= 1; j--){ 
                 if(i * j == n){ 
                     answer += i;  
                     num = j;
                     break;
                 }
             }
        }
        
        return answer;
    }
}