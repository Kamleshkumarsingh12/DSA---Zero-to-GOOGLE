## 🧲 Max Sum by Removing B Elements

> You're given an array `A` of size `N`, and you can remove **B elements** either from the **start** or **end** of the array.  
> Your goal is to maximize the **sum of the removed elements**.  
>
> For example, if B = 3, you can:
> - Take 3 from the front
> - Take 2 from the front and 1 from the back
> - Take 1 from the front and 2 from the back
> - Take 3 from the back

🔗 Platform: InterviewBit / LeetCode-style  
🧠 Tags: Sliding Window, Arrays

---

### 🐢 Brute Force – O(B²)

Try all combinations: take `i` elements from the front and `B - i` from the back.

```java
public int solve(int[] A, int B) {
    int n = A.length;
    int maxSum = Integer.MIN_VALUE;

    // Try taking i elements from front and (B - i) from back
    for (int i = 0; i <= B; i++) {
        int sum = 0;
        // Take i elements from front
        for (int j = 0; j < i; j++) {
            sum += A[j];
        }
        // Take (B - i) elements from back
        for (int j = 0; j < B - i; j++) {
            sum += A[n - 1 - j];
        }
        maxSum = Math.max(maxSum, sum);
    }

    return maxSum;
}

-------------------------------------------------------------------------------------------------------------------------------------------  


### ⚡ Optimized – Sliding Window (O(B))
Start by taking the first B elements, then slide the window by gradually replacing elements from the front with elements from the back.

🧠 Intuition:
At each step, you're replacing one element from the front with one from the back.
Track the sum dynamically and keep the maximum.


```java
public int solve(int[] A, int B) {
    int n = A.length;

    // Step 1: Initial sum of first B elements (taking all from front)
    int sum = 0;
    for (int i = 0; i < B; i++) {
        sum += A[i];
    }

    int maxSum = sum;

    // Step 2: Slide the window - remove from front, add from back
    for (int i = 0; i < B; i++) {
        sum = sum - A[B - i - 1];         // remove one from front
        sum = sum + A[n - i - 1];         // add one from back
        maxSum = Math.max(maxSum, sum);
    }

    return maxSum;
}
