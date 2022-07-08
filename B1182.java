import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1182 {
    static int arr2[];
    static int arr[];
    static int N,S;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);
        arr2 = new int[N];
        arr = new int[N];
        String str2[] = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(str2[i]);
        }
        func1(0,0,arr2);
        if(S==0){
            count-=1;
        }
        System.out.println(count);
    }
    public static void func1(int start, int select, int arr2[]){
        int sum =0;
        if(start==N){
            for(int i : arr2){
//                System.out.print(i+" ");
                sum += i;
            }
//            System.out.println();
            if(sum == S){
                count++;
            }
            return;
        }
        // start번째를 고름
        arr2[select] = arr[start];
        func1(start+1, select +1, arr2);
        arr2[select] = 0;
        func1(start+1, select,arr2);
    }
}