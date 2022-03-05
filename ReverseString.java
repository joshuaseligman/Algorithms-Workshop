public class ReverseString {

    /**
     * Method that reverses a string
     * @param s The string to reverse
     * @return A reversed version of the original string
     */
    public static String reverseString(String s) {
        // Create a new StringBuilder to prevent a lot of copying of strings
        StringBuilder reversed = new StringBuilder();
        // Work through the string backwards and add each character
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        // Put the reversed characters together
        return reversed.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(reverseString("computer"));
        System.out.println(reverseString("b"));
        System.out.println(reverseString(""));
    }
}