package lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class B_1713 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> queue = new ArrayList<>();
		int[] arr = new int[M];
		String str[] = br.readLine().split(" ");

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(str[i]);
			// 사진틀이 비어있을때
			if (queue.size() < N) {
				// 사진틀에 있는 사진이면
				if (map.containsKey(arr[i])) {					
					map.replace(arr[i], map.get(arr[i]) + 1);
				}

				// 없는 사진인경우
				else {
					queue.add(arr[i]);
					map.put(arr[i], 1);
				}
			}
			// 사진틀이 차있을때
			else {	
				
				if (map.containsKey(arr[i])) {
					map.replace(arr[i], map.get(arr[i]) + 1);
				}
					
				// 수를 비교
				else {
					List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
					// Map을 오름차순으로 정렬
					Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
						// compare로 값 비교
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							// 오름 차순 정렬
							return o1.getValue().compareTo(o2.getValue());
						}
					});

					// list의 가장 앞에 값과 같으면 걔를 사진틀에서 뺀다.
					for (int t = 0; t < N; t++) {
						if (map.get(queue.get(t)) == list.get(0).getValue()) {							
							map.remove(queue.get(t));
							queue.remove(t);				
							break;
						}
					}
					// list에 추가해준다
					
					map.put(arr[i], 1);
					queue.add(arr[i]);
					
				}
			}
		}		
		Collections.sort(queue);
		for (int i : queue) {
			System.out.print(i + " ");
		}
	}
}
