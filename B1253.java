import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Boolean> visited = new HashMap<>();
        int arr[] = new int[N];
        Map<Integer, Boolean> map = new HashMap<>();
        String str[] = br.readLine().split(" ");
        int zeroCount = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(str[i]);
            map.put(arr[i], false);
            visited.put(arr[i], false);
            if(arr[i]==0){
                zeroCount += 1;
            }
        }
        Arrays.sort(arr);
        int sum =0;
        // 2개의 수 선택
        for(int i=0;i<N;i++) {
            for(int t=0;t<N;t++){
                visited.put(arr[t], false);
            }
            for (int j = i + 1; j < N; j++) {
                sum = arr[i] + arr[j];
                // 0을 골랐을때 자기자신이면 안됨.
                if(arr[i]==0){
                        if (visited.get(arr[j])) {
                            map.put(sum, true);
                        } else {
                            visited.put(arr[j], true);
                        }
                }
                else if(arr[j]==0){
                        if (visited.get(arr[i])) {
                            map.put(sum, true);
                        } else {
                            visited.put(arr[i], true);
                        }
                }

                else{
                    map.put(sum, true);
                }
            }
        }

        int count =0;
        for(int i=0;i<N;i++){
            if(map.get(arr[i])){
                count += 1;
            }
        }
        System.out.println(count);
    }
}
