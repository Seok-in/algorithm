import java.util.Scanner;

public class 실습04_1로만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N+1];
		arr[0]=0;
		arr[1]=0;			
		for(int i=2;i<N+1;i++) {			
			arr[i]=arr[i-1]+1;
			if(i%2==0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
			if(i%3==0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
		}
		System.out.println(arr[N]);
	}
}
