package com.sbk.longarithmetics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.sbk.longarithmetics.Sign.*;

public class BigNumber {
    private static final Long DEFAULT_BASE = 10L;
    private Long base = 10L;
    private List<Integer> digits = new ArrayList<>();
    public Sign sign = PLUS;

    public BigNumber(int... digits) {
        this(DEFAULT_BASE, digits);
    }

    public BigNumber(char... chars) {
        this(DEFAULT_BASE, getInts(chars));
    }

    private static int[] getInts(char[] chars) {
        int[] digits = new int[chars.length];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return digits;
    }

    public BigNumber(String digits) {
        this(digits.toCharArray());
    }

    public BigNumber(BigNumber toCopy) {
        this.digits = new ArrayList<>(toCopy.getDigits());
        this.sign = toCopy.sign;
    }

    public BigNumber(Long base, int... digits) {
        this.base = base;
        for (int i = digits.length - 1; i >= 0; i--) {
            this.digits.add(digits[i]);
        }
    }

    public BigNumber(List<Integer> digits) {
        this.digits = digits;
        this.base = DEFAULT_BASE;
    }

    public BigNumber appendZeroBefore(int zeroNum) {
        for (int i = 0; i < zeroNum; i++) {
            addHigherDigit(0);
        }
        return this;
    }

    public BigNumber appendZeroAfter() {
        appendZeroAfter(1);
        return this;
    }

    public BigNumber appendZeroAfter(int zeroNum) {
        for (int i = 0; i < zeroNum; i++) {
            addLowerDigit(0);
        }
        return this;
    }

    private int size() {
        return digits.size();
    }

    private Integer get(int i) {
        return digits.get(i);
    }

    public BigNumber addHigherDigit(int digit) {
        digits.add(digit);
        return this;
    }

    public BigNumber addLowerDigit(int digit) {
        digits.add(0, digit);
        return this;
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        if(sign == MINUS){
            res.append("-");
        }
        StringBuilder digitsBuilder = new StringBuilder();
        digits.stream()
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator().forEachRemaining(digitsBuilder::append);
        return res.append(digitsBuilder.toString().replaceFirst("^0*", "")).toString();
    }

    public BigNumber calibrate(BigNumber toCalibrate) {
        BigNumber res = new BigNumber(toCalibrate);
        res.appendZeroBefore(this.size() - toCalibrate.size());
        this.appendZeroBefore(toCalibrate.size() - this.size());
        return res;
    }

    public BigNumber multiply1(int multiplier) {
        List<Integer> carries = new ArrayList<>();
        BigNumber result = new BigNumber();
        carries.add(0);
        digits.stream()
                .forEach(i -> {
                    int res = i * multiplier + carries.get(carries.size() - 1);
                    result.addHigherDigit(res % 10);
                    carries.add(res / 10);
                });
        if (carries.size() > result.size() && carries.get(carries.size() - 1) != 0) {
            result.addHigherDigit(carries.get(carries.size() - 1));
        }
        return result;
    }

    public BigNumber add(BigNumber term) {
        term = calibrate(term);
        List<Integer> termDigits = new ArrayList<>(term.getDigits());
        List<Integer> carries = new ArrayList<>();
        BigNumber result = new BigNumber();
        carries.add(0);
        for (int i = 0; i < digits.size(); i++) {
            Integer termDigit = termDigits.get(i);
            Integer thisDigit = this.digits.get(i);
            int res = thisDigit +
                    termDigit +
                    carries.get(i);
            result.getDigits().add(res % 10);
            carries.add(res / 10);
        }
        if (carries.get(carries.size() - 1) != 0) {
            result.getDigits().add(carries.get(carries.size() - 1));
        }
        return result;
    }

    public int findFirstNonZeroDigitFromPosition(int fromPosition) {
        while (fromPosition < size()) {
            Integer positionValue = get(++fromPosition);
            if (positionValue > 0) {
                return fromPosition;
            }
        }
        return -1;
    }

    public BigNumber subtract(BigNumber inputSubtrahend) {
        BigNumber nMinuend;
        BigNumber nSubtrahend;
        BigNumber result = new BigNumber();
        if(this.compareTo(inputSubtrahend) == -1){
            nMinuend = inputSubtrahend;
            nSubtrahend = this;
            result.sign = MINUS;
        } else {
            nMinuend = this;
            nSubtrahend = inputSubtrahend;
        }
        nSubtrahend = nMinuend.calibrate(nSubtrahend);
        List<Integer> carries = new ArrayList<>();

        carries.add(0);
        for (int i = 0; i < nMinuend.size(); i++) {
            Integer minuend = nMinuend.get(i) - carries.get(i);
            Integer subtrahend = nSubtrahend.get(i);
            if (minuend < subtrahend) {
                carries.add(1);
                minuend += 10;
                result.getDigits().add(minuend - subtrahend);
            } else {
                carries.add(0);
                result.getDigits().add(minuend - subtrahend);
            }
        }
        if (carries.get(carries.size() - 1) != 0) {
            result.getDigits().add(carries.get(carries.size() - 1));
        }
        return result;
    }

    public BigNumber multiply(BigNumber multiplier) {
        BigNumber result = new BigNumber(0);
        for (int i = 0; i < multiplier.size(); i++) {
            BigNumber tempResult = multiply1(multiplier.get(i));
            tempResult.appendZeroAfter(i);
            result = result.add(tempResult);
        }
        return result;
    }

    public BigNumber multiplyRecursive(BigNumber multiplier) {
        return multiplyRecursive(this, multiplier);
    }

    private BigNumber multiplyRecursive(BigNumber multiplier1, BigNumber multiplier2) {
        if (multiplier1.size() == 1) {
            int res = multiplier1.get(0) * multiplier2.get(0);
            return res > 9 ? new BigNumber(res / 10, res % 10) : new BigNumber(res);
        } else {
            BigNumber[] a = multiplier1.divideInHalf();
            BigNumber[] b = multiplier2.divideInHalf();
            BigNumber a0 = a[1];
            BigNumber a1 = a[0];
            BigNumber b0 = b[1];
            BigNumber b1 = b[0];
            int k = a0.size();
            BigNumber res11 = multiplyRecursive(a1, b1);
            BigNumber res10 = multiplyRecursive(a1, b0);
            BigNumber res01 = multiplyRecursive(a0, b1);
            BigNumber res00 = multiplyRecursive(a0, b0);
            BigNumber term1 = res11.appendZeroAfter(2 * k);
            BigNumber term2 = res10.add(res01).appendZeroAfter(k);
            BigNumber term3 = res00;
            return term1
                    .add(term2)
                    .add(res00);
        }
    }

    public BigNumber multiplyKaratsuba(BigNumber multiplier) {
        return multiplyKaratsuba(new BigNumber(this), new BigNumber(multiplier));
    }

    private BigNumber multiplyKaratsuba(BigNumber multiplier1, BigNumber multiplier2) {
        if (multiplier1.size() <= 512) {
            return multiplier1.multiply(multiplier2);
        } else {
            BigNumber[] a = multiplier1.divideInHalf();
            BigNumber[] b = multiplier2.divideInHalf();
            BigNumber a0 = a[1];
            BigNumber a1 = a[0];
            BigNumber b0 = b[1];
            BigNumber b1 = b[0];
            int k = a0.size();
            BigNumber p2 = multiplyKaratsuba(a1, b1);
            BigNumber p0 = multiplyKaratsuba(a0, b0);
//            BigNumber aSum = a0.add(a1);
//            BigNumber bSum = b0.add(b1);
            BigNumber p1 = new BigNumber(); //multiplyKaratsuba(aSum, bSum);
            BigNumber term2 = p1.subtract(p0).subtract(p2).appendZeroAfter(k);
            BigNumber term1 = p2.appendZeroAfter(2*k);
            BigNumber term3 = p0;
            return term1
                    .add(term2)
                    .add(term3);
        }
    }

    public static BigNumber generateRandomNumber(int digitsNumber) {
        int[] digit = new int[digitsNumber];
        Random r = new Random();
        for (int i = 0; i < digitsNumber; i++) {
            digit[i] = r.nextInt(9);
        }
        return new BigNumber(digit);
    }

    public BigNumber[] divideInHalf() {
        int n = digits.size();
        int k = n / 2;
        BigNumber firstHalf = new BigNumber(digits.subList(0, k));
        BigNumber secondHalf = new BigNumber(digits.subList(k, n));
        return new BigNumber[]{secondHalf, firstHalf};
    }

    public int compareTo(BigNumber n) {
        int thisLastNonZeroPosition = findPositionOfLastNonZeroDigit();
        int nLastNonZeroPosition = n.findPositionOfLastNonZeroDigit();
        while(true) {
            if(thisLastNonZeroPosition > nLastNonZeroPosition) {
                return 1;
            }
            if(thisLastNonZeroPosition < nLastNonZeroPosition) {
                return -1;
            }
            int thisValue = get(thisLastNonZeroPosition);
            int nValue = n.get(nLastNonZeroPosition);
            if(thisValue > nValue) {
                return 1;
            }
            if(thisValue < nValue){
                return -1;
            }
            if(thisLastNonZeroPosition == 0){
                return 0;
            }
            thisLastNonZeroPosition = findPositionOfLastNonZeroDigit(thisLastNonZeroPosition-1);
            nLastNonZeroPosition = n.findPositionOfLastNonZeroDigit(nLastNonZeroPosition-1);
        }

    }

    public int findPositionOfLastNonZeroDigit() {
        return findPositionOfLastNonZeroDigit(size() - 1);
    }

    private int findPositionOfLastNonZeroDigit(int fromPosition) {
        for (int i = fromPosition; i >= 0; i--) {
            if (get(i) != 0) {
                return i;
            }
        }
        return -1;
    }
}
