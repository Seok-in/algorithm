import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1644 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[N+1];
        arr[0] = arr[1] = true;
        for(int i=2;i<Math.sqrt(arr.length);i++){
            if(arr[i]==true){
                continue;
            }
            for(int j=i*i;j<arr.length;j=j+i){
                arr[j] = true;
            }
        }
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i=2;i<arr.length;i++){
            if(arr[i]==false){
                prime.add(i);
            }
        }
        int count =0;
        for(int i=0;i<prime.size();i++){
            int sum = prime.get(i);
            int num = i+1;
            while(true){
                if(sum==N){
                    count += 1;
                    break;
                }
                if(sum>N){
                    break;
                }

                if(num >= prime.size()){
                    break;
                }
                sum += prime.get(num);
                num+=1;
            }
        }
        System.out.println(count);
    }

}

