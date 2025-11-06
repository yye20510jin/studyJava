import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int[] cards) {
        /*
        문제 정리.
        
        1. 몇 개의 사이클이 나올지 미지수
        2. 2개 이상의 사이클이 나올 경우 사이클 중 가장 큰 두 수를 곱한다.
            -> 사이클은 하나만 나올 수 도 있다.
        3. 사이클 그룹은 어떤 수를 고르든 동일하다.
        
        - 열린 박스와 열리지 않은 박스를 구분해야 한다. -> Boolean사용
        - 박스가 열리는 순서는 임의의 숫자로 정해진다 -> while문 사용
        
        while(){
            박스 오픈 여부 확인
                오픈이 안됐으면 오픈으로 변경 후 계속 진행
                오픈이 됐으면 해당 사이클이 몇 번 돌아갔는지 기록후 종료
        }
        
        아직 더 돌아갈 박스가 남았는지 확인
            박스가 남았으면 while문 재실행
            박스가 남지 않았으면 가장 큰 2개의 값의 곱을 반환하고 종료
        
        */
        
        //아직 더 돌아갈 박스가 남았는지 확인 -> 박스 오픈 여부를 확인하기 위한 boolean 배열 먼저 생성하기.
        // -> 확인은 사이클이 끝날때 마다 확인해야 함으로 반복문 사용
        boolean[] cycle = new boolean[cards.length];
        
        /*
            IntStream.range(0,cycle.length).anyMatch(i -> !cycle[i]);
            - IntStream.range() : for문의 역할 
            - anyMatch(i -> cycle[i]) : If문의 역할, True를 만나면 루프 종료
                i : IntStream.range()에서 반환하는 값을 i에 담는다.
        */
        
        boolean check = true;
        boolean check_cycle = true;
        int num = 0;
        int count = 0;
        int answer = 0;
        List<Integer> count_list = new ArrayList<>();
        
        //박스가 남았으면 while문 재실행
        while(check){
            
           
            
            while(check_cycle){
                
                
                //박스가 오픈되지 않은 경우
                if(cycle[num] == false){

                    cycle[num] = true;
                    num = cards[num]-1;
                    
                    // + 현재 사이클에 몇 개의 박스가 열렸는지 계산할 카운터 필요
                    count++;
                    
                }else if(cycle[num] == true){ //박스가 오픈 된 경우. 사이클 종료

                    check_cycle = false;
                    // + 현재 사이클의 총 박스 개수 저장할 배열 필요 -> 사이클의 개수는 변하기 때문에 List로 만들어야 한다.
                    count_list.add(count);
                    count = 0;
                }
                 
            } // 사이클 while 끝
            

            //미오픈 박스 확인 - cycle에서 미오픈 박스(false)가 하나라도 있으면 check는 True.
            check = IntStream.range(0,cycle.length).anyMatch(i->!cycle[i]);
            
            // 다음 사이클 num 정하기
            if (check){
                num = (IntStream.range(0,cycle.length).filter(i->!cycle[i]).map(i->cards[i]).findFirst().orElse(-1))-1; 
                check_cycle = true;
            }  
        }
        
        //가장 큰 두 사이클을 구해 값 return - 사이클이 하나인 경우는 0을 return
        if(count_list.size() == 1){
            return 0;
        }else{
            Collections.sort(count_list);
            Collections.reverse(count_list);
            answer = count_list.get(0) * count_list.get(1);
        }
        
        
        return answer;
    }
}