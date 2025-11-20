*Brute*:
static List<Integer> firstNegInt(int arr[], int k) {
    int n = arr.length;
    ArrayList<Integer> result = new ArrayList<>();
    
    // Har window ko check karo
    for(int i = 0; i <= n-k; i++) {
        boolean found = false;  // Flag to track if negative found
        
        // Current window mein first negative dhundo
        for(int j = i; j < i+k; j++) {
            if(arr[j] < 0) {
                result.add(arr[j]);
                found = true;
                break;  // First negative mil gaya, aage check mat karo
            }
        }
        
        // Agar poore window mein koi negative nahi mila
        if(!found) {
            result.add(0);
        }
    }
    
    return result;
}

  *Optimised - Sliding window/queue*
  int n = arr.length;
    ArrayList<Integer> result = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();  // Store negative numbers
    
    // Step 1: Process first window (i=0 to k-1)
    for(int i = 0; i < k; i++) {
        if(arr[i] < 0) {
            queue.add(arr[i]);
        }
    }
    
    // First window ka result
    if(!queue.isEmpty()) {
        result.add(queue.peek());  // Queue ka front = first negative
    } else {
        result.add(0);
    }
    
    // Step 2: Slide window from index k to n-1
    for(int i = k; i < n; i++) {
        // Remove element going out of window
        // Left element = arr[i-k]
        if(!queue.isEmpty() && queue.peek() == arr[i-k]) {
            queue.poll();  // Remove from queue
        }
        
        // Add new element coming into window
        if(arr[i] < 0) {
            queue.add(arr[i]);
        }
        
        // Current window ka result
        if(!queue.isEmpty()) {
            result.add(queue.peek());
        } else {
            result.add(0);
        }
    }
    
    return result;
