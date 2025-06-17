## 🔁 Transpose of a Matrix

> Given a 2D integer matrix `A`, return its **transpose**.  
> The transpose of a matrix is formed by **flipping it over its main diagonal**, i.e., switching rows with columns.

🔗 **LeetCode Equivalent:**  
[867. Transpose Matrix](https://leetcode.com/problems/transpose-matrix/)

---

### 📘 Example

#### Input:
```java
A = [
  [1, 2, 3],
  [4, 5, 6]
]
### Output:
[
  [1, 4],
  [2, 5],
  [3, 6]
]

~~~JAVA
public class Solution {
    public int[][] solve(int[][] A) {
        int n = A.length;        // number of rows
        int m = A[0].length;     // number of columns

        int[][] ans = new int[m][n];  // Transposed matrix has flipped dimensions

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = A[j][i];  // Swap rows and columns
            }
        }

        return ans;
    }
}

---------------------------------------------------------------------------------------------------------------------------------------

🧠 Explanation
Original size: n x m
Transposed size: m x n
For each position (i, j) in the result, we take A[j][i] from original

