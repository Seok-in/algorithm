import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B6588 {
    static StringBuilder sb = new StringBuilder();
    static boolean arr[];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        arr = new boolean[1000001];
        arr[0] = arr[1] =true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=2;i<Math.sqrt(1000001);i++){
            if(arr[i]==true){
                continue;
            }
            for(int j=i*i;j<arr.length;j=j+i){
                arr[j] = true;
            }
        }
        for(int i=3;i<arr.length;i++){
            if(arr[i]==false){
                list.add(i);
            }
        }
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            gb(N);
        }
        String sb1 = sb.substring(0,sb.length()-1);
        System.out.println(sb1);
    }
    static void gb(int N){
        int a = 0;
        int b =0;
        for(int i=0;i<list.size();i++){
            if(N>list.get(i)){
                if(arr[N-list.get(i)]==false){
                    a= list.get(i);
                    b = N-list.get(i);
                }
            }
            if(a!=0){
                break;
            }
        }
        if(a==0){
            sb.append("Goldbach's conjecture is wrong.\n");
        }
        else{
            String str = N +" = " +a+" + "+b;
            sb.append(str).append("\n");
        }
    }
}

