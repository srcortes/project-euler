import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,6,8,12,22,7,1,8,2,5};
        int target = 20;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        // Input validation
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement was seen before
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current value and index
            map.put(nums[i], i);
        }

        // No pair found
        return new int[]{-1, -1};
    }

}
