package com.hyeonah.javalabs.algorithm.top50coding.dynamicprogramming;

import java.util.Arrays;

/**
 * description)
 *
 * input coins: 1,2,5 / amount = 11
 * output: 3 (11 = 5 + 5 + 1)
 */
public class CoinChange {
    public static void main(final String[] args) {
        final int[] coins = {1, 2, 5};
        final int amount = 11;
        System.out.println(changeCoins(coins, amount));
    }

    private static int changeCoins(final int[] coins, final int amount) {
        final int max = amount + 1;

        final int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++){
                if(i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
