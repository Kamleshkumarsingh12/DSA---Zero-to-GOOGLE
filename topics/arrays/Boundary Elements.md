## 🧱 Problem: Print Boundary Elements of a Matrix

**Problem Description:**

You're given an `n x m` matrix. Your task is to print all the **boundary elements** in clockwise order, starting from the top-left corner.

- The boundary includes the **top row**, **rightmost column**, **bottom row**, and **leftmost column**.
- Handle edge cases like:
  - Single row (`n == 1`)
  - Single column (`m == 1`)

---

### 🔗 LeetCode Equivalent:
There is no exact LeetCode version, but a similar traversal logic can be found in:  
🔗 [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

---

### 📘 Example

#### Input:
```java
A = [
 [1, 2, 3, 4],
 [5, 6, 7, 8],
 [9, 10,11,12]
]

###Output:
[1, 2, 3, 4, 8, 12, 11, 10, 9, 5]


✅ Final Code (Robust with Edge Cases):
  ```JAVA
    public int[] boundary(int[][] A) {
    int n = A.length;
    int m = A[0].length;

    // Edge case 1: Single row
    if (n == 1) {
        int[] ans = new int[m];
        for (int j = 0; j < m; j++) ans[j] = A[0][j];
        return ans;
    }

    // Edge case 2: Single column
    if (m == 1) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = A[i][0];
        return ans;
    }

    // General case
    int[] ans = new int[2 * (n + m) - 4];
    int c = 0, i = 0, j = 0;

    // Top row (left to right)
    for (int k = 0; k < m - 1; k++) ans[c++] = A[i][j++];

    // Right column (top to bottom)
    for (int k = 0; k < n - 1; k++) ans[c++] = A[i++][j];

    // Bottom row (right to left)
    for (int k = 0; k < m - 1; k++) ans[c++] = A[i][j--];

    // Left column (bottom to top)
    for (int k = 0; k < n - 1; k++) ans[c++] = A[i--][j];

    return ans;
}

-----------------------------------------------------------------------------
🧠 Logic Summary-
| Step       | Description                        |
| ---------- | ---------------------------------- |
| Top Row    | Left to right (first row)          |
| Right Col  | Top to bottom (last column)        |
| Bottom Row | Right to left (last row)           |
| Left Col   | Bottom to top (first column)       |
| Edge Cases | Handle single row or single column |

⏱ Time & Space Complexity - 
| Metric | Value    |
| ------ | -------- |
| Time   | O(n + m) |
| Space  | O(n + m) |


