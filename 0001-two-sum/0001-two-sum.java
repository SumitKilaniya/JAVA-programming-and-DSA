import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length * 2);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            Integer index = map.get(complement);
            if (index != null) {
                return new int[]{index, i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}