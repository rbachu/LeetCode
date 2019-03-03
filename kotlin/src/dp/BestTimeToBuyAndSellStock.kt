/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Matthew Lee
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Say you have an array for which the i'th element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.
 *              Not 7 - 1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

package dp

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        val f = IntArray(prices.size)
        var max = 0

        for (i in 0 until prices.size) {
            if (i == 0) {
                f[i] = -prices[i]
                max = -prices[i]
            } else {
                f[i] = Math.max(f[i - 1], -prices[i])
                max = Math.max(max, f[i - 1] + prices[i])
            }
        }

        return Math.max(max, 0)
    }
}
