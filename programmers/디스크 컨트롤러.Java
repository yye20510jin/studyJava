import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        /*
        문제 ->
        대기 큐 : 작업의 번호, 작업의 요청 시각, 작업의 소요 시간
        작동 : 하드디스크 작업 x , 대기 큐가 비었음 -> 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순
        특징 : 하드디스크는 작업을 한 번 시작하면 작업을 마칠 때까지 그 작업만 수행
        
        jobs = [작업이 요청되는 시점, 작업의 소유 시간]
        */
        
        /*
            작업 종료 시간(총 작업시간) - 요청시각 = 반환 시간
            
            1) 우선순위 지정
                Array.sort(jobs,Comparator.comparingInt(a -> a[1]).thenComparingInt(a -> a[0]));
                // 내림차순인 경우 : Array.sort(jobs,(a,b) -> Integer.compare(b[1],a[1]));
            
            
            2) 총 작업시간
             ** 작업이 끝나고 시간이 흐른 후 작업이 추가된다면? 
                - 총 작업시간(현재 : 3) < 다음 작업의 작업 요청 시간(요청 : 5)
                    총 작업시간 += (다음 작업의 작업 요청 시간 - 총 작업시간) + int[i][1]
             ** 작업 중 요청이 들어오는 경우
                - 총 작업시간 += int[i][1]
            
            3) 반환 시간 구하기
                +> 반환시간 넣을 배열 선언 : int[] returnTime = new int[jobs.length]
                returnTime[i] = 총 작업시간 - int[i][0] -> for문 필요
                
            4) 반환 시간 평균 구해서 리턴. -> 자료형을 int로 사용.
            
        */
        
        //정렬
        int total = 0;
        int[] returnTime = new int[jobs.length];
        Arrays.sort(jobs,Comparator.<int[]>comparingInt(a -> a[1]).thenComparingInt(a -> a[0]));
        
        //총 작업시간 구하기
        for(int i = 0; i < jobs.length; i++){
            
                //** 작업이 끝나고 시간이 흐른 후 작업이 추가되는 경우, 아닌 경우
                if(total < jobs[i][0]){
                    System.out.printf("작업 시간이 늦게 들어옴 : %d,   %d \n",total,jobs[i][0]);
                    total += (jobs[i][0] - total)+jobs[i][1];
                }else{
                    
                    total += jobs[i][1];
                    System.out.printf("작업 시간이 알맞게 들어옴 : %d,   %d,   %d \n",total,jobs[i][0],jobs[i][1]);
                }
            
            //반환 시간 구하기
            returnTime[i] = total - jobs[i][0];
            
        }// i for 끝
        
        int add = 0;
        //반환 시간 평균 구해서 리턴
        for(int i = 0; i < returnTime.length; i++){
            add += returnTime[i];
            
            
            System.out.printf("작업 번호 : %d -> 작업 시간 : %d \n", i+1, returnTime[i]);//삭제
        }
        
        
        System.out.printf("add : %d, returnTime : %d \n",add, returnTime.length);//삭제
        
        int answer = add/returnTime.length;
        
        return answer;
    }
}