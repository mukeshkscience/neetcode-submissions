class Solution {

    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        // Search space
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {

        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subarrays <= k;
    }
}