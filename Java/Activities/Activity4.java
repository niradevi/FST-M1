package Activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] a = {5,3,7,4,9,1,2};
    int temp;
        for (int i=0; i< a.length-1; i++) {
            if (a[i]>a[i+1]) {
                int smallNumb = a[i+1];  //smalnumb =4
                for(int j=i, k=i+1; j>=0; j--,k--){  //j=2,k=3
                    if (a[j] >smallNumb){
                        temp = a[j];
                        a[j] = a[k];
                        a[k] = temp;
                    }
                    else {
                        break;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(a));
    }
}
