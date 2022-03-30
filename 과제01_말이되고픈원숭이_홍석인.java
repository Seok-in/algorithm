import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1600 {
	static int arr[][];
	static boolean visited[][][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int h_dx[]= {-2,-1,1,2,2,1,-1,-2};
	static int h_dy[]= {1,2,2, 1,-1,-2,-2,-1};
	static Queue<Pos> queue = new LinkedList<>();
	static int K;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		String str[] = br.readLine().split(" ");
		int W = Integer.parseInt(str[1]);
		int H = Integer.parseInt(str[0]);
		visited = new boolean[W][H][K+1];
		arr = new int[W][H];
		
		for(int i=0;i<W;i++) {
			String str2[] = br.readLine().split(" ");
			for(int j=0;j<H;j++) {
				arr[i][j]=Integer.parseInt(str2[j]);
			}
		}
		
		queue.add(new Pos(0,0,0,0));
		visited[0][0][0] =true;
		bfs();
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		
		System.out.println(result);
		
	}
	
	public static class Pos{
		int xPos;
		int yPos;
		int K;
		int count;
		
		public Pos(int xPos, int yPos, int K, int count) {
			this.xPos =xPos;
			this.yPos =yPos;
			this.K = K;
			this.count = count;
		}
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			// 도착했을때
			if(pos.xPos==arr.length-1 && pos.yPos==arr[0].length-1) {
				result = Math.min(result, pos.count);
			}
			
			
			// 그냥 이동하기
			for(int i=0;i<4;i++) {
				int nx = pos.xPos + dx[i];
				int ny = pos.yPos + dy[i];
				if(nx >=0 && ny>=0 && nx < arr.length && ny <arr[0].length) {
					if(!visited[nx][ny][pos.K]&&arr[nx][ny]==0) {
						queue.add(new Pos(nx, ny, pos.K, pos.count+1));
						visited[nx][ny][pos.K] = true;
					}
				}
			}
			// 말처럼 이동하기
			if(pos.K <= K-1) {
				for(int j=0;j<8;j++) {
					int nx = pos.xPos + h_dx[j];
					int ny = pos.yPos + h_dy[j];
					
					if(nx >=0 && ny>=0 && nx < arr.length && ny <arr[0].length) {
						if(!visited[nx][ny][pos.K+1]&&arr[nx][ny]==0) {
							queue.add(new Pos(nx, ny, pos.K +1, pos.count+1));
							visited[nx][ny][pos.K+1]=true;
						}
					}
				}
			}
		}
	}
}
