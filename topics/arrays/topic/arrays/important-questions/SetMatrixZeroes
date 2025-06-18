## 🧨 Set Matrix Zeroes

> You're given a 2D matrix `A`. If any cell `A[i][j]` is `0`, set **entire row `i` and column `j`** to `0`.

🔗 **LeetCode Equivalent:**  
[🔗 LeetCode 73 - Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

---

### 📘 Example

#### Input:
```java
A = [
 [1, 2, 3],
 [4, 0, 6],
 [7, 8, 9]
]

### Output:
A = [
 [1, 0, 3],
 [0, 0, 0],
 [7, 0, 9]
]
_________________________________________________________________
✅ Code 1: Using Extra Space (Boolean Arrays)-
  public int[][] solve(int[][] A) {
    int n = A.length;
    int m = A[0].length;
    boolean[] rowHasZero = new boolean[n];
    boolean[] colHasZero = new boolean[m];

    // Step 1: Mark rows and columns with zeros
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (A[i][j] == 0) {
                rowHasZero[i] = true;
                colHasZero[j] = true;
            }
        }
    }

    // Step 2: Set corresponding cells to 0
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (rowHasZero[i] || colHasZero[j]) {
                A[i][j] = 0;
            }
        }
    }

    return A;
}
---------------------------------------------------------------------------------------------
💡 Approach Summary
- Traverse the matrix and remember which rows and columns should be zeroed.
- Then apply the zeroes in a second loop.

✅ Simple and clear
❌ Uses O(n + m) extra space
______________________________________________________________

✅ Code 2: Using In-Place Marking (With Sentinel Value -1)-
  public int[][] solve(int[][] A) {
    int n = A.length;
    int m = A[0].length;

    // Step 1: Mark cells to be zeroed with -1
    for (int i = 0; i < n; i++) {
        boolean rowHasZero = false;
        for (int j = 0; j < m; j++) {
            if (A[i][j] == 0) rowHasZero = true;
        }
        if (rowHasZero) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != 0) A[i][j] = -1;
            }
        }
    }

    for (int j = 0; j < m; j++) {
        boolean colHasZero = false;
        for (int i = 0; i < n; i++) {
            if (A[i][j] == 0) colHasZero = true;
        }
        if (colHasZero) {
            for (int i = 0; i < n; i++) {
                if (A[i][j] != 0) A[i][j] = -1;
            }
        }
    }

    // Step 2: Convert -1 to 0
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (A[i][j] == -1) A[i][j] = 0;
        }
    }

    return A;
}

------------------------------------------------------------------------------------
🧠 How It Works (In Hinglish):
- Pehle har row aur column check karo jisme 0 hai.
- Jis row ya column mein 0 mile, uske non-zero elements ko temporarily -1 mark karo.
- Baad mein, saare -1 wapas 0 mein convert kar do.

✅ Works without extra boolean arrays
❌ Be careful: -1 shouldn't exist in original input, or it will break logic.

