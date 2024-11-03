package easy;

import java.util.HashMap;

//https://leetcode.com/problems/degree-of-an-array/
public class DegreeOfArray {

    public static int degreeBruteForce(int[] arr) {
        int maxDegree = 0;
        int minLength = Integer.MAX_VALUE;

        //1, 4, 2, 3, 2
        for (int i = 0; i < arr.length; i++) {
            var map = new HashMap<Integer, Integer>();
            for (int j = i; j < arr.length; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                if(map.containsKey(arr[j]) && map.get(arr[j]) >= maxDegree) {
                    maxDegree = map.get(arr[j]);
                }
            }
            for(var key : map.keySet()) {
                if(map.get(key) == maxDegree) {
                    minLength = Math.min(minLength, arr.length - i);
                }
            }
        }
        return minLength;
    }

    public static int degreeOptimized(int[] arr) {
        var maxDegree = 0;
        var minLength = Integer.MAX_VALUE;
        var map = new HashMap<Integer, Integer>();
        var left = new HashMap<Integer, Integer>();
        var right = new HashMap<Integer, Integer>();
        //1, 4, 2, 3, 2
        for (var i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(!left.containsKey(arr[i])){
                left.put(arr[i], i);
            } else {
                right.put(arr[i], i);
            }
            if(map.get(arr[i]) >= maxDegree) {
                maxDegree = map.get(arr[i]);
            }
        }
        for(var key : map.keySet()) {
            if(map.get(key) == maxDegree) {
                minLength = Math.min(minLength, right.get(key)-left.get(key)+1);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(degreeOptimized(new int[]{1, 4, 2, 3, 2}));
    }
}
