class Solution {
    
    //방문 확인1
    boolean[][] visited = new boolean[maps.length][maps[0].length()];
    //방문 확인2
    boolean[][] visited_total = new boolean[maps.length][maps[0].length()];

    public int[] solution(String[] maps) { 
        //maps -> int배열로 변경
        int[][] maps_Int = new int[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                maps_Int[i][j] = (maps[i].charAt(j)) == 'X'? 0:(maps[i].charAt(j))-'0';
                System.out.printf("%d \n",maps_Int[i][j]);
            }
        }
        
        
        int x = 0;
        int y = 0;
        int sum = 0;
        
        while(true){
            // 현재 위치가 x이면 건너뛰기
            if(maps_Int[x][y] == 0){y++; continue; visited_total[x][y] = true;}
            sum += dfs(x,y,maps_Int);
        }
       
        int[] answer = {};
        return answer;
    }
    
    
    int dfs(int x, int y,int[][] maps_Int){
        
        int sum = 0;
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        // 현재 위치 방문 여부 체크
       if(visited[x][y] = true) return 0;
    
        for(int i = 0; i < 4; i++){
            x += dx[i];
            y += dy[i];
            
            if( x < 0 || y < 0 || x <= mpas_Int.length || y <= maps_Int[0].length() ) continue;
            
            if(mpas_Int[x][y] != 0;){
                sum += maps_Int[x][y];
                visited[x][y] == true;
                visited_total[x][y] == true;
            }
            
        }
        
           
        
    }
    
}