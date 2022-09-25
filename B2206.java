import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B2206 {
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int visited[][][];
    static int arr[][];
    static int N, M;
    static Queue<Pos> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N= Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visited = new int[2][N][M];
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            String str2[] = br.readLine().split("");
            for(int j=0;j<M;j++){
                arr[i][j]= Integer.parseInt(str2[j]);
            }
        }
        queue.add(new Pos(0,0,1,false));
        visited[0][0][0] = 1;
        bfs();
        int min = Integer.MAX_VALUE;

        if(visited[0][N-1][M-1] != 0 ){
            min = Math.min(min, visited[0][N-1][M-1]);
        }
        if(visited[1][N-1][M-1] !=0){
            min = Math.min(min, visited[1][N-1][M-1]);
        }
        if(min==Integer.MAX_VALUE){
            min = -1;
        }
        System.out.println(min);
    }
    static void bfs(){
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            for(int i=0;i<4;i++){
                int nx = pos.xPos +dx[i];
                int ny = pos.yPos + dy[i];
                int mov = pos.count;
                boolean bk = pos.bk;
                if(nx >=0 && nx<N && ny>=0 && ny<M){
                    // 벽을 부쉈으면
                    if(bk && arr[nx][ny]==0){
                        if(visited[1][nx][ny] ==0 || visited[1][nx][ny] > mov +1){
                            visited[1][nx][ny] = mov + 1;
                            queue.add(new Pos(nx, ny, mov+1, true));
                        }
                    }
                    // 벽을 안 부숨
                    else{
                        // 벽을 안 부수고 그대로감
                        if(arr[nx][ny]==0){
                            if(visited[0][nx][ny] ==0 || visited[0][nx][ny] > mov +1){
                                visited[0][nx][ny] = mov + 1;
                                queue.add(new Pos(nx, ny, mov+1, bk));
                            }
                        }
                        // 벽을 부숴야겠음
                        else if(!bk){
                            if(visited[1][nx][ny] ==0 || visited[1][nx][ny] > mov +1){
                                visited[1][nx][ny] = mov + 1;
                                queue.add(new Pos(nx, ny, mov+1, true));
                            }
                        }
                    }


                }
            }
        }
    }

    public static class Pos{
        int xPos;
        int yPos;
        int count;
        boolean bk;
        public Pos(int xPos, int yPos, int count, boolean bk){
            this.xPos = xPos;
            this.yPos = yPos;
            this.count = count;
            this.bk = bk;
        }
    }
}

