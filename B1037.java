import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int max =0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<num;i++){
            max = Math.max(max, Integer.parseInt(str[i]));
            min = Math.min(min, Integer.parseInt(str[i]));
        }
        System.out.println(min*max);
    }
}
