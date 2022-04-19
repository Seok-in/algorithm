import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B2011 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int dp[] = new int[str.length()+1];
		dp[0]=1;
		
		for(int i=1;i<dp.length;i++) {
			int first = str.charAt(i-1)-'0';
			if(first <10 && first>0) {
				dp[i] += dp[i-1];
				dp[i] %= 1000000;
			}
			
			if(i == 1) continue;
			
			int second = str.charAt(i-2)-'0';
			if(second==0) continue;
			int num = second*10 + first;
			if(num <= 26) {
				dp[i] += dp[i-2];
				dp[i] %= 1000000;
			}
		}
		System.out.println(dp[str.length()]);
	}
}
