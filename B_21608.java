package lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_21608 {
	static int maxCount;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N * N + 1][4];
		int map[][] = new int[N][N];
		int mapCount[][];
		int result = 0;
		LinkedList<Pos> list = new LinkedList<>();
		Pos[] pos = new Pos[N * N + 1];
		boolean[] visited = new boolean[N * N + 1];
		for (int i = 0; i < N * N; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 1; j < 5; j++) {
				arr[Integer.parseInt(str[0])][j - 1] = Integer.parseInt(str[j]);
			}
			queue.add(Integer.parseInt(str[0]));
		}
		// queue에서 빼면서 채우는 과정
		// 1. 첫 자리는 무조건(1,1)이 된다
		if (queue.size() == N * N) {
			// 자리배치 해주기
			map[1][1] = queue.poll();
			// 방문처리 해주기
			visited[map[1][1]] = true;
			// 지정된 좌표 넣어주기
			pos[map[1][1]] = new Pos(1, 1);
		}
		while (!queue.isEmpty()) {
			// 1. 좋아하는 사람의 번호를 확인하며 그 주변 위치들의 최적값을 count를 더해줌
			mapCount = new int[N][N];
			for (int i : arr[queue.peek()]) {
				// System.out.println(i);
				// 1-1. 이미 자리가 배치된 사람에 한해서 map에서 위치 조회
				if (visited[i]) {
					// 4방탐색
					for (int k = 0; k < 4; k++) {
						int nx = pos[i].xPos + dx[k];
						int ny = pos[i].yPos + dy[k];
						// 범위 판단
						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							if (map[nx][ny] == 0) {
								mapCount[nx][ny] += 1;
							}
						}
					}
				}
			}

			maxCount = 1;
			list.clear();

			// 1-2. 최적값을 찾아서 연결리스트에 넣음
			for (int p = 0; p < N; p++) {
				for (int q = 0; q < N; q++) {
					if (mapCount[p][q] != 0) {
						// 최적값과 같으면 list에 add
						if (mapCount[p][q] == maxCount) {
							list.add(new Pos(p, q));
						} else if (mapCount[p][q] > maxCount) {
							maxCount = mapCount[p][q];
							list.clear();
							list.add(new Pos(p, q));
						}
					}
				}
			}
			// 리스트가 비었을때
			if(list.isEmpty()) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(map[i][j]==0) {
							list.add(new Pos(i, j));
						}					
					}
				}
			}

			// 1-3 연결리스트에 들어간 값중 주변에 빈칸이 제일 많은 값이 결과
			int[] arr2 = new int[list.size()];
			int t = 0;
			int maxIndex = 0;
			int roomCount = 0;
			for (Pos a : list) {
				// a값을 기준으로 4방탐색
				for (int k = 0; k < 4; k++) {
					int nx = a.xPos + dx[k];
					int ny = a.yPos + dy[k];
					// 범위판단
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						// 빈방이면 채움
						if (map[nx][ny] == 0) {
							arr2[t] += 1;
						}
					}
				}
				t++;
			}

			// maxIndex 찾기
			for (int r = 0; r < arr2.length; r++) {
				if (roomCount < arr2[r]) {
					maxIndex = r;
					roomCount = arr2[r];
				}
			}
			// maxIndex의 Pos값이 결과
			visited[queue.peek()] = true;

			System.out.println("peek =" + queue.peek());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			pos[queue.peek()] = new Pos(list.get(maxIndex).xPos, list.get(maxIndex).yPos);
			map[list.get(maxIndex).xPos][list.get(maxIndex).yPos] = queue.poll();

			// 리스트가 비어있을때는 xPos는 최대위의 값 yPos는 왼쪽의 값

		}
		// 나온 결과값으로 만족도 구하기
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				// 값마다 4방탐색
				int resultCount = 0;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						for (int value : arr[map[x][y]]) {
							if (value == map[nx][ny]) {
								resultCount += 1;
								break;
							}
						}
					}
				}
				if (resultCount > 0) {
					result += Math.pow(10, resultCount - 1);
				}
			}
		}
		System.out.println(result);

	}

	public static class Pos {
		int xPos;
		int yPos;

		public Pos(int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
		}
	}

}
