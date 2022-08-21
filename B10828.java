import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10828 {
    static Stack<String> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            func(br.readLine());
        }
        System.out.println(sb);
    }
    public static void func(String str){
        String str2[] = str.split(" ");
        if(str2[0].equals("push")){
            stack.push(str2[1]);
        }
        else if(str2[0].equals("top")){
            if(stack.isEmpty()){
                sb.append(-1).append("\n");
            }
            else{
                sb.append(stack.peek()).append("\n");
            }
            
        }
        else if(str2[0].equals("size")){
            sb.append(stack.size()).append("\n");
        }
        else if(str2[0].equals("empty")){
            if(stack.isEmpty()){
                sb.append(1).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }
        else if(str2[0].equals("pop")){
            if(stack.isEmpty()){
                sb.append(-1).append("\n");
            }
            else{
                sb.append(stack.pop()).append("\n");
            }
        }
    }
}
