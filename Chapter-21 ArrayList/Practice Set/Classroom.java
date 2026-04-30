// Q1
import java.util.ArrayList;
public class Solution {
    public static boolean isMonotonic(ArrayList<Integer> nums) {
        boolean increasing = true, decreasing = true;
        
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) increasing = false;
            if (nums.get(i) < nums.get(i + 1)) decreasing = false;
        }
        
        return increasing || decreasing;
    }
}


//Q2
import java.util.*;

public class Solution {
    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        // Count frequencies
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        
        // Check lonely condition
        for (int num : freq.keySet()) {
            if (freq.get(num) == 1 
                && !freq.containsKey(num - 1) 
                && !freq.containsKey(num + 1)) {
                result.add(num);
            }
        }
        
        return result;
    }
}


//Q3
import java.util.*;

public class Solution {
    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                int target = nums.get(i + 1);
                count.put(target, count.getOrDefault(target, 0) + 1);
            }
        }
        
        int maxCount = 0, result = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        
        return result;
    }
}


//Q4
import java.util.*;

public class Solution {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        
        while (result.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            // Add all odd-positioned elements first (2*x - 1)
            for (int x : result)
                if (2 * x - 1 <= n) temp.add(2 * x - 1);
            // Then even-positioned elements (2*x)
            for (int x : result)
                if (2 * x <= n) temp.add(2 * x);
            result = temp;
        }
        
        return result;
    }
}
//Practice Set
