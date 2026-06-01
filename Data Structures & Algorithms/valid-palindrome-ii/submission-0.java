public class Solution {
    public boolean validPalindrome(String s) {
        if (isPalindrome(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            String newS = s.substring(0, i) + s.substring(i + 1);
            if (isPalindrome(newS)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}