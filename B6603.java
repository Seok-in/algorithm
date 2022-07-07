import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6603 {
    public static int[] num =new int[6];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==0) {
                break;
            }
            int arr[] = new int[a];
            for(int i=0;i<a;i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            comb(0,0,arr);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
    public static void comb(int count, int start, int[] arr) {
        if(count == 6) {
            for(int i:num) {
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        for(int j=start;j<arr.length;j++) {
            num[count]=arr[j];
            comb(count+1,j+1,arr);
        }
    }
}