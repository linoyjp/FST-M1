package activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Activity4 {
    public static void main(String[] args) {
        int [] numberarray = {45,47,1,56,12,5,6,70};
        System.out.println("Unsorted Array:"+(Arrays.toString(numberarray)));
        ascendingsort(numberarray);
        System.out.println("Sorted Array:"+(Arrays.toString(numberarray)));
        List<Integer> sortedList=new ArrayList<Integer>();
        for (int k=0;k<numberarray.length;k++){
            sortedList.add(numberarray[k]);
        }
        Iterator itr1=sortedList.iterator();
        System.out.println("Print as list using iterator");
        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }
        }
    static void ascendingsort(int array[]){
        int size=array.length,i;
        for (i=1;i<size;i++){
            int key=array[i];
            int j=i-1;
            while (j>=0 && key< array[j]){
                array[j+1]=array[j];
                --j;
            }
            array[j+1]=key;
    }
        //numberarray=myArray;arr
    }
}
