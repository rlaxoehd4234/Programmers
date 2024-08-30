class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        // 입력 받은 값을 바로 reverse 메소드를 이용해 reverse 해줍니다.
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();
        
        int[] result = new int[arr.length];
        for(int i = 0 ; i < result.length; i++){
            //문자를 정수로 바꿔주는 코드입니다.
            result[i] = arr[i] - '0';
        }
        return result;
    }
}