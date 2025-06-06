## 📌 Count "AG" Pairs in a String

**Problem Statement:**
Count the number of pairs `(i, j)` in a string `A` such that `i < j`, `A[i] == 'A'`, and `A[j] == 'G'`.
**LeetCode/Source:** _Problem not directly on LeetCode — common pattern-based question._

### 🧪 Example

```text
Input:  "ABCGAG"
Output: 3
Explanation:
- A at index 0 forms AG with G at index 3 and index 5 → 2 pairs
- A at index 4 forms AG with G at index 5 → 1 pair
Total: 3 pairs
---

### 🧠 Logic

### 🐢 Brute Force Approach

**Logic:** For every 'A', count how many 'G's appear after it.

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)

```java
public int solve(String A) {
    int n = A.length();
    int c = 0;
    for (int i = 0; i < n; i++) {
        if (A.charAt(i) == 'A') {
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) == 'G') {
                    c++;
                }
            }
        }
    }
    return c % 1000000007;
}
---


---

### ⚡ Optimized Approach (Right-to-Left Pass)

**Logic:**  
Instead of checking all 'G's after every 'A', traverse the string **from right to left**:
- Keep a running count of how many `'G'`s you've seen so far (`c`).
- Every time you see an `'A'`, it can form a pair with all `'G'`s that came after it — so add `c` to the answer.
- Take modulo `10^9 + 7` after each addition to prevent overflow.

---

### 💻 Code (Java)

```java
public int solve(String A) {
    int n = A.length();
    int c = 0;
    int ans = 0;
    for (int i = n - 1; i >= 0; i--) {
        if (A.charAt(i) == 'G') {
            c++;
        }
        if (A.charAt(i) == 'A') {
            ans = (ans + c) % 1000000007;
        }
    }
    return ans;
}




