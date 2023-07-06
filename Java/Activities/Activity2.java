package Activities;

public class Activity2 {
    public static void main(String[] args) {

        int[] nums = {10, 77, 10, 54, -11, 10};
        int sum = 0;
        int expectedSum = 30;
        for (int num: nums) {
            if (num ==10) {
                sum+=num;
            }
        }
        System.out.println("Result:"+ (sum==expectedSum));

    }
}
