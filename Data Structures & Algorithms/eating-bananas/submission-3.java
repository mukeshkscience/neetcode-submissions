class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            // Calculate total hours needed at speed = mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // ceil division
            }

            if (hours <= h) {
                answer = mid;
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1; // need faster speed
            }
        }

        return answer;
    }
}