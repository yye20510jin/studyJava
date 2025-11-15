class Solution {
    public int solution(int hp) {
        /*
            장군개미 5
            병정개미 3
            일개미   1
            
        */
        
        int answer = 0;
        
        if(hp/5 > 0){
            answer += (hp / 5);
            hp = hp - 5 * (hp / 5);    
        }
            
        if(hp/3 > 0){
            answer += (hp / 3);
            hp = hp - 3 * (hp / 3);     
        }
            
        
        while(hp > 0){
            answer += 1;
            hp--;
        }
        
        
        return answer;
    }
}