class Solution {
    // 좌표의 아래, 오른쪽, 왼쪽 위를 나타내기 위한 좌표를 설정해줍니다. 
    // 이렇게 설정해 줄 경우 불필요한 코드의 반복을 줄일 수 있습니다.
    private static final int[] dx = {0,1,-1};
    private static final int[] dy = {1,0,-1};
    
    
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1; // 초기값
        int x = 0; // x 시작
        int y = 0; // y 시작
        int d = 0; // 방향
        
        
        while(true){
            triangle[y][x] = v++; // 데이터 입력
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx == n || ny == n || nx == - 1 || ny == -1 || triangle[ny][nx] != 0){
                d = (d+1) % 3; // 나머지 연산자를 사용하여 방향이 항상 0,1,2 만 가능하게끔 해줍니다. 
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
                }
                x = nx;
                y = ny;
            }
        
        int[] result = new int [v-1];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j <= i; j++){
                result[index++] = triangle[i][j];
            }
        }
        return result;        
        }
    
    }
