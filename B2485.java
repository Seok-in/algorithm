import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int diff[] = new int[N-1];
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int j=0;j<N-1;j++){
            diff[j] = list.get(j+1) - list.get(j);
        }
        int value = diff[0];
        for(int t=1;t<N-1;t++){
            value = gdc(value, diff[t]);
        }
        int count = 0;
        for(int i=0;i<N-1;i++){
            int a = list.get(i);
            while(true){
                if(a+value == list.get(i+1)){
                    break;
                }
                a+=value;
                count+=1;
            }
        }
        System.out.println(count);
    }
    static int gdc(int a, int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b!=0){
            int r = a%b;
            a=b;
            b=r;
        }
        return a;
    }
}