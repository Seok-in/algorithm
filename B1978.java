import java.io.*;

public class B1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int arr[] = new int[str.length];
        int arr2[] = new int[1001];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for (int j = 2; j <= 1000; j++) {
            if (arr2[j] != 0) {
                continue;
            } else {
                for (int k = 2; k * j <= 1000; k++) {
                    arr2[k * j] = 1;
                }
            }
        }
        for (int t : arr) {
            if(t==1) {
                continue;
            }
            if (arr2[t] == 0)
                count += 1;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}