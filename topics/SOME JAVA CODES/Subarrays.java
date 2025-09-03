public class Subarrays {
    public static void main(String[] args) {
        int[] ans = {2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1};
        int answer = ShortestDist(ans);
        System.out.println(answer); // Expected: 2
    }

    public static int ShortestDist(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // find max and min
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        if (max == min) return 1; // all elements same

        int minlen = Integer.MAX_VALUE;

        // Case 1: subarrays starting with min
        for (int i = 0; i < n; i++) {
            if (A[i] == min) {
                for (int j = i + 1; j < n; j++) {
                    if (A[j] == max) {
                        int len = j - i + 1;
                        minlen = Math.min(minlen, len);
                        break; // take nearest max only
                    }
                }
            }
        }

        // Case 2: subarrays starting with max
        for (int i = 0; i < n; i++) {
            if (A[i] == max) {
                for (int j = i + 1; j < n; j++) {
                    if (A[j] == min) {
                        int len = j - i + 1;
                        minlen = Math.min(minlen, len);
                        break; // take nearest min only
                    }
                }
            }
        }

        return minlen;
    }
}
