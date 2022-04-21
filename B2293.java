import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2293 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int coins[] = new int[n]; 
		int dp[] = new int[k+1];
		dp[0]=1;
		for(int i=0;i<n;i++) {
			coins[i] = sc.nextInt();
		}
		for(int coin : coins) {
			for(int j=coin;j<=k;j++) {
				dp[j]=dp[j] + dp[j-coin];
			}
		}
		
		System.out.println(dp[k]);
		sc.close();
	}

}
