# 📈 Best Time to Buy and Sell Stock

**Problem:**  
You're given an array where each element represents the price of a stock on a given day.  
You can only buy **once** and sell **once** — return the maximum profit you can achieve.  
If no profit is possible, return `0`.

**Platform:** LeetCode  
[🔗 Problem Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

**Example**
A = [1, 4, 5, 2, 4]
Ouput = 4 => Buy the stock on day 0, and sell it on day 2.
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
```

## ✅ Optimal Approach – O(n) time | O(1) space
// Track the lowest price seen so far(which basically will be the first ele at first),
    start the iteration from i=1 and calculate profit if sold today.
// Keep updating the maximum profit at every iteration.

```java
public int maxProfit(final int[] A) {
    if (A == null || A.length == 0) {    //for edge case if array is empty
        return 0;
    }

    int n = A.length;
    int maxProfit = 0;
    int currmin = A[0];     //current minimum val is first ele

    for (int i = 1; i < n; i++) {
        int profit = A[i] - currmin;   //calculating profit
        maxProfit = Math.max(profit, maxProfit);  //calculating maxprofit 

        if (A[i] < currmin) {        //to get the new min value if current i value is < currmin val
            currmin = A[i];
        }
    }

    return maxProfit;
}
```
