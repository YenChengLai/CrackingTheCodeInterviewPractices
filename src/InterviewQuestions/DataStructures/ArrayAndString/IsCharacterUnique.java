package InterviewQuestions.DataStructures.ArrayAndString;

// Question Statement: Check whether there's any character appeared more than once in the input string
// Example
// Input: "aba"
// Output: false
// Explanation: "a" appeared twice

public class IsCharacterUnique {

    public static void main(String[] args) {
        System.out.println("Input1: Hello");
        System.out.println("Output1: " + isCharacterUnique("Hello"));

        System.out.println("Input2: Today");
        System.out.println("Output2: " + isCharacterUnique("Today"));

        System.out.println("Input1: Hello");
        System.out.println("Output1: " + isCharacterUnique2("Hello"));

        System.out.println("Input2: Today");
        System.out.println("Output2: " + isCharacterUnique2("Today"));
    }

    // TC: O(N) SC: O(1)
    private static boolean isCharacterUnique(String str) {

        // check if the character is bigger than the ASCII code range
        if (str.length() > 128) {
            return false;
        }

        boolean[] chars = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            // if the below expression is true, then the character is already visited
            if (chars[str.charAt(i)]) {
                return false;
            }
            chars[str.charAt(i)] = true;
        }
        return true;
    }

    /**
     * Suppose we have the string "hello":
     * 1. Initialize checker to 0 (checker = 0).
     * 2. Loop through the characters in the string:
     *    For the first character 'h':
     *        val = 'h' - 'a' = 7 (since the ASCII value of 'h' is 104 and the ASCII value of 'a' is 97).
     *        1 << val = 1 << 7 = 128 (in binary, this is 10000000).
     *        checker & (1 << val) = 0 & 128 = 0 (since the val-th bit is not set in checker).
     *        checker |= (1 << val): This sets the val-th bit in checker. After this operation, checker = 128 (in binary, this is 10000000).
     *    For the second character 'e':
     *        val = 'e' - 'a' = 4 (since the ASCII value of 'e' is 101 and the ASCII value of 'a' is 97).
     *        1 << val = 1 << 4 = 16 (in binary, this is 00010000).
     *        checker & (1 << val) = 128 & 16 = 0 (since the val-th bit is not set in checker).
     *        checker |= (1 << val): This sets the val-th bit in checker. After this operation, checker = 144 (in binary, this is 10010000).
     *    For the third character 'l':
     *        val = 'l' - 'a' = 11 (since the ASCII value of 'l' is 108 and the ASCII value of 'a' is 97).
     *        1 << val = 1 << 11 = 2048 (in binary, this is 100000000000).
     *        checker & (1 << val) = 144 & 2048 = 0 (since the val-th bit is not set in checker).
     *        checker |= (1 << val): This sets the val-th bit in checker. After this operation, checker = 2192 (in binary, this is 100010001000).
     *    For the fourth character 'l' (again):
     *        val = 'l' - 'a' = 11.
     *        1 << val = 1 << 11 = 2048.
     *        checker & (1 << val) = 2192 & 2048 = 2048 (since the val-th bit is set in checker).
     *        Since checker & (1 << val) is non-zero, it means the character 'l' has been encountered before, so the function returns false.
     * */
    private static boolean isCharacterUnique2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
