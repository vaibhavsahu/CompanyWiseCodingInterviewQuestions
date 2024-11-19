package easy;
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int [] seen = new int[60];
        int count = 0;
        for(var t : time){
            count += seen[(60-(t%60))%60];
            seen[t%60]++;
        }
        return count;
    }

    public int numPairsDivisibleBy60BruteForce(int[] time) {
        int count = 0;

        for (int i = 0; i < time.length; i++) {
            for (int j = i+1; j < time.length; j++) {
                if((time[i] + time[j]) % 60 == 0) count++;
            }
        }
        return count;
    }
}
