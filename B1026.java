import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class B1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        Integer arr2[] = new Integer[N];
        String str[] = br.readLine().split(" ");
        String str2[] = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(str[i]);
            arr2[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(arr2, Collections.reverseOrder());
        int result =0;
        for(int i=0;i<N;i++){
           result+=(arr[i]*arr2[i]);
        }
        System.out.println(result);
    }
}
