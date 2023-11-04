package InterviewQuestions.DataStructures.ArrayAndString;

// Question Statement: Check whether the input string is palindromic or not
// Example 1
// Input: "A man, a plan, a canal: Panama"
// Output: true
// Explanation: we only consider letters and digits, uppercase and lowercase is regarded as the same char, thus make it palindromic

public class IsPalindromic {

    public static void main(String[] args) {
        System.out.println(isPalindromic("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromic("race a car"));
    }

    // TC: O(n)  SC: O(1)
    public static boolean isPalindromic(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(str.charAt(left++)) != Character.toLowerCase(str.charAt(right--))) {
                return false;
            }
        }

        return true;
    }
}
