import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2636 {
	static Queue<Pos> bfs_queue = new LinkedList<>();
	static Queue<Pos> queue = new LinkedList<>();
	static boolean visited[][];
	static int arr[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean clear = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		arr = new int[Integer.parseInt(str[0])][Integer.parseInt(str[1])];
		visited = new boolean[Integer.parseInt(str[0])][Integer.parseInt(str[1])];
		for (int i = 0; i < arr.length; i++) {
			String str2[] = br.readLine().split(" ");
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(str2[j]);				
			}
		}
		int time = 0;
		int count = 0;
		while(true) {
			bfs_queue.add(new Pos(0, 0));			
			bfs();
			visited = new boolean[Integer.parseInt(str[0])][Integer.parseInt(str[1])];
			if(queue.isEmpty()) {
				break;
			}
			count = queue.size();
			time+=1;
			while(!queue.isEmpty()) {
				Pos pos = queue.poll();
				arr[pos.xPos][pos.yPos] = 0;
			}
		}
		
		System.out.println(time+"\n"+count);
	}

	public static void bfs() {
		while (!bfs_queue.isEmpty()) {
			Pos pos = bfs_queue.poll();			
			
			for (int i = 0; i < 4; i++) {
				int nx = pos.xPos + dx[i];
				int ny = pos.yPos + dy[i];
				if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						if (arr[nx][ny] == 1) {
							// 녹아야하는 지점 결과 큐에 넣기
							
							queue.add(new Pos(nx, ny));							
						} else {
							// 빈 공기이면 bfs큐에 넣기
							bfs_queue.add(new Pos(nx, ny));							
						}
					}
				}
			}
		}
	}

	public static class Pos {
		public int xPos;
		public int yPos;

		public Pos(int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
		}
	}
}
