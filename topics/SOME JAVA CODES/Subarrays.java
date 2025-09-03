public class Subarrays {
    public static void main(String[] args) {
        int[] ans = { 2,2,6,4,5,1,5,2,6,4,1};
        int answer =  ShortestDist(ans);
        System.out.println(answer);
    }
    public static int ShortestDist(int[] A)
    {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxlen = 0;
        for(int i=0;i<n;i++)
        {
            if(A[i]>max)
            {
                max = A[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(A[i]<min)
            {
                min = A[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(A[i] == min)
            {
                int len = 0;
                for(int j=i+1;j<n;i++)
                {
                    if(A[j] == max){
                        len = j-i+1;
                    }
                }
                maxlen = Math.max(len,maxlen);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(A[i] == max)
            {
                int len = 0;
                for(int j=i+1;j<n;i++)
                {
                    if(A[j] == min){
                        len = j-i+1;
                    }
                }
                maxlen = Math.max(len,maxlen);
            }
        }
        return maxlen;
    }
}