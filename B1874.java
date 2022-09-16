import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        int num = 1;
        stack.push(num);
        sb.append("+").append("\n");
        while(true){
            if(num == N){
                break;
            }
            if(!stack.isEmpty() && queue.peek().compareTo(stack.peek())==0){
                sb.append("-").append("\n");
                queue.poll();
                stack.pop();
            }
            else{
                num += 1;
                stack.push(num);
                sb.append("+").append("\n");
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek().compareTo(queue.peek())!=0){
                System.out.println("NO");
                return;
            }
            else{
                sb.append("-").append("\n");
                queue.poll();
                stack.pop();
            }
        }
        sb.replace(sb.length()-1,sb.length(),"");
        System.out.println(sb);
    }
}
