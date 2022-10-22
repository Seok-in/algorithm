import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        ArrayList<String> list = new ArrayList<>();
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
            }
        });
        for(int i=0;i<N;i++){
            String str2 = br.readLine();
            list.add(str2);
            queue.add(str2);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.equals(o2)){
                    return 0;
                }
                if(o1.length()==o2.length()){
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                }
                else{
                    int min = Math.min(o1.length(), o2.length());
                    for(int i=0;i<min;i++){
                        if(o1.charAt(i) != o2.charAt(i)){
                            return o2.charAt(i)-o1.charAt(i);
                        }
                    }
                    if(o1.length() > o2.length()){
                        if(o2.charAt(min-1)==o1.charAt(min)){
                            return o1.length()-o2.length();
                        }
                        return o2.charAt(min-1) - o1.charAt(min);
                    }
                    else{
                        if(o2.charAt(min)==o1.charAt(min-1)){
                            return o1.length()-o2.length();
                        }
                        return o2.charAt(min) - o1.charAt(min-1);
                    }
                }
            }
        });
        String result="";
        String max = queue.peek();
        ArrayList<String> hey = new ArrayList<>();
        int maxIndex = -1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(max)){
                maxIndex = i;
            }
            hey.add(list.get(i));
        }
        K-= list.size();
        for(int i=0;i<K;i++){
            hey.add(maxIndex, max);
        }
        for(int i=0;i<hey.size();i++){
            result+=hey.get(i);
        }
        System.out.println(result);
    }

}
