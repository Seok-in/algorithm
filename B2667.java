import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2667 {
    static int N;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static ArrayList<Integer> list = new ArrayList<>();
    static int count=0;
    static Queue<Pos> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited= new boolean[N][N];
        for(int i=0;i<N;i++){
            String str[] = br.readLine().split("");
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(str[j]);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j]==1){
                    queue.add(new Pos(i,j));
                    visited[i][j] = true;
                    count += 1;
                    bfs();
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for(int i : list){
            System.out.println(i);
        }
    }
    static void bfs(){
        int plus = 1;
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            for(int i=0;i<4;i++){
                int nx = pos.xPos + dx[i];
                int ny = pos.yPos + dy[i];
                if(nx >=0 && nx < N && ny>=0 && ny <N){
                    if(!visited[nx][ny] && map[nx][ny]==1){
                        visited[nx][ny] = true;
                        plus += 1;
                        queue.add(new Pos(nx,ny));
                    }
                }
            }
        }
        list.add(plus);
    }
    static class Pos{
        int xPos;
        int yPos;
        public Pos(int xPos, int yPos){
            this.xPos = xPos;
            this.yPos = yPos;
        }
    }
}