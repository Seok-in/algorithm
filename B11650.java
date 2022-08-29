import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pos> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            String str[] = br.readLine().split(" ");
            list.add(new Pos(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }
        Collections.sort(list);
        for(Pos pos : list){
            System.out.println(pos.xPos+" "+pos.yPos);
        }
    }
    public static class Pos implements Comparable<Pos>{
        int xPos;
        int yPos;
        public Pos(int xPos, int yPos){
            this.xPos = xPos;
            this.yPos = yPos;
        }
        @Override
        public int compareTo(Pos o){
            if(this.xPos == o.xPos){
                return this.yPos-o.yPos;
            }
            else{
                return this.xPos - o.xPos;
            }
        }
    }
}
