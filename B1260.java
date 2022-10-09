import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1260 {
    public static boolean visited[];
    static int map[][];
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);
        visited = new boolean[N+1];
        visited[C] = true;
        queue.add(C);
        map = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            String str2[] = br.readLine().split(" ");
            map[Integer.parseInt(str2[0])][Integer.parseInt(str2[1])] = 1;
            map[Integer.parseInt(str2[1])][Integer.parseInt(str2[0])] = 1;
        }
        sb.append(C).append(" ");
        dfs(C);
        visited=new boolean[N+1];
        visited[C]=true;
        sb.append("\n");
        bfs();
        System.out.println(sb);
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int n = queue.poll();
            sb.append(n).append(" ");
            for(int i=0;i<=N;i++){
                if(map[n][i]==1){
                    if(!visited[i]){
                        visited[i]=true;
                        queue.add(i);
                    }
                }
            }
        }
    }
    public static void dfs(int n){
        for(int i=0;i<=N;i++){
            if(map[n][i]==1){
                if(!visited[i]){
                    visited[i] = true;
                    sb.append(i).append(" ");
                    dfs(i);
                }
            }
        }
    }
}

