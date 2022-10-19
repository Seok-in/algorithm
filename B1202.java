import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        ArrayList<Gold> golds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str2[] = br.readLine().split(" ");
            golds.add(new Gold(Integer.parseInt(str2[0]), Integer.parseInt(str2[1])));
        }
        Collections.sort(golds, new Comparator<Gold>() {
            @Override
            public int compare(Gold o1, Gold o2) {
                if (o1.weight == o2.weight) {
                    return o2.value - o1.value;
                }
                return o1.weight - o2.weight;
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<K;i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        PriorityQueue<Gold> getGolds = new PriorityQueue<>(new Comparator<Gold>() {
            @Override
            public int compare(Gold o1, Gold o2) {
                return o2.value-o1.value;
            }
        });
        long count =0;
        int i =0;
        while(!queue.isEmpty()){
            int bag = queue.poll();
            while(i<N && bag >= golds.get(i).weight){
                getGolds.add(golds.get(i));
                i++;
            }
            if(!getGolds.isEmpty()){
                count+=getGolds.poll().value;
            }
        }
        System.out.println(count);
    }

    public static class Gold {
        int weight;
        int value;

        public Gold(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }
}
