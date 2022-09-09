import java.io.*;

public class B2609 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int gcb=0;
        int min =0;
        if(N>=M)
            min = M;
        else
            min=N;

        for(int i=1;i<=min;i++) {
            if(M%i==0 && N%i==0)
                gcb =i;
        }int k =M*N/gcb;
        bw.write(gcb +"\n"+k);
        bw.flush();
        bw.close();
    }

}