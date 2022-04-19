import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str2 = br.readLine();
		int max =0;
		int arr[][] = new int[str.length()+1][str2.length()+1];
		for(int i=1;i<=str.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str.charAt(i-1) ==str2.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1] + 1;
					max = Math.max(max, arr[i][j]);
				}
			}
		}
		System.out.println(max);
	}

}
