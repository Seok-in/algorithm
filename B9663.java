import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class B9663 {
    static int result = 0;
    static int N;
    static int map[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
            map = new int[N+1];
            map[1] = i;
            dfs(map, 1);
        }
        System.out.println(result);
    }
    public static boolean check(int map[], int col){
        for(int i=1;i<col;i++){
            if(map[i]==map[col]){
                return false;
            }
            if(Math.abs(i-col)==Math.abs(map[i]-map[col]))
                return false;
        }
        return true;
    }
    public static void dfs(int map[], int col){
        if(col==N){
            result ++;
        }
        else{
            for(int i=1;i<=N;i++){
                map[col+1]=i;
                if(check(map, col+1)){
                    dfs(map, col+1);
                }
            }
        }
    }
}
