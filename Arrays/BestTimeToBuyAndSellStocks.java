/*
You’re given an array prices[] where prices[i] is the price of a stock on day i.
You want to choose a single day to buy and a different day in the future to sell.
Return the maximum profit you can achieve. If no profit is possible, return 0.
*/

class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int prices[]) {
        // TC: O(n), SC: O(1)
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}