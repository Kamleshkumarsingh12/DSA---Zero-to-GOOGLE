🔁 Longest Palindromic Substring (Length)
🚀 Problem Statement
Given a string S, return the length of the longest palindromic substring that exists in it.
[A palindrome is a sequence that reads the same backward and forward.]
🔗 LeetCode Link
💡 Longest Palindromic Substring – LeetCode #5

🧠 Approach: Expand Around Center
-A palindrome mirrors around its center.
-There are 2n - 1 centers (each character and between every pair).
-For each center, expand outward as long as characters match.
-Track the maximum length found during expansion.

----------------------------------------------------------------------------------------------------------
📄 Example
Input:  "xbdyzzydbdyzydx"  
Output: 7  
Explanation: The longest palindrome is "dyzzyd"

----------------------------------------------------------------------------------------------------------

````✅ Code:
   public class MyClass {
    public static void main(String args[]) {
        String s = "xbdyzzydbdyzydx";
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            ans = Math.max(ans, LongestPalSub(s, i, i));
        }
        for (int i = 0; i < s.length(); i++) {
            // Even length palindrome
            ans = Math.max(ans, LongestPalSub(s, i, i + 1));
        }

        System.out.println(ans);
    }

    public static int LongestPalSub(String S, int p1, int p2) {
        int n = S.length();
        while (p1 >= 0 && p2 < n && S.charAt(p1) == S.charAt(p2)) {
            p1--;
            p2++;
        }
        return p2 - p1 - 1;
    }
}


________________________________________________________________________________________
⏱ Time Complexity
- O(N²): For each center, worst case expand across entire string.
- O(1) space.



