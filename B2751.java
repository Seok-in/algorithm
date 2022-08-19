import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        boolean[] arr = new boolean[2000001];
        for(int i=0;i<N;i++){
            int k= Integer.parseInt(br.readLine());
            arr[k+1000000] = true;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]){
                sb.append(i-1000000).append("\n");
            }
        }
        System.out.println(sb);
    }
}