import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B9576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String str[] = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            int arr[][] = new int[M+1][2];
            for(int j=1;j<=M;j++){
                String str2[] = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(str2[0]);
                arr[j][1] = Integer.parseInt(str2[1]);
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1]){
                        return o1[0]-o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });
            int count =0;
            boolean visited[] = new boolean[M+1];
            for(int p=1;p<=N;p++){
                for(int j=1;j<=M;j++){
                    if(arr[j][0]<=p && arr[j][1]>=p&&!visited[j]){
                        count+=1;
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
