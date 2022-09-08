import java.io.*;

public class B1929 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
        int arr[] = new int[N+1];
        if(M==1)
            M+=1;
        for(int i=2;i<=N;i++) {
            if(arr[i]!=0)
                continue;
            else
                for(int j=2;j*i<=N;j++) {
                    arr[j*i]=1;
                }
        }
        for(int i=M;i<=N;i++) {
            if(arr[i]==0)
                bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }

}
