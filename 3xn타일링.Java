class Solution {
    public int solution(int n) {

        final long MOD = 1000000007L;
        
        if(n % 2 == 1) return 0;
        
        long[] d = new long[n+1];  
        int x = 2;
        int count = 0;
        d[0] = 1;
        
        if(n >= 2) d[2] = 3;
        
        
        for(int i = 4; i <= n; i+=2){ 
            
            while(true){
                
                if(count == 0){  
                    d[i] = (d[i] + (3L * d[i-x])%MOD)%MOD; 
                    x  = 4;
                    count++;
                }

                
                d[i] = (d[i] + (2L * d[i-x])%MOD)%MOD;
                
                if(d[i-x] == 1){ 
                    count = 0;
                    x = 2;
                    break;
                }

                x += 2; 

            } //while문
            
        }// if문
        
        System.out.printf("결과 값 :  %d \n", d[n]);
        
        int answer = (int)d[n];
                
        return answer;
    }
}