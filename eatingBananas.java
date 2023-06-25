//https://leetcode.com/problems/koko-eating-bananas/description/
public class eatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        int lo = 1, hi = 1;
        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            int hourSpent = 0;
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / mid);
            }
            if (hourSpent <= h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
