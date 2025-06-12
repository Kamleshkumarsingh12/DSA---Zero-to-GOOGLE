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
