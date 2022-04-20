import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14889 {
	static int team[];
	static int N;
	static int arr[][];
	static int result=Integer.MAX_VALUE;
	static int sumAll=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr= new int[N][N];
		team = new int[N/2];
		
		for(int i=0;i<N;i++) {
			String str[] = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				sumAll += arr[i][j];
			}			
		}
		comb(0,0);
		System.out.println(result);
	}
	
	public static void comb(int count, int start) {
		if(count == N/2) {
			int sum=sumAll;
			for(int num: team) {
				for(int i=0;i<N;i++) {
					sum -= arr[num][i];
					sum -= arr[i][num];
				}
			}
			result = Math.min(Math.abs(sum), result);
			return;
		}
		for(int i=start;i<N;i++) {
			team[count]=i;
			comb(count+1, i+1);
		}
	}
}
