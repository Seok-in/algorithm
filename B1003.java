import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1003 {
    public static void main(String[] args) throws IOException {
        int arr[][] = new int[41][2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        for(int i=2;i<=40;i++){
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N][0]).append(" ").append(arr[N][1]);
            if(i!=T-1){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

}
