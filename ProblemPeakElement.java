import java.util.Arrays;
import java.util.Scanner;

public class ProblemPeakElement {
    public static int findPeakElement(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while (left<right) {
            int mid=left+(right-left)/2;

            if (arr[mid]>arr[mid+1]) {
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return arr[left];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findPeakElement(arr));
    }
}