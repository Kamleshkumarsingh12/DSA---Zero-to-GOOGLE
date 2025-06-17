## 🔄 Rotate Matrix by 90 Degrees Clockwise (In-Place)

> Given a `n x n` 2D matrix representing an image, rotate it **by 90 degrees clockwise** in-place.

🔗 **LeetCode Equivalent:**  
[🔗 LeetCode 48 - Rotate Image](https://leetcode.com/problems/rotate-image/)

---

### 📘 Example

#### Input:
```java
A = [
 [1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]
]

### Ouput:
A = [
 [7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]
]

✅ Java Code (In-Place):
  public class Solution {
    public void solve(int[][] A) {
        int n = A.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

        // Step 2: Reverse each row (2-pointer technique)
        for (int row = 0; row < n; row++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = A[row][left];
                A[row][left] = A[row][right];
                A[row][right] = temp;
                left++;
                right--;
            }
        }
    }
}

----------------------------------------------------------------------------------------------------------------
🧠 Explanation
-  Transpose: Convert rows to columns (i.e., A[i][j] = A[j][i]) 
-  Reverse each row: Swap elements horizontally to complete 90° clockwise rotation 
-  This approach avoids using extra space (no additional matrix used), just using a temp variable. 
-  Keep in mind the second loop iterations when we doing the transpose, j is starting from i not 0. This is to avoid extra swaps as swapped value gets swapped again to its original space. 
