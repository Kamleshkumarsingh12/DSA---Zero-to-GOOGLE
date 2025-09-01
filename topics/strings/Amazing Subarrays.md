TIP: Agar tum string ke kisi index i pe ho,
to us character se start hone waali substrings ki total sankhya hoti hai: ➡️ n - i
🧠 Key Learnings-
*Smart substring counting using n - i
*Vowel check with .indexOf()
*Use of modulo (% 10003) to avoid integer overflow


## 🧠 Amazing Substrings (Optimized Java Approach)

📌** Problem Statement**
Given a string `A`, find the number of **amazing substrings** of `A`.
An **amazing substring** is any substring that **starts with a vowel** (a, e, i, o, u — upper or lowercase).

---

### 🔍 Example

**Input:** `"ABEC"`  
**All substrings:**  
A, AB, ABE, ABEC,
B, BE, BEC,
E, EC,
C


**Amazing substrings (starting with vowels):**  
A, AB, ABE, ABEC, E, EC


**Output:** `6`

---

### ✅ Approach (Optimized — O(n))

Instead of generating all substrings, we use the observation:

> 🧩 If a character at index `i` is a vowel, then all substrings **starting at index `i` to the end** are amazing substrings.

📌 Count of substrings from index `i` = `n - i`  
(Example: from index 2 in a 5-length string → substrings = 3)

---

### 💻 Java Code

```java
public class Solution {
    public int solve(String A) {
        int n = A.length();
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                count = (count + (n - i)) % 10003;  // Handle large numbers
            }
        }

        return count;
    }
}
```
