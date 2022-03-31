
public class 실습02_아파트색칠하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[9];
		arr[0] = 1;
		arr[1] = 2;

		for (int i = 2; i < 9; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];

		}
		System.out.println(arr[8]);
	}

}
