import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1920 {
    static int arr[];
    static int arr2[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str[] =br.readLine().split(" ");
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        arr2 = new int[M];
        String str2[] =br.readLine().split(" ");
        for(int i=0;i<M;i++){
            arr2[i] = Integer.parseInt(str2[i]);
        }
        for(int j=0;j<M;j++){
           arr2[j] = binary(N-1,0,j);
           System.out.println(arr2[j]);
        }
    }
    public static int binary(int high, int low, int key){
        int mid;
        while(low <= high){
            mid = (low+high)/2;
            if(arr2[key] == arr[mid]){
                return 1;
            } else if(arr2[key] < arr[mid]){
                high = mid -1;
            } else if(arr2[key] > arr[mid]){
                low = mid + 1;
            }
        }
        return 0;
    }
}