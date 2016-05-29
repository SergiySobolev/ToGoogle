package com.sbk.leetcode.dynamic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UglyNumbers {

    public int nthSuperUglyNumber1(int n, int[] primes) {
        if (n <= 1) {
            return 1;
        }
        List<Integer> uglyNumbersNotInList = new LinkedList<>();
        List<Integer> uglyNumbersList = new LinkedList<>();
        long[] primeMultipleResults = new long[primes.length];
        addToList(uglyNumbersList, 1);
        int uglyNumCount = 1;
        long base = 1;
        while (uglyNumCount <= n) {
            if(uglyNumCount == 4543){
                System.out.println(uglyNumCount);
            }
            for(int i=0; i<primes.length; i++) {
                primeMultipleResults[i] = base*primes[i];
            }
            if ((uglyNumbersNotInList.size() > 0 && uglyNumbersNotInList.get(0) < primeMultipleResults[0])) {
                Integer firstUglyNotInList = uglyNumbersNotInList.get(0);
                addToList(uglyNumbersList, firstUglyNotInList);
                uglyNumCount++;
                if (uglyNumCount == n) {
                    return firstUglyNotInList;
                }
                base = firstUglyNotInList;
                uglyNumbersNotInList.remove(0);
                for (long primeMultipleResult : primeMultipleResults) {
                    addToList(uglyNumbersNotInList, primeMultipleResult);
                }
                continue;
            }
            base = primeMultipleResults[0];
            addToList(uglyNumbersList, base);
            uglyNumCount++;
            if (n == uglyNumCount) {
                return (int)base;
            }
            for(int i=1; i<primeMultipleResults.length; i++) {
                addToList(uglyNumbersNotInList, primeMultipleResults[i]);
            }
        }
        return (int)base;
    }

    private void addToList(List<Integer> numbers, long n) {
        if (n > Integer.MAX_VALUE) {
            return;
        }
        if (numbers.contains((int) n)) {
            return;
        }
        if (numbers.size() == 0) {
            numbers.add((int) n);
        }
        if(n < numbers.get(0)){
            numbers.add(0, (int)n);
            return;
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (n > numbers.get(i)) {
                if (i == numbers.size() - 1) {
                    numbers.add((int) n);
                } else {
                    numbers.add(i+1, (int) n);
                }
                break;
            }
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res       = new int[n];
        int[] indices   = new int[primes.length];
        res[0]=1;

        for(int i=1;i<n;i++){
            res[i] = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                res[i] = Math.min(res[i],primes[j]*res[indices[j]]);
            }
            for(int j=0;j<primes.length;j++){
                if(res[i]==primes[j]*res[indices[j]])
                    indices[j]++;
            }
        }

        return res[n-1];
    }

    public int nthUglyNumber(int num) {
        if (num <= 1) {
            return 1;
        }
        List<Integer> uglyNumbersNotInList = new LinkedList<>();
        List<Integer> uglyNumbersList = new LinkedList<>();
        addToList(uglyNumbersList, 1);
        int uglyNumCount = 1;
        long base = 1;
        while (uglyNumCount <= num) {

            long multiply2 = base * 2;
            long multiply3 = base * 3;
            long multiply5 = base * 5;

            if ((uglyNumbersNotInList.size() > 0 && uglyNumbersNotInList.get(0) < multiply2)) {
                Integer firstUglyNotInList = uglyNumbersNotInList.get(0);
                addToList(uglyNumbersList, firstUglyNotInList);
                uglyNumCount++;
                if (uglyNumCount == num) {
                    return firstUglyNotInList;
                }
                base = firstUglyNotInList;
                uglyNumbersNotInList.remove(0);
                addToList(uglyNumbersNotInList,  multiply2);
                addToList(uglyNumbersNotInList,  multiply3);
                addToList(uglyNumbersNotInList,  multiply5);
                continue;
            }
            base = multiply2;
            addToList(uglyNumbersList, multiply2);
            uglyNumCount++;
            if (num == uglyNumCount) {
                return (int)multiply2;
            }
            addToList(uglyNumbersNotInList, (int) multiply3);
            addToList(uglyNumbersNotInList, (int) multiply5);
        }
        return (int) base;
    }

    public boolean isUgly2(int num) {
        if (num <= 0) {
            return false;
        }
        if (0 < num && num < 5) {
            return true;
        }
        List<Integer> uglyDividers = Arrays.asList(2, 3, 5);
        boolean canDivide;
        int div = num;
        while (true) {
            canDivide = false;
            for (Integer divider : uglyDividers) {
                if (div % divider == 0) {
                    div /= divider;
                    canDivide = true;
                }
            }
            if (!canDivide) {
                break;
            }
        }
        return div == 1;
    }


}
