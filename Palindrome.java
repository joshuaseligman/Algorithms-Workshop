public class Palindrome {
    
    /**
     * Method that determines if a string is a palindrome
     * @param s The string to check
     * @return Whether or not the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        // Make it all one case as described in the problem
        String lowerString = s.toLowerCase();

        // Keep track of the indices we are working with
        int frontIndex = 0;
        int backIndex = lowerString.length() - 1;

        while (frontIndex < backIndex) {
            // If we have different characters, we do not have a palindrome
            if (lowerString.charAt(frontIndex) != lowerString.charAt(backIndex)) {
                return false;
            }
            // Move the indices one step closer
            frontIndex++;
            backIndex--;
        }
        // We have a palindrome
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPalindrome("Tenet"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("bbaabb"));
        System.out.println(isPalindrome("car"));
        System.out.println(isPalindrome("s"));
        System.out.println(isPalindrome(""));
    }
}
