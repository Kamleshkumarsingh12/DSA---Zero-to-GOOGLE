## 📦 Max Subarray Sum Not Exceeding B

> You're given an integer array `C` of size `A`.  
> Your task is to find a contiguous subarray such that the **sum of its elements is maximum**, but **does not exceed** a given number `B`.

🔗 Platform: Common Interview/Contest Question  
🧠 Tags: Arrays, Brute Force, Subarrays, Two Pointers (Optimizable)

---

### 🐢 Brute Force – O(n²) Time

Try every possible subarray starting from each index `i` and compute the sum.

```java
public class Solution {
    public int maxSubarray(int A, int B, int[] C) {
        int ans = 0;

        for (int i = 0; i < A; i++) {
            int sum = 0;

            for (int j = i; j < A; j++) {
                sum += C[j];

                if (sum <= B) {
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }
}
```

🧠 Intuition:
-For every starting index i, you explore all subarrays ending at j ≥ i.
-Track the sum and only update answer if it is ≤ B.
-This is brute force — can be optimized using sliding window (only if all numbers are non-negative).

______________------------------------___________________________---------------------___________________________--------------------____________

✅ OPTIMISED using Sliding window [O(N)]:
- Using two pointers
- i = 0; j=0;
- when sum<=B, will keep addign the elements on the right, i.e. j++
- when sum>B, will decrement the current ith ele from the sum and will move the ith pointer to the right by 1, i.e. i++
- Keep updating the max Sum

Code (Sliding Window - Clean and Beginner Friendly):
~~JAVA~~
public int maxSubarray(int A, int B, int[] C) {
    int start = 0, end = 0;
    int sum = 0;
    int maxSum = 0; // 0 is safest default if no subarray is valid
    while (end < A) {
        sum += C[end]; // include current element
        // Jab tak sum > B hai, start pointer aage badhao
        while (sum > B && start <= end) {
            sum -= C[start];
            start++;
        }
        // Valid subarray with sum <= B
        maxSum = Math.max(maxSum, sum);
        end++; // move window ahead
    }
    return maxSum;
}

__________________________________________________________________________________________________________

