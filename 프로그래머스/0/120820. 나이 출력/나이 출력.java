import java.time.LocalDate;

class Solution {
    private int calAge(int age){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        return year - age - 1;
    }
    public int solution(int age) {
        return calAge(age);
    }
}