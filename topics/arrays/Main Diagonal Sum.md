## 🔷 Sum of Main Diagonal Elements

> Given an `N x N` integer matrix, return the **sum of the main diagonal** (elements where row index = column index).

🧠 Tags: Matrix, Traversal, Basic  
🔗 Similar Problem: [LeetCode 1572 – Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/)

---

### 🐢 Easy Implementation (While Loop)

```java
public int solve(final int[][] A) {
    int n = A.length;
    int sum = 0;
    int i = 0;

    // Loop while i < n and we're on the main diagonal
    while (i < n) {
        sum += A[i][i];
        i++;
    }

    return sum;
}

-------------------------------------------------------------------------------------------------------------------------------------------------------

🧠 Explanation
Main diagonal elements are at positions (0,0), (1,1), ..., (n-1, n-1)
The code simply iterates index i from 0 to n-1 and accumulates A[i][i]

A = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
Main Diagonal Elements: 1, 5, 9  
Output: 15
