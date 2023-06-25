//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class MaximizeProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }

    public  static int maxProfit(int[] prices) {
        int start=0;
        int currProfit=0;
        int maxProfit=0;

        for (int end = 0; end < prices.length; end++) {
            currProfit = prices[end] - prices[start];
            if (currProfit >= maxProfit) {
                maxProfit = currProfit;
            }
            if (currProfit < 0) {
                start = end;
            }
        }

        return maxProfit;


    }
}
