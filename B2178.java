import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2178 {
    static int N, M;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static Queue<Pos> queue = new LinkedList<>();
    static int map[][];
    static int visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        visited = new int[N][M];
        for(int i=0;i<N;i++){
            String str2[] = br.readLine().split("");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str2[j]);
            }
        }
        queue.add(new Pos(0,0,1));
        bfs();
        System.out.println(visited[N-1][M-1]+1);
    }
    static void bfs(){
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            for(int i=0;i<4;i++){
                int nx = pos.xPos+dx[i];
                int ny = pos.yPos+dy[i];
                int depth = pos.depth;
                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=0){
                    if(visited[nx][ny]==0||visited[nx][ny] > depth){
                        visited[nx][ny] = depth;
                        queue.add(new Pos(nx, ny, depth+1));
                    }
                }
            }
        }
    }
    static class Pos{
        int xPos;
        int yPos;
        int depth;

        public Pos(int xPos, int yPos, int depth) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.depth = depth;
        }
    }
}
