Prefix sum Why it matters: You precompute cumulative totals so any range
query becomes constant-time. It generalizes to counts, parity, 2D grids,
and even range updates (via difference arrays).

Core idea and when to use - Concept: Build an array P where
P\[i\]=A\[0\]+...+A\[i\]. Then any range sum \[l,r\] is
P\[r\]-P\[l-1\]. - Use when: You have many range queries, need quick
"how many up to here?" counts, or want to transform range updates to
point updates (difference array).

Patterns - 1D range sum: - Precompute once in O(n), answer each query in
O(1). - Counts as prefix sums: - Convert a condition into 0/1 and
prefix-sum it to get counts in ranges. - Prefix with HashMap (subarray
sum = k): - Track counts of previous prefix sums; at index i, add how
many times P\[i\]-k appeared. - 2D prefix: - For matrices: PS\[r\]\[c\]
= PS\[r-1\]\[c\]+PS\[r\]\[c-1\]-PS\[r-1\]\[c-1\]+A\[r\]\[c\]. -
Difference array (range updates): - To add v on \[l,r\], do D\[l\]+=v;
if r+1\<n then D\[r+1\]-=v. Final array is prefix of D.

Java examples

``` java
// 1D prefix sum + range query
long[] buildPrefix(int[] a) {
    long[] pref = new long[a.length];
    long s = 0;
    for (int i = 0; i < a.length; i++) {
        s += a[i];
        pref[i] = s;
    }
    return pref;
}
long rangeSum(long[] pref, int l, int r) {
    if (l == 0) return pref[r];
    return pref[r] - pref[l - 1];
}

// Subarray sum equals k (works with negatives)
int subarraySumEqualsK(int[] a, int k) {
    java.util.Map<Long, Integer> freq = new java.util.HashMap<>();
    freq.put(0L, 1); // empty prefix
    long pref = 0;
    int ans = 0;
    for (int x : a) {
        pref += x;
        ans += freq.getOrDefault(pref - k, 0);
        freq.put(pref, freq.getOrDefault(pref, 0) + 1);
    }
    return ans;
}

// 2D prefix sum + rectangle query
long[][] build2DPrefix(int[][] g) {
    int n = g.length, m = g[0].length;
    long[][] ps = new long[n + 1][m + 1]; // 1-based padding
    for (int i = 1; i <= n; i++) {
        long row = 0;
        for (int j = 1; j <= m; j++) {
            row += g[i - 1][j - 1];
            ps[i][j] = ps[i - 1][j] + row;
        }
    }
    return ps;
}
long rectSum(long[][] ps, int r1, int c1, int r2, int c2) {
    // r1..r2, c1..c2 are 0-based inclusive
    r1++; c1++; r2++; c2++;
    return ps[r2][c2] - ps[r1 - 1][c2] - ps[r2][c1 - 1] + ps[r1 - 1][c1 - 1];
}

// Difference array for range add updates
int[] applyRangeAdds(int n, int[][] updates) {
    // updates: {l, r, val}, 0-based inclusive
    long[] diff = new long[n + 1];
    for (int[] u : updates) {
        int l = u[0], r = u[1], v = u[2];
        diff[l] += v;
        if (r + 1 < diff.length) diff[r + 1] -= v;
    }
    int[] a = new int[n];
    long run = 0;
    for (int i = 0; i < n; i++) {
        run += diff[i];
        a[i] = (int) run; // beware overflow; keep long if needed
    }
    return a;
}
```

Pitfalls and tips - Overflow: Use long for sums. - Indices: For 1D,
handle l = 0 separately; for 2D, 1-based padding simplifies
boundaries. - HashMap approach: Works with negatives; two-pointers do
not. - Memory: 2D prefix adds one extra row/col to simplify math.

------------------------------------------------------------------------

Carry forward Why it matters: You maintain running information as you
scan, so each step uses what you've already computed. It's the backbone
of Kadane's, running min/max, last-seen indices, and "state DP" on
arrays.

Core idea and when to use - Concept: Keep a small "state" that
summarizes everything needed up to index i, then update it for i+1. -
Use when: Best-so-far or count-so-far problems, last occurrence
tracking, streaming constraints, or when recomputation is costly.

Patterns - Kadane's (max subarray sum): - Carry the best ending at i:
bestEnd = max(A\[i\], bestEnd + A\[i\]). - Running extrema: - Track
maxSoFar, minSoFar, and update in O(1) per step. - Last seen index /
frequency: - For constraints like "no repeats in window," carry an
array/map of last positions. - State compression DP: - Many 1D DPs
reduce to a few carried variables.

Java examples

``` java
// Kadane's algorithm (handles all negative arrays)
long maxSubarraySum(int[] a) {
    long bestEnd = a[0];
    long best = a[0];
    for (int i = 1; i < a.length; i++) {
        bestEnd = Math.max(a[i], bestEnd + a[i]);
        best = Math.max(best, bestEnd);
    }
    return best;
}

// Longest subarray with distinct elements using last seen carry-forward
int longestDistinct(int[] a) {
    java.util.Map<Integer, Integer> last = new java.util.HashMap<>();
    int start = 0, ans = 0;
    for (int i = 0; i < a.length; i++) {
        if (last.containsKey(a[i]) && last.get(a[i]) >= start) {
            start = last.get(a[i]) + 1;
        }
        last.put(a[i], i);
        ans = Math.max(ans, i - start + 1);
    }
    return ans;
}

// Running min/max prefix and suffix (useful building blocks)
int[] prefixMax(int[] a) {
    int n = a.length;
    int[] pm = new int[n];
    int mx = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        mx = Math.max(mx, a[i]);
        pm[i] = mx;
    }
    return pm;
}
int[] suffixMin(int[] a) {
    int n = a.length;
    int[] sm = new int[n];
    int mn = Integer.MAX_VALUE;
    for (int i = n - 1; i >= 0; i--) {
        mn = Math.min(mn, a[i]);
        sm[i] = mn;
    }
    return sm;
}
```

Pitfalls and tips - Initialization: Kadane must start from a\[0\] to
handle all negatives. - Resets: Only reset the state when it improves
the objective. - Maps: For last-seen tracking, update start pointer
correctly to avoid shrinking backwards.

------------------------------------------------------------------------

Sliding window Why it matters: You maintain a contiguous window and move
its ends to satisfy constraints. It's perfect for fixed-length
aggregates and variable-length constraints on non-negative arrays or
with frequency maps.

Core idea and when to use - Concept: Two pointers define a window.
Expand right; shrink left when constraints break. - Use when:
Fixed-length k, or variable-length with monotone constraints (sum ≤ S
with non-negatives, at most K distinct, frequency bounds).

Patterns - Fixed length k: max/avg/sum

``` java
long maxSumFixedK(int[] a, int k) {
    long s = 0, best = Long.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
        s += a[i];
        if (i >= k) s -= a[i - k];
        if (i >= k - 1) best = Math.max(best, s);
    }
    return best;
}
```

-   Variable length with non-negative numbers (sum ≤ S / shortest ≥ S)

``` java
int longestWithSumAtMostSNonNeg(int[] a, long S) {
    int n = a.length, l = 0, ans = 0;
    long sum = 0;
    for (int r = 0; r < n; r++) {
        sum += a[r];
        while (sum > S && l <= r) sum -= a[l++];
        ans = Math.max(ans, r - l + 1);
    }
    return ans;
}

int minLenWithSumAtLeastSNonNeg(int[] a, long S) {
    int n = a.length, l = 0, ans = Integer.MAX_VALUE;
    long sum = 0;
    for (int r = 0; r < n; r++) {
        sum += a[r];
        while (sum >= S) {
            ans = Math.min(ans, r - l + 1);
            sum -= a[l++];
        }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
}
```

-   At most K distinct (or frequency-bounded)

``` java
int longestSubarrayAtMostKDistinct(int[] a, int K) {
    java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();
    int l = 0, ans = 0, distinct = 0;
    for (int r = 0; r < a.length; r++) {
        freq.put(a[r], freq.getOrDefault(a[r], 0) + 1);
        if (freq.get(a[r]) == 1) distinct++;
        while (distinct > K) {
            freq.put(a[l], freq.get(a[l]) - 1);
            if (freq.get(a[l]) == 0) distinct--;
            l++;
        }
        ans = Math.max(ans, r - l + 1);
    }
    return ans;
}
```

Pitfalls and tips - Negatives present: Classic sum-based two-pointers
break; use prefix-sum + HashMap or other strategies. - Shrink carefully:
While-loops must truly restore constraints. - Frequency maps: Remove
keys when count hits zero to keep "distinct" accurate.

------------------------------------------------------------------------

Contribution technique Why it matters: Instead of summing over
subarrays, sum each element's contribution across all subarrays/pairs
directly. This converts nested loops into linear scans, often with
monotonic stacks.

Core idea and when to use - Concept: Count how many times an element
participates in the target structure, multiply by its value, and sum. -
Use when: "Sum over all subarrays" for sums, mins, maxes; also bitwise
contributions; products with careful transforms.

Patterns - Sum of all subarray sums in O(n):

``` java
long sumOfAllSubarraySums(int[] a) {
    long n = a.length, ans = 0;
    for (int i = 0; i < n; i++) {
        long left = i + 1, right = n - i;
        ans += (long) a[i] * left * right;
    }
    return ans;
}
```

-   Sum of subarray minimums (monotonic stack):

``` java
long sumOfSubarrayMinimums(int[] a) {
    int n = a.length;
    int[] ple = new int[n]; // previous less element (strictly)
    int[] nle = new int[n]; // next less or equal
    java.util.Deque<Integer> st = new java.util.ArrayDeque<>();

    // PLE
    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && a[st.peek()] > a[i]) st.pop();
        ple[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);
    }
    st.clear();
    // NLE
    for (int i = n - 1; i >= 0; i--) {
        while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
        nle[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
    }

    long ans = 0;
    for (int i = 0; i < n; i++) {
        long L = i - ple[i];
        long R = nle[i] - i;
        ans += (long) a[i] * L * R;
    }
    return ans;
}
```

-   Sum of subarray maximums (monotonic stack):

``` java
long sumOfSubarrayMaximums(int[] a) {
    int n = a.length;
    int[] pge = new int[n]; // previous greater (strictly)
    int[] nge = new int[n]; // next greater or equal
    java.util.Deque<Integer> st = new java.util.ArrayDeque<>();

    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && a[st.peek()] < a[i]) st.pop();
        pge[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);
    }
    st.clear();
    for (int i = n - 1; i >= 0; i--) {
        while (!st.isEmpty() && a[st.peek()] <= a[i]) st.pop();
        nge[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
    }

    long ans = 0;
    for (int i = 0; i < n; i++) {
        long L = i - pge[i];
        long R = nge[i] - i;
        ans += (long) a[i] * L * R;
    }
    return ans;
}
```

-   Bitwise contributions (quick sketch):
-   For XOR/sum over subarrays, count how often bit b is set in the
    induced structure, multiply by 2\^b. Often needs prefix parity or
    segment counting.

Pitfalls and tips - Tie-breaking in stacks: Use strict vs non-strict
comparisons carefully to avoid double counting. - Bounds: Use -1 and n
sentinels for clean distances. - Overflow: Contributions grow like
O(n\^2); keep totals in long and mod if required.

------------------------------------------------------------------------

Quick checklist - Prefix sum: Build once, answer many; HashMap for
"equals k" with negatives; 2D with 1-based pad; difference array for
range updates. - Carry forward: Keep only what you need; Kadane;
last-seen indices; running extrema. - Sliding window: Fixed k is
trivial; variable-length works cleanly with non-negatives or with
frequency maps; negatives break sum-based windows. - Contribution: Count
appearances via distances; monotonic stacks for mins/maxes; careful
inequality choices.

Java utility snippets you'll reuse

``` java
// Safe add with mod
long addMod(long a, long b, long mod) { long x = a + b; if (x >= mod) x -= mod; return x; }
// Power of two (for bit contributions)
long pow2(int b) { return 1L << b; }
// Clear stack idiom
void clear(java.util.Deque<Integer> st) { st.clear(); }
```
