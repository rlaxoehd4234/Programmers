class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 입력 받을 시 arr1 와 arr 2 의 행렬의 곱셈값을 저장하기 위한 arr 를 생성해줍니다.
        int[][] arr = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr.length; i++){
            //arr 의 최초값을 0으로 초기화해줍니다.
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = 0;
                for(int k = 0; k < arr1[i].length; k++){
                    // 그 후 행렬의 곱셉을 진행해줍니다.
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }
}