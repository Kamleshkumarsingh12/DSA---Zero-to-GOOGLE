# 📈 Best Time to Buy and Sell Stock

**Problem:**  
You're given an array where each element represents the price of a stock on a given day.  
You can only buy **once** and sell **once** — return the maximum profit you can achieve.  
If no profit is possible, return `0`.

**Platform:** LeetCode  
[🔗 Problem Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

---

## 🧠 Brute Force Approach

### 🔍 Idea:
Try all pairs of days `(i, j)` such that `j > i` (i.e., buy on day `i`, sell on day `j`), and check:
- If `A[j] > A[i]` → valid transaction
- Calculate `profit = A[j] - A[i]`
- Track the maximum profit among all such pairs

---

### 💻 Code (Java)

```java
public int maxProfit(final int[] A) {

    // BRUTEFORCE
    int n = A.length;
    int maxProfit = 0;

    for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
            if(A[j] > A[i]) {
                int profit = A[j] - A[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
    }

    return maxProfit;
}
