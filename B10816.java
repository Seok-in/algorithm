import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int arr[] = new int[20000002];
        for(int i=0;i<N;i++){
            arr[Integer.parseInt(str[i])+10000000] += 1;
        }
        int M = Integer.parseInt(br.readLine());
        String str2[] = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            sb.append(arr[Integer.parseInt(str2[i])+10000000]).append(" ");
        }
        System.out.println(sb);
    }
}
