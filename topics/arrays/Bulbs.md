## 💡 Light Bulbs – Minimum Switch Presses

> A wire connects N light bulbs. Each bulb has a switch, but due to faulty wiring, pressing a switch toggles that bulb and all bulbs to its right.
>
> Given the initial state of bulbs (0 = off, 1 = on), find the minimum number of switch presses needed to turn **all bulbs ON**.

🔗 Problem Link: [InterviewBit – Bulbs](https://www.interviewbit.com/problems/bulbs/)  
🧠 Tags: Greedy, Arrays

--------------------
->Example:
A = [0, 1, 0, 1]
Output = 4
--------------------

🧠 Intuition:
Each time you encounter a bulb that is OFF, press its switch.
This toggles it and all bulbs to the right.
Repeat until all bulbs are ON.
---

### 🐢 Brute Force – O(n²)

```java
public int bulbs(int[] A) {
    int n = A.length;
    int c = 0;
    for (int i = 0; i < n; i++) {
        if (A[i] == 0)     //if the current value is 0, we have to toggle it to 1 also keep the count as its toggled
    {
            c++;
            for (int j = i; j < n; j++) {
                A[j] = 1 - A[j];     // toggle bulb that are on the right side of the current bulb (if 1 => 1-1 = 0 || if 0 => 1-0 = 1)
            }
        }
    }
    return c;
}

------------------------------------------------------------------------------------------------------------------------------------


⚡ Optimized Greedy – O(n) Time | O(1) Space
🧠 Logic (Optimized):
 - Track how many times you’ve flipped (c). 
 - Use c % 2 to determine the current logical state of the bulb (even flips = actual value, odd flips = inverted).
 - If a bulb is OFF in the current state → flip it.

```java
 public int bulbs(int[] A) {
        int n = A.length;
        int c = 0;
        for(int i=0;i<n;i++)
        {
            int state = A[i];        //to check if we need to flip we store the current switch state
            if(c % 2  == 0){
                state = A[i];        //if even, the value remains same
            }
            else
            {
                state = 1-A[i];        //when odd, the switch flips
            }
            if(state == 0){
                c++;
            }
        }
        return c;
    }
