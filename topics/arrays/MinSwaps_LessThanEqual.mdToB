## 🔄 Minimum Swaps to Bring Elements ≤ B Together

> Given an array of integers `A` and an integer `B`,  
> find the **minimum number of swaps** required to bring all the elements **less than or equal to `B`** together in the array.

🔗 **LeetCode Equivalent (Similar):**  
[1151. Minimum Swaps to Group All 1's Together](https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/)  
*Note: In LeetCode, it’s grouping 1s. Here, we’re grouping elements ≤ B — logic is nearly identical.*

---

### 📘 Example

#### Input:
```java
A = [1, 3, 5, 2, 6, 4, 1]
B = 3
### Output:
1

✅ Brute-force + Sliding Window Window Setup - 

```JAVA
  public int solve(int[] A, int B) {
    int ans = Integer.MAX_VALUE;
    int n = A.length;

    // Step 1: Count number of elements ≤ B
    int k = 0;
    for (int i = 0; i < n; i++) {
        if (A[i] <= B) {
            k++;
        }
    }

    // Step 2: Check every window of size k
    int s = 0, e = k - 1;
    while (e < n) {
        int swaps = 0;
        for (int i = s; i <= e; i++) {
            if (A[i] > B) {
                swaps++;
            }
        }
        ans = Math.min(ans, swaps);
        s++;
        e++;
    }

    return ans;
}
-_---_---__---___-------------------____________________------------------------__________________-_----------_______--------

✅ Optimised Sliding Window Code: O(N), O(1)
  ```JAVA
    int ans = Integer.MAX_VALUE;
int n = A.length;
int k = 0;

// Step 1: Find window size = number of elements ≤ B
for (int i = 0; i < n; i++) {
    if (A[i] <= B) k++;
}

// Step 2: Count bad elements in the first window
int c = 0;
for (int i = 0; i < k; i++) {
    if (A[i] > B) c++;
}
ans = c;

// Step 3: Slide the window
int s = 1, e = k;
while (e < n) {
    if (A[s - 1] > B) c--;  // Remove outgoing
    if (A[e] > B) c++;      // Add incoming
    ans = Math.min(ans, c);
    s++;
    e++;
}

return ans;

_______________________________________________________________________________________________________
🧠 Key Observations
- This is based on the idea of bringing all valid (≤ B) elements into a subarray together.
- The minimum number of unwanted (> B) elements in any window of size k determines the answer.
- You don’t actually swap in-place — just count the number of needed swaps.
