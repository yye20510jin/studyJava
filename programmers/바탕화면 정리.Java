class Solution {
    public int[] solution(String[] wallpaper) {
        int start_x = 0;
        int start_y = 0;
        int end_x = 0;
        int end_y = 0;
        int count = 0;
        
        //첫 줄에 있는 파일의 위치 값
        for(int i = 0; i < wallpaper.length; i++){
            if(wallpaper[i].indexOf("#") != -1){
                if(count == 0){
                    count++;
                    start_x = i;
                    start_y = wallpaper[i].indexOf("#");
                }
                if(start_y > wallpaper[i].indexOf("#")){
                    start_y = wallpaper[i].indexOf("#");    
                }
            }            
        }
        
        //끝 줄에 있는 파일의 위치 값
        count = 0;
        for(int i = wallpaper.length-1; i >= 0; i--){
            if(wallpaper[i].indexOf("#") != -1){
                if(count == 0){
                    count++;
                    end_x = i+1;
                    end_y = wallpaper[i].lastIndexOf("#");
                }
                
                if(end_y < wallpaper[i].lastIndexOf("#")){
                    end_y = wallpaper[i].lastIndexOf("#");    
                }
                
            }
        }
        
        
        int[] answer = {start_x, start_y, end_x, end_y+1};
        return answer;
    }
}