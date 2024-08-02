import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer>inputList=new ArrayList<>();

        System.out.print("Enter the number of elements in the list: ");
        int n=  sc.nextInt();
        System.out.println("Enter the elements: ");
        for (int i=0;i < n;i++){
            inputList.add(sc.nextInt());
        }

        List<Integer> result=removeDup(inputList);
        System.out.println("List with duplicates removed: " +result);
    }
    static List<Integer> removeDup(List<Integer>lst) {
        List<Integer> uniEle=new ArrayList<>();
        for (Integer ele:lst) {
            if (!uniEle.contains(ele)) {
                uniEle.add(ele);
            }
        }
        return uniEle;
    }
}