
public class 실습03_막대색칠하기_홍석인 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[7];
		arr[0]=1;
		arr[1]=2;
		for(int i=2;i<7;i++) {
			arr[i] = arr[i-2] *2 + arr[i-1];
		}
		System.out.println(arr[6]);
	}

}
