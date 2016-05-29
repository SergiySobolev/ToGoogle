package com.sbk.leetcode.dynamic;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int base = n;
        while (base != 1) {
            if (base % 2 != 0) {
                return false;
            }
            base /= 2;
        }
        return true;
    }

    public String convertToTitle(int n) {
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int alphabetLength = alphabet.length;
        StringBuilder result = new StringBuilder();
        int mod;
        int div = n;
        while (div != 0) {
            div = div - 1;
            mod = div % alphabetLength;
            div /= alphabetLength;
            result.append(alphabet[mod]);
        }
        return result.reverse().toString();
    }

    public int titleToNumber(String s) {
        List<Character> alphabet = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        int alphabetLength = alphabet.size();
        int res = 0;
        for(int i=0;i<s.length();i++) {
            final char iLetter = s.charAt(s.length() - i - 1);
            int ordinalNum = alphabet.indexOf(iLetter);
            res += (ordinalNum+1)*Math.pow(alphabetLength, i);
        }
        return res;
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=1; j<=Math.sqrt(i); j++)
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
        }
        return dp[n];
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] res = new int[amount+1];
        res[0] = 0;
        for(int i=1; i<=amount ; i++) {
            res[i] = Integer.MAX_VALUE;
            for(int j=0; j<coins.length && coins[j] <= i ; j++) {
                final int re = res[i - coins[j]];
                if(re == -1){
                    continue;
                }
                final int jCoin = re + 1;
                res[i] = Math.min(res[i], jCoin);
            }
            if(res[i] == Integer.MAX_VALUE){
                res[i] = -1;
            }
        }
        return res[amount];
    }

}
