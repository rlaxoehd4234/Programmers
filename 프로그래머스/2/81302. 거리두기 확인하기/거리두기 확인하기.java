class Solution {
    // 배열을 방문하기 위한 static final 배열 2개를 선언해줍니다. 
    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {-1, 0, 0, 1};
    
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for(int d = 0; d <4; d++){
            if(d == exclude) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
                continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    
    private boolean isDistanced(char[][] room, int x , int y){
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            
            switch(room[ny][nx]){
                case 'P' : return false;
                case 'O' : 
                    if(isNextToVolunteer(room, nx, ny, 3-d)) return false;
                    break;
            }
        }
        return true;
    }
    
    
    private boolean isDistanced(char[][] room){
        // 모든 원소를 검사하기 위해 2중 for 문으로 반복문 사용
        for(int y =0; y < room.length; y++){
            for(int x = 0; x < room[y].length; x++){
                // 만약 검사하는 곳에 응시자가 없다면 pass 
                if(room[y][x] != 'P') continue;
                // 만약 참여자가 있다면 다시 맨헤튼 거리를 검사해줍니다.
                if(!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }
    
    
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i< answer.length; i++){
            // 대기실 하나의 형태 
            String[] place = places[i];
            // 원소 하나하나의 값을 검사해야하기 때문에 char 2차원 배여을 생성해준다. 
            char[][] room = new char[place.length][];
            for(int j = 0; j < room.length; j++){
                room[j] = place[j].toCharArray();
            }
            //거리두기를 지키고 있는지 확인하기 위한 코드 지키고 있으면 1 아니면 0 
            if(isDistanced(room)){
                answer[i] = 1;
            } else{
                answer[i] = 0;
            }
        }
        return answer;
    }
}