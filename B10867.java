import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class B10867 {
    static int sorted[];
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set= new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(str[i]));
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);

//        Iterator<Integer> it = set.iterator();
//        int arr[] = new int[set.size()];
//        for(int i=0;i<set.size();i++){
//            arr[i] = it.next();
//        }
//        mergeSort(arr);
        for(int t : arr){
            sb.append(t).append(" ");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
    }
    public static void mergeSort(int arr[]){
        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length-1);
        sorted=null;
    }
    public static void mergeSort(int arr[], int left, int right){
        if(left == right) return;
        int mid = (left+right)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr, left, mid, right);
    }
    public static void merge(int arr[], int left, int mid, int right){
        int l = left;
        int r = mid+1;
        int idx = left;

        while(l<=mid&& r<=right){
            if(arr[l]<=arr[l]){
                sorted[idx] = arr[l];
                idx++;
                l++;
            }
            else{
                sorted[idx] =arr[r];
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
        for(int i=left;i<=right;i++){
            arr[i] = sorted[i];
        }
    }
}
