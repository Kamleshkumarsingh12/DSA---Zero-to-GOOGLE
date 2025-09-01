## 🧩 Count Subarrays Including a Specific Index

> Given an array of length `n` and an index `i`, return how many subarrays contain the element at index `i`.

### 🧠 Logic:
- A subarray must **start at or before** `i`, and **end at or after** `i`.
- So:
  - Start choices = `(i + 1)` → from index `0` to `i`
  - End choices = `(n - i)` → from `i` to `n - 1`
- Total subarrays including index `i` = `(i + 1) * (n - i)`

---

### 🐢 Brute Force – O(n²)

> Generate all subarrays and count the ones that include index `i` (for understanding only, not efficient).

```java
public int bruteCountIncludingIndex(int[] A, int index) {
    int n = A.length;
    int count = 0;
    for (int start = 0; start < n; start++) {
        for (int end = start; end < n; end++) {
            if (index >= start && index <= end) {
                count++;
            }
        }
    }
    return count;
}
---------------------------------------------------------------------------------------------------------------

 ### ⚡ Optimized – O(1) Time | O(1) Space
  public int countSubarraysIncludingIndex(int n, int i) {
    if (i < 0 || i >= n) {
        throw new IllegalArgumentException("Index out of bounds");
    }
    return (i + 1) * (n - i);
}

-> 🔁 Print Subarray Count for All Indices
      public void printSubarrayCountForAllIndices(int[] A) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
        int count = (i + 1) * (n - i);
        System.out.println("Index " + i + " (Value " + A[i] + ") is in " + count + " subarrays.");
    }
}

---------_____________________---------------------__________________________---------------------________

✅ Summary:
Use brute-force only to verify.
Use formula (i + 1) * (n - i) in real code.
Total number of subarrays in an array of length n = n * (n + 1) / 2


