import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2533 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
       dp = new int[N+1][2];
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }        
        for(int i=0;i<N-1;i++){
            String str[] = br.readLine().split(" ");
            int value = Integer.parseInt(str[0]);
            int link = Integer.parseInt(str[1]);
            list.get(value).add(link);
            list.get(link).add(value);
        }
        move(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    public static void move(int cur, int parent) {
    	dp[cur][0] = 0;
    	dp[cur][1] = 1;
    	
    	for(int i : list.get(cur)) {
    		if(i != parent) {
    			move(i, cur);
    			dp[cur][0] += dp[i][1];
    			dp[cur][1] += Math.min(dp[i][0], dp[i][1]);
    		}
    	}
    }
}
