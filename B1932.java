import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];
        int dp[][] = new int[N][N];
        for(int i=0;i<N;i++){
            String str[] = br.readLine().split(" ");
            for(int j=0;j<str.length;j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i=0;i<N;i++){
            dp[N-1][i] = arr[N-1][i];
        }
        for(int i=N-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];
            }
        }
        System.out.println(dp[0][0]);
    }

}