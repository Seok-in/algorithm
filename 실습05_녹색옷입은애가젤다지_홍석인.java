import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 실습05_녹색옷입은애가젤다지 {
	static int arr[][];
	static int visited[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static Queue<Pos> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		int num =0;
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = -1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			arr = new int[N][N];
			visited = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String str[] = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(str[j]);
					visited[i][j] = Integer.MAX_VALUE;
				}
			}			
			num += 1;
			visited[0][0] = arr[0][0];
			bfs();
			sb.append("Problem "+num+": "+visited[N-1][N-1]+"\n");
		}
		System.out.println(sb.toString());
	}
	public static void bfs() {
		queue.add(new Pos(0,0));
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			int min = Integer.MAX_VALUE;
			for(int i=0;i<4;i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				if(nx >= 0 && nx < arr.length && ny>=0 && ny< arr.length) {
						if(visited[nx][ny] > visited[pos.x][pos.y] + arr[nx][ny]) {
							visited[nx][ny] = visited[pos.x][pos.y] + arr[nx][ny];
							queue.add(new Pos(nx, ny));
						}
					}									
				}				
			}			
			
			
		}
	
	
	public static class Pos {
		int x;
		int y;
		public Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}