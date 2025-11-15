import java.util.*;
class Solution {
    
    //방문 확인1
    //boolean[][] visited = new boolean[maps.length][maps[0].length()];
    

    int sum = 0;

    public int[] solution(String[] maps) { 
        
        //maps -> int배열로 변경
        int[][] maps_int = new int[maps.length][maps[0].length()];
        //방문 확인2
        boolean[][] visited_total = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                maps_int[i][j] = (maps[i].charAt(j)) == 'X'? 0:(maps[i].charAt(j))-'0';
            }
        }
      
        List<Integer> answer_list = new ArrayList<>();
        
        for(int i = 0; i < visited_total.length; i++ ){
            for(int j = 0; j < visited_total[0].length; j++){ 
                
                // 현재 위치가 x이면 건너뛰기
                if(maps_int[i][j] == 0){ 
                    visited_total[i][j] = true;
                }else if(!visited_total[i][j]){
                    sum += maps_int[i][j];
                    visited_total[i][j] = true;
                    dfs(i,j,maps_int,visited_total);  
                }

                if(sum != 0){
                    answer_list.add(sum);
                    sum = 0;
                } 

            }
        }
        
        answer_list.sort(Comparator.naturalOrder());
        
        int[] answer = answer_list.isEmpty()? new int[]{-1}: answer_list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    
    
    void dfs(int x, int y, int[][] maps_int, boolean[][] visited_total) {

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크
            if (nx < 0 || ny < 0 || nx >= maps_int.length || ny >= maps_int[0].length) continue;

            // 바다(X)가 아니고, 아직 방문 안 했으면 계속 탐색
            if (maps_int[nx][ny] != 0 && !visited_total[nx][ny]) {
                sum += maps_int[nx][ny];
                visited_total[nx][ny] = true;
                dfs(nx, ny, maps_int, visited_total);
            }
        }
    }
}