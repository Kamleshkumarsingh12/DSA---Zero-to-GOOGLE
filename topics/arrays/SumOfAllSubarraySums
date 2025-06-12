## ➕ Sum of All Subarray Sums

> Given an integer array `A` of length `N`, compute the **sum of all subarray sums**.
>
> A subarray is a contiguous portion of the array.
>
> 🚨 Be careful about **integer overflow**; use appropriate data types like `long`.

🔗 Platform: Common DSA / Interview Question  
🧠 Tags: Arrays, Subarrays, Contribution Technique

---

### 🐢 Brute Force – O(n³)

- Generate every possible subarray
- For each subarray, compute the sum by iterating over its elements

```java
public long subarraySum(int[] A) {
    int n = A.length;
    long sum = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            for (int k = i; k <= j; k++) {
                sum += A[k];
            }
        }
    }

    return sum;
}


---------------------------------------------------------------------------------------------------------------

⚡ Optimized – Contribution Technique (O(n))
Each element contributes to several subarrays.
Element A[i] appears in exactly (i + 1) * (n - i) subarrays.
So total contribution of A[i] = A[i] * (i + 1) * (n - i)

```java
public long subarraySum(int[] A) {
    int n = A.length;
    long sum = 0;

    for (int i = 0; i < n; i++) {
        long total = (long)(i + 1) * (n - i);
        sum += total * (long) A[i];
    }

    return sum;
}
