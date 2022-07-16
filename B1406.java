import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class B1406 {
    static LinkedList<String> list = new LinkedList<>();
    static ListIterator<String> iter;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split("");
        iter = list.listIterator();

        for(int i=0;i<str.length;i++){
            iter.add(str[i]);
        }
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            func(br.readLine());
        }
        for(String st : list){
            bw.write(st);
        }
        bw.flush();
        bw.close();
    }
    public static void func(String str){
        String str2[] = str.split(" ");
        if(str2[0].equals("P")){
            iter.add(str2[1]);
        }
        else if(str2[0].equals("L")){
            if(iter.hasPrevious()){
                iter.previous();
            }
        }
        else if(str2[0].equals("D")){
            if(iter.hasNext())
                iter.next();
        }
        else if(str2[0].equals("B")){
            if(iter.hasPrevious()){
                iter.previous();
                iter.remove();
            }
        }
    }
}
