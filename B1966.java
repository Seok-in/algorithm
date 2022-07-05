import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class B1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            String str[] = br.readLine().split(" ");
            LinkedList<Printer> queue = new LinkedList<>();
            PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            String str2[] = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                queue.add(new Printer(j,Integer.parseInt(str2[j])));
                queue2.add(Integer.parseInt(str2[j]));
            }
            int count = 0;
            while(!queue2.isEmpty()){
                Printer printer = queue.poll();
                if(printer.point == queue2.peek()){
                    queue2.poll();
                    count += 1;
                    if(printer.num == M){
                        sb.append(count).append("\n");
                        break;
                    }
                }
                else{
                    queue.addLast(printer);
                }
            }
        }
        System.out.println(sb);

    }
    public static class Printer{
        int num;
        int point;
        public Printer(int num, int point){
            this.num = num;
            this.point = point;
        }
    }
}
