
import java.util.Scanner;
	
public class B11051 {	
	static int div = 10007;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		System.out.println((factorial(N) * mod_inverse((factorial(N - K) * factorial(K)) % div, div - 2)) % div);
	}
	static int factorial(int N) {
		// factorial(0) == 1 이다.
		if (N <= 1) {
			return 1;
		}
		return (N * factorial(N - 1)) % div;
	}
 
	// 역원 구하기 (= 제곱승 구하기)
	static int mod_inverse(int a, int p) {
		int ret = 1;
		while(p > 0) {
			if(p % 2 == 1) {
				ret *= a;
				p--;
				ret %= div;
			}
			a *= a;
			a %= div;
			p >>= 1;	// p = p/2 랑 동치 
		}
		return ret;
	}
}
