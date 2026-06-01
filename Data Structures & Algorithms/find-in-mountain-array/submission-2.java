/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findPeak(mountainArr);

        // Search in ascending part
        int leftSearch = binarySearch(
                mountainArr,
                target,
                0,
                peak,
                true
        );

        if (leftSearch != -1) {
            return leftSearch;
        }

        // Search in descending part
        return binarySearch(
                mountainArr,
                target,
                peak + 1,
                mountainArr.length() - 1,
                false
        );
    }

    // Find peak index
    private int findPeak(MountainArray arr) {

        int left = 0;
        int right = arr.length() - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Binary search for ascending/descending array
    private int binarySearch(
            MountainArray arr,
            int target,
            int left,
            int right,
            boolean ascending
    ) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            if (ascending) {

                if (value < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {

                if (value < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}