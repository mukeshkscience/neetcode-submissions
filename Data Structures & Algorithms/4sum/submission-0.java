public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + 0L + nums[c] + nums[d] == target) {
                            res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}