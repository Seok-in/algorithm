import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B17142 {
    static int map[][];
    static int result=1000;
    static Queue<Pos> queue = new LinkedList<>();
    static ArrayList<Pos> viruses = new ArrayList<>();
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        boolean blank = false;
        map = new int[N][N];
        for(int i=0;i<N;i++){
            String str2[] =br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(str2[j]);
                if(map[i][j]==2){
                    viruses.add(new Pos(i,j, 0));
                }
                if(map[i][j]==0){
                    blank=true;
                }
            }
        }
        if(blank){
            boolean visited[] = new boolean[viruses.size()];
            comb(visited, 0, viruses.size(),M);
            if(result==1000) result=-1;
            System.out.println(result);
        }
        else{
            System.out.println(0);
        }
    }
    public static void comb(boolean visited[], int depth, int n, int r){
        if(r==0){
            for(int i=0;i<n;i++){
                if(visited[i]){
//                    System.out.print(i+" ");
                    queue.add(viruses.get(i));
                }
            }
//            System.out.println();
            bfs();
        }
        if(depth == n){
            return;
        }
        visited[depth]=true;
        comb(visited, depth+1, n, r-1);
        visited[depth]=false;
        comb(visited,depth+1,n,r);
    }
    public static void bfs(){
        boolean visited2[][] = new boolean[map.length][map.length];
        int time=0;
        boolean vi = false;
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            visited2[pos.xPos][pos.yPos] = true;

            for(int i=0;i<4;i++){
                int nx = pos.xPos+dx[i];
                int ny = pos.yPos+dy[i];

                if(nx >= 0 && nx<map.length && ny >=0 && ny<map.length && map[nx][ny]!=1 && !visited2[nx][ny]){
                    queue.add(new Pos(nx, ny, pos.time+1));
                    time = pos.time+1;
                    visited2[nx][ny] = true;
                }
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
//                System.out.print(visited2[i][j]+" ");
                if(!visited2[i][j] && map[i][j]==0){
                    vi=true;
                }
            }
//            System.out.println();
        }
        if(!vi){
//            System.out.println(time);
            result = Math.min(time, result);
        }
    }
    public static class Pos{
        int xPos;
        int yPos;
        int time;

        public Pos(int x, int y,int time){
            this.xPos = x;
            this.yPos = y;
            this.time =time;
        }
    }
}
