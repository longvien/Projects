import com.geometry.triangle.Triangle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        int[] list = {1, 2, 3};
        System.out.println(runningSum(list));
    }
    public static int[] runningSum(int[] nums) {
        int[] current = new int[nums.length];
        int counter = 0;
        int prevVal = 0;
        while(counter < nums.length) {
            if (counter == 0) {
                current[counter] = nums[counter];
                prevVal = current[counter];
            }
            else {
                current[counter] = prevVal + nums[counter];
                prevVal = current[counter];
            }
            counter++;
        }
        return current;
    }
}


