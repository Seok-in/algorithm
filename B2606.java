import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int arr[][] = new int[N+1][N+1];
        boolean visited[] = new boolean[N+1];
        for(int i=0;i<M;i++){
            String str[] = br.readLine().split(" ");
            arr[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            arr[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
        }
        queue.add(1);
        visited[1] = true;
        int count =0;
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i=1;i<=N;i++){
                if(!visited[i] && arr[a][i]==1){
                    visited[i]=true;
                    queue.add(i);
                    count+=1;
                }
            }
        }
        System.out.println(count);
    }
}