import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 실습06_달이차오른다가자_홍석인 {
	static Queue<Pos> queue = new LinkedList<>();
	static int result = -1;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int N, M;
	static char map[][];
	static boolean visited[][][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new char[N][M];
		// 열쇠가 6개이므로 경우의 수도 2^6개
		visited = new boolean[64][N][M];
		// Map정보 입력받기
		for(int i=0;i<N;i++) {
			String str2[] = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = str2[j].charAt(0);
				if(map[i][j] == '0') {
					queue.add(new Pos(i, j, 0, 0));
					visited[0][i][j] = true;
				}
			}
		}
		
		bfs();
		System.out.println(result);
	}
	//bfs함수 구현
	public static void bfs() {
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();		
			int nx;
			int ny;			
			if(map[pos.x][pos.y]=='1') {
				result = pos.count;
				break;
			}
			for(int i=0;i<4;i++) {
				nx = pos.x + dx[i];
				ny = pos.y + dy[i];
				// 범위 안에 있고
				if(nx >= 0 && nx < N && ny>=0 && ny< M) {						
					// 방문하지 않았으며 벽이 아니여서 지나갈 수 있으면
					if(!visited[pos.key][nx][ny] && map[nx][ny] != '#') {
						// 지나갈 수 있는 곳이면 큐에 담기						
						if(map[nx][ny] == '0' || map[nx][ny]=='1' || map[nx][ny]=='.') {	
							visited[pos.key][nx][ny] = true;
							queue.add(new Pos(nx,ny,pos.count+1, pos.key));
						}							
						// 도착한 곳에 열쇠가 있을 경우
						else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
							// 열쇠가 무엇인지 보고
							int key = 1 << (map[nx][ny]-'a');
							// 열쇠 획득
							key = pos.key | key;
							
							// 키들을 가지고 방문한 곳이 아니면
							if(!visited[key][nx][ny]) {
								visited[key][nx][ny]=true;
								visited[pos.key][nx][ny]=true;
								queue.add(new Pos(nx, ny, pos.count+1, key));
							}
						}
						// 도착한 곳이 문인 경우
						else if(map[nx][ny]>='A' && map[nx][ny]<='Z') {
							int lock = 1 << (map[nx][ny]-'A');
							// 0보다 큰경우 열쇠가 있음
							if((pos.key & lock) > 0) {
								visited[pos.key][nx][ny] = true;
								queue.add(new Pos(nx, ny, pos.count+1, pos.key));
							}
						}
					}
				}
			}
		}
	}
	
	public static class Pos {
		int x;
		int y;
		int key;
		int count;
		public Pos(int x, int y, int count, int key){
			this.x = x;
			this.y = y;
			this.key = key;
			this.count = count;
		}
	}
}
