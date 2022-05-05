package activities;

public class Activity2 {
    public static void main(String[] args) {
        int [] myArray1 = new int[]{10, 77, 10, 54, -11, 10};
        int tmp1=-0;
        for (int x:myArray1) {
            if (x==10){
                tmp1+=x;
            }
            if (tmp1>30){
                break;
            }
        }
        System.out.println("Result: " + tmp1);
    }
}
