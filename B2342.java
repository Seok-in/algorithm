import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B2342 {
	static int arr[];
	static int dp[][][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		arr = new int[str.length-1];
		for(int i=0;i<str.length-1;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		dp = new int[5][5][str.length-1];
//		for(int j=0;j<5;j++) {
//			for(int k=0;k<5;k++) {
//				Arrays.fill(dp[j][k], -1);
//			}
//		}
		System.out.println(move(0,0,0));
		
	}
	public static int move(int left, int right, int step) {
		if(step==arr.length) return 0;
		
		if(dp[left][right][step]!=0) return dp[left][right][step];
		
		dp[left][right][step] = Math.min(move(arr[step],right, step+1)+cost(left, arr[step]),move(arr[step],left,step+1)+cost(right,arr[step]));
		
		return dp[left][right][step];
	}
	
	public static int cost(int now, int des) {
		int num = Math.abs(now-des);
		if(now==0) return 2;
		else if(num==0) return 1;
		else if(num==1 || num == 3) return 3;
		else return 4;
	}	
}
