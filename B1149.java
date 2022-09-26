import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1149 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N+1][3];
        String str[] = br.readLine().split(" ");
        arr[1][0] = Integer.parseInt(str[0]);
        arr[1][1] = Integer.parseInt(str[1]);
        arr[1][2] = Integer.parseInt(str[2]);
        for(int i=2;i<N+1;i++) {
            String str2[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str2[0]) + Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] = Integer.parseInt(str2[1]) + Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] = Integer.parseInt(str2[2]) + Math.min(arr[i-1][0], arr[i-1][1]);
        }

        arr[N][0]=Math.min(arr[N][0], arr[N][1]);
        arr[N][0]=Math.min(arr[N][0], arr[N][2]);

        System.out.println(arr[N][0]);
    }
}
