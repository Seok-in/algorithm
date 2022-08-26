import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10815 {
    static int sorted[];
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringBuilder sb = new StringBuilder();
        String str[] = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        int M = Integer.parseInt(br.readLine());
        int arr2[] = new int[M];
        String str2[] = br.readLine().split(" ");
        mergeSort(arr);
        for(int i=0;i<M;i++){
            sb.append(binary(Integer.parseInt(str2[i]))).append(" ");
        }
        System.out.println(sb);
    }
    public static int binary(int find){
        int mid;
        int left =0;
        int right=arr.length-1;

        while(left<=right){
            mid=(left+right)/2;
            if(arr[mid]==find){
                return 1;
            }
            if(find < arr[mid]){
                right = mid -1;
            } else{
                left = mid+1;
            }
        }
        return 0;
    }
    public static void mergeSort(int arr[]){
        sorted = new int[arr.length];
        mergeSort(arr,0,arr.length-1);
    }
    public static void mergeSort(int arr[], int left, int right){
        if(left == right) return;
        int mid = (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr,mid+1, right);
        merge(arr,left, mid, right);
    }
    public static void merge(int arr[], int left, int mid, int right){
        int l = left;
        int r = mid + 1;
        int idx = left;

        while(l<=mid && r <= right){
            if(arr[l]<=arr[r]){
                sorted[idx] = arr[l];
                idx++;
                l++;
            }
            else{
                sorted[idx]=arr[r];
                idx++;
                r++;
            }
        }
        if(l>mid){
            while(r<=right){
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        }
        else{
            while(l<=mid){
                sorted[idx]=arr[l];
                idx++;
                l++;
            }
        }
        for(int i= left;i<=right;i++){
            arr[i]=sorted[i];
        }
    }
}
