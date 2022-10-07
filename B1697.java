import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        String str[] = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        int arr[] = new int[200001];
        // 현재위치 값 1
        arr[a] = 1;
        queue.add(a);
        while(arr[b]==0){
            int num = queue.poll();
            if(num>=1 && arr[num-1]==0){
                arr[num-1] = arr[num]+1;
                queue.add(num-1);
            }
            if(num<arr.length-1 && arr[num+1]==0){
                arr[num+1] = arr[num] +1;
                queue.add(num+1);
            }
            if(num*2<arr.length && arr[num*2]==0){
                arr[num*2] = arr[num] +1;
                queue.add(num*2);
            }


        }
        System.out.println(arr[b]-1);
    }
}
