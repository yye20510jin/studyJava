import java.util.*;
class Solution {
    public int solution(String s) {
        String[] word = s.split(" ");        
        int answer = 0;
        for(int i = 0; i < word.length; i++){
            if(i < word.length-1 && word[i].equals("Z") == false && word[i+1].equals("Z") == false){
                System.out.printf(" %s \n", word[i] );
                answer += Integer.parseInt(word[i]);
            }
        }

        if(!word[word.length-1].equals("Z")){
            answer += Integer.parseInt(word[word.length-1]);
        }
        
        return answer;
    }
}