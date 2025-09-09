# Minimum Swaps to Bring Elements Less Than B Together

## 📌 Problem Statement
You are given an array and a number **B**.  
The task is to find the **minimum number of swaps required** to bring all elements less than **B** together (i.e., in a contiguous subarray).

---

## 🔹 Example
Input:  
arr = [1, 3, 5, 2, 8, 6, 4], B = 5

Elements `< 5` = `[1, 3, 2, 4]` → count = **4**  
We need to find a window of size `k = 4` where these elements can fit with minimum swaps.

Output:  
Minimum swaps = 1


---

## 🔹 Approach (Sliding Window)

1. **Count k:**  
   Count how many elements are `< B`. This will be the size of the sliding window.

2. **Initial Window:**  
   In the first window of size `k`, count how many "bad" elements are present (bad = elements `>= B`).  
   These are the ones we would need to swap.

3. **Slide the Window:**  
   Move the window one step at a time:
   - Remove the effect of the element going out of the window.
   - Add the effect of the new element coming into the window.
   - Track the minimum number of bad elements across all windows.

4. **Result:**  
   The minimum number of bad elements encountered is the **minimum swaps required**.

---

## 🔹 Complexity
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

## 🔹 Java Implementation
```java
public class MinSwapsTogether {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 8, 6, 4};
        int B = 5;

        int n = arr.length;

        // Step 1: Count elements < B
        int k = 0;
        for (int num : arr) {
            if (num < B) k++;
        }

        // Edge case: if no elements < B
        if (k == 0) {
            System.out.println("Minimum swaps = 0");
            return;
        }

        // Step 2: Count bad elements in first window
        int bad = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] >= B) bad++;
        }

        int minSwaps = bad;

        // Step 3: Slide the window using only one loop
        for (int end = k; end < n; end++) {
            int start = end - k; // left boundary of the window

            // Remove the element going out
            if (arr[start] >= B) bad--;

            // Add the new element coming in
            if (arr[end] >= B) bad++;

            // Track minimum bad elements
            minSwaps = Math.min(minSwaps, bad);
        }

        System.out.println("Minimum swaps = " + minSwaps);
    }
}


🔹 Dry Run
Array = [1, 3, 5, 2, 8, 6, 4], B = 5

Elements < 5 = 4 → k = 4

Window [1,3,5,2]: bad=1

Window [3,5,2,8]: bad=2

Window [5,2,8,6]: bad=3

Window [2,8,6,4]: bad=2

✅ Minimum = 1 → Answer = 1 swap


