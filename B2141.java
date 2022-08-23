import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2141 {
    static Vil vils[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;

        vils = new Vil[N];
        for(int i=0;i<N;i++){
            String str[] = br.readLine().split(" ");
            long x = Long.parseLong(str[0]);
            long a = Long.parseLong(str[1]);
            vils[i] = new Vil(x, a);
            result += a;
        }
        Arrays.sort(vils);
        long sum =0;
        for(Vil vil : vils){
            sum += vil.A;
            if(sum >=(result+1)/2){
                System.out.println(vil.X);
                break;
            }
        }

    }
    public static class Vil implements Comparable<Vil>{
        long X;
        long A;
        public Vil(long x, long a){
            this.X =x;
            this.A =a;
        }
        @Override
        public int compareTo(Vil o){
            if(this.X==o.X){
                return (int)(this.A-o.A);
            }
            return (int) (this.X-o.X);
        }
    }
}
