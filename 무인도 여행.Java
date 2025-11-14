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
                System.out.printf("%d \n",maps_int[i][j]);
            }
        }
        
        
        int x = 0;
        int y = 0;
        int sum = 0;
        List<Integer> answer_list = new ArrayList<>();
        
        while(visited(visited_total)){
            // 현재 위치가 x이면 건너뛰기
            if(maps_int[x][y] == 0){ 
                visited_total[x][y] = true;
            }else{
                sum += maps_int[x][y];
                //visited[x][y] = true;
                visited_total[x][y] = true;
                dfs(x,y,maps_int,visited_total);  
                break;
            }
            
            if(sum != 0) answer_list.add(sum);
            
        }
       
        int[] answer = {1,1};
        return answer;
    }
    
    
    void dfs(int start_x, int start_y,int[][] maps_int,boolean[][] visited_total){
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
    
        for(int i = 0; i < 4; i++){
            
            int x = start_x;
            int y = start_y;
            
            x += dx[i];
            y += dy[i];
            
            if( x < 0 || y < 0 || x >= maps_int.length || y >= maps_int[0].length ) continue;
            
            if(maps_int[x][y] != 0 && visited_total[x][y] != true){
                sum += maps_int[x][y];
                //visited[x][y] = true;
                visited_total[x][y] = true;
                dfs(x,y,maps_int,visited_total);
            }else if(maps_int[x][y] == 0 && visited_total[x][y] != true){
                visited_total[x][y] = true;
            }
            
        }   
        
    }
    
    boolean visited(boolean[][] visited_total){
     for(boolean[] row : visited_total){
            for(boolean value : row){
                if(!value) return true;
            }
        }   
        
        return false;
    }
    
}