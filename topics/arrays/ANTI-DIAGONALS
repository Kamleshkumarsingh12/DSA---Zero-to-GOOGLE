## 🔀 Anti-Diagonals of a Square Matrix

> Given an `N x N` square matrix `A`, return a 2D array containing all its **anti-diagonals**.
>
> 📘 An **anti-diagonal** is a group of elements `A[i][j]` where `i + j` is the same.

🔗 Similar: InterviewBit – [Anti Diagonals](https://www.interviewbit.com/problems/anti-diagonals/)

---

### 🔍 Example

#### Input:
```java
A = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]



✅ Code (Java – Simple and Clean):
  public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(int[][] A) {
        int n = A.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Total number of anti-diagonals = 2n - 1
        for (int i = 0; i < 2 * n - 1; i++) {
            result.add(new ArrayList<>());
        }

        // Traverse the matrix and group elements by (i + j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = i + j;
                result.get(sum).add(A[i][j]);
            }
        }

        return result;
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🧠 Approach Summary:
There are 2N - 1 anti-diagonals in an N x N matrix.

For each element A[i][j], calculate sum = i + j — this gives the anti-diagonal index.

Use an ArrayList of ArrayLists to collect all such elements.
