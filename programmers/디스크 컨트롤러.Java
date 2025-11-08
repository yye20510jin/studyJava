import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
       /*
        문제
            요청이 들어오는 순으로 정렬을 해야 하는데, Arrays.sort()에서 하는 정렬은 배열에 있는 모든 값을 한 번에 정렬한다. 
            소요 시간이 적으면 아직 들어오지 않은 요청이 1순위가 된다.
            -> PriorityQueue 사용
       */
        
        // 인덱스(정렬 마지막 조건) 넣은 배열 만들기
        
        int[][] arr = new int[jobs.length][3];
        
        for(int i = 0; i < jobs.length; i++){
            arr[i][0] = jobs[i][0];
            arr[i][1] = jobs[i][1];
            arr[i][2] = i;
        }
        
        // PriorityQueue에 넣을 조건 정렬
        
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[2]));
        
        // 우선 순위대로 정렬하는 PriorityQueue 객체 생성
        // 이차원 배열 arr[][]이 들어가지만 일차원 배열 int[]로 선언한 이유는 arr에서 한 행씩 가져다 넣을 예정이기 때문이다.
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> {
            // 정렬 기준 => a, a가 b보다 크면 양수, a가 b보다 작으면 음수, a와 b가 같으면 0을 반환.
            // 양수면 a는 b의 뒤로 이동, 음수면 a는 b의 앞으로 이동
            if (a[1] != b[1]) return a[1] - b[1];
            if( a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });
        
        // 시간 순서대로 PriorityQueue에 offer
        
        int time = 0; // 현재 시간
        int count = 0; // 요청 카운트 , 요청은 jobs 배열의 크기만큼 들어온다.
        int total = 0; // 총 반환시간
        int i = 0; // arr 배열 인덱스
        int answer = 0;
        
        while(count < jobs.length){
            
            //현재 시간보다 전이거나 같은 요청 que에 offer
            while(i < jobs.length && arr[i][0] <= time) que.offer(arr[i++]);  
            
            //현재 시간에 들어온 요청이 없으면 time 증가
            //PriorityQueue 같은 경우 poll로 꺼낸 값은 삭제되기 때문에 항상 최신 상태를 유지.
            if(que.isEmpty()){
                time = Math.max(time, arr[i][0]);
                continue;
            } 
            
            //해당 시간에 들어온 요청이 있는경우
            int[] arr2 = que.poll(); 
            time += arr2[1];  
            total += time - arr2[0];
            
            count++;
        }
        
        answer = (int)(total/jobs.length);
        
        return answer;
    }
}