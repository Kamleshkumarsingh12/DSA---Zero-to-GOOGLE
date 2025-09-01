🔤 Sort Characters in a String (Alphabetically)
🚀 Problem Statement
Given a string consisting of lowercase English letters, return a new string with its characters sorted in alphabetical order.
  🔗 Related LeetCode Problem
  🔗 Custom Sort String – LeetCode #791 (related, but not exact)
  Note: This problem lets you sort based on a custom order string, but frequency/character sort concepts are similar


📥 Input
A lowercase string S.
📤 Output
The string with characters sorted in increasing lexicographical order.
 -----------------------
🧠 Approach
-We use a frequency array of size 26 to simulate counting sort, since the characters are limited to 'a' to 'z'.
-Count how many times each character appears.
-Traverse the frequency array, and construct the sorted result.
 -----------------------
📄 Example:
  Input:  "baacdh"  
  Output: "aabcdh"


`````✅ Code
  public class MyClass {
    public static void main(String args[]) {
        String s = "baacdh";
        System.out.println(s + " before sorting");
        System.out.println(Sorting(s));
    }

    public static String Sorting(String S){
        int n = S.length();
        int[] arr = new int[26];  // frequency array

        for (int i = 0; i < n; i++) {
            arr[S.charAt(i) - 'a']++; // increment frequency
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)(i + 'a');
            for (int j = 0; j < arr[i]; j++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}

````` ⏱ Time Complexity
O(N + 26) → O(N)
(N = length of the string, 26 = fixed alphabet size)

💾 Space Complexity
O(1) → Uses fixed space (size 26 array)

------------------------------------------------------------------------------------------
