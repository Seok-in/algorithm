import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            result = 0;
            int n = Integer.parseInt(br.readLine());
            func(n);
            sb.append(result);
            if(i<T-1){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void func(int n){
        if(n==0){
            result += 1;
            return;
        }
        // 3보다 크면
        if(n>=3){
             func(n-3);
             func(n-2);
             func(n-1);
        }
        // 2보다 크면
        else if(n>=2){
            func(n-2);
            func(n-1);
        }
        // 1보다 크면
        else if(n>=1){
            func(n-1);
        }

    }
}
