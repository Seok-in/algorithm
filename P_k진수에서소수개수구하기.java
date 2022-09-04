import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = change(n,k);
        String[] strList = str.split("0");
        for(String str2 : strList){
            if(!str2.equals("")){
                if(isPrime(Long.parseLong(str2))){
                    answer += 1;
                }
            }
        }
        return answer;
    }

    // 진법을 바꾸는 함수
    public static String change(int n, int k){
        Stack<Integer> stack = new Stack<>();
        while(true){
            stack.push(n%k);
            if(n/k < k){
                stack.push(n/k);
                break;
            }
            n = n/k;
        }
        String str = "";
        while(!stack.isEmpty()){
            str += Integer.toString(stack.pop());
        }
        return str;
    }
    // 소수 판별 함수
    public static boolean isPrime(long n){
        if(n<=1){
            return false;
        }
        for(long i=2;i*i<=n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}