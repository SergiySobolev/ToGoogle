package com.sbk.longarithmetics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BigNumberTest {

    BigNumber number;

    @Before
    public  void setUp() {
        number = new BigNumber(1, 2, 3, 4);
    }

    @Test
    public void testToString() throws Exception {
        assertThat(number.toString(), equalTo("1234")) ;
        number.addHigherDigit(5);
        assertThat(number.toString(), equalTo("51234")) ;
        BigNumber negativeNumber = new BigNumber("23456");
        negativeNumber.sign = Sign.MINUS;
        assertThat(negativeNumber.toString(), equalTo("-23456"));
        assertThat(number.appendZeroBefore(1).toString(), equalTo("51234"));
    }

    @Test
    public void testMultiply1() throws Exception {
        assertThat(number.multiply1(9).toString(), equalTo("11106"));
        assertThat(number.multiply1(5).toString(), equalTo("6170"));
    }

    @Test
    public void testAdd() throws Exception {
        assertThat(new BigNumber("8").add(new BigNumber("3")).toString(), equalTo("11"));
        assertThat(number.add(new BigNumber(4,5,6,7)).toString(), equalTo("5801"));
        assertThat(number.add(new BigNumber(4,5)).toString(), equalTo("1279"));
        assertThat(new BigNumber(1,1,1,1,1,1).add(new BigNumber(1,1,1,1)).toString(),
                equalTo("112222"));
        assertThat(new BigNumber(8,7,7,7).add(new BigNumber(9,8,1,3,4,5)).toString(),
                equalTo("990122"));
    }

    @Test
    public void testAppendZero() throws Exception {
        assertThat(number.appendZeroBefore(4).toString(), equalTo("1234"));
    }

    @Test
    public void testAppendZeroBefore() throws Exception {
        assertThat(number.appendZeroBefore(0).toString(), equalTo("1234"));
        assertThat(number.appendZeroBefore(-1).toString(), equalTo("1234"));
        assertThat(number.appendZeroBefore(5).toString(), equalTo("1234"));
    }

    @Test
    public void testAppendZeroAfter() throws Exception {
        assertThat(number.appendZeroAfter(0).toString(), equalTo("1234"));
        assertThat(number.appendZeroAfter(-1).toString(), equalTo("1234"));
        assertThat(number.appendZeroAfter(3).toString(), equalTo("1234000"));
    }

    @Test
    public void testAddLowerDigit() throws Exception {
        assertThat(number.addLowerDigit(7).toString(), equalTo("12347"));
        assertThat(number.addLowerDigit(0).toString(), equalTo("123470"));
    }

    @Test
    public void testAddHigherDigit() throws Exception {
        assertThat(number.addHigherDigit(7).toString(), equalTo("71234"));
        assertThat(number.addHigherDigit(0).toString(), equalTo("71234"));
    }

    @Test
    public void testCalibrate() throws Exception {
        BigNumber result = number.calibrate(new BigNumber(1,2,3));
        assertThat(result.toString(), equalTo("123"));
        number.calibrate(new BigNumber(1,2,3,4,5,6));
        assertThat(number.toString(), equalTo("1234"));
    }

    @Test
    public void testMultiply() throws Exception {
        BigNumber multiplier = new BigNumber(4,3,2,1);
        BigNumber result = number.multiply(multiplier);
        assertThat(result.toString(), equalTo("5332114"));
    }

    @Test
    public void testMultiplyRecursive() throws Exception {
        BigNumber n1 = new BigNumber("12");
        BigNumber n2 = new BigNumber("43");
        BigNumber res = n1.multiplyRecursive(n2);
        assertThat(res.toString(), equalTo("516"));
        BigNumber multiplier = new BigNumber(4,3,2,1);
        BigNumber result = number.multiplyRecursive(multiplier);
        assertThat(result.toString(), equalTo("5332114"));
    }

    @Test
    public void testGetDigits() throws Exception {

    }

    @Test
    public void testGenerateRandomNumber() throws Exception {
        assertThat(BigNumber.generateRandomNumber(5).toString().length(), lessThanOrEqualTo(5));
    }

    @Test
    public void testDivideInHalf() throws Exception {
        BigNumber[] res = new BigNumber(1,2,3,4,5,6,7,8).divideInHalf();
        assertThat(res.length, equalTo(2));
        assertThat(res[0].toString(), equalTo("1234"));
        assertThat(res[1].toString(), equalTo("5678"));

        BigNumber bigNumber = new BigNumber("12345678");
        assertThat(bigNumber.toString(), equalTo("12345678"));
        res = bigNumber.divideInHalf();
        assertThat(res.length, equalTo(2));
        assertThat(res[0].toString(), equalTo("1234"));
        assertThat(res[1].toString(), equalTo("5678"));

        res = new BigNumber("1234567898765432").divideInHalf();
        assertThat(res.length, equalTo(2));
        assertThat(res[0].toString(), equalTo("12345678"));
        assertThat(res[1].toString(), equalTo("98765432"));
    }

    @Test
    public void testFindFirstNonZeroDigitFromPosition() throws Exception {
        BigNumber n = new BigNumber("1002300");
        assertThat(n.findFirstNonZeroDigitFromPosition(1), equalTo(2));
        assertThat(n.findFirstNonZeroDigitFromPosition(0), equalTo(2));
        assertThat(n.findFirstNonZeroDigitFromPosition(4), equalTo(6));
    }

    @Test
    public void testFindPositionOfLastNonZeroDigit() throws Exception {
        assertThat(new BigNumber("1002300").findPositionOfLastNonZeroDigit(), equalTo(6));
        assertThat(new BigNumber("0002300").findPositionOfLastNonZeroDigit(), equalTo(3));
    }

    @Test
    public void testCompareTo() throws Exception {
        assertThat(new BigNumber("556123").compareTo(new BigNumber("556123")), equalTo(0));
        assertThat(new BigNumber("112").compareTo(new BigNumber("221")), equalTo(-1));
        assertThat(new BigNumber("556123").compareTo(new BigNumber("221")), equalTo(1));
        assertThat(new BigNumber("10012").compareTo(new BigNumber("10112")), equalTo(-1));
    }

    @Test
    public void testSubtract() throws Exception {
        assertThat(new BigNumber("555").subtract(new BigNumber("11")).toString(), equalTo("544"));
        assertThat(new BigNumber("555").subtract(new BigNumber("555")).toString(), equalTo(""));
        assertThat(new BigNumber("555").subtract(new BigNumber("666")).toString(), equalTo("-111"));
        assertThat(new BigNumber("555").subtract(new BigNumber("6666")).toString(), equalTo("-6111"));
    }

    @Test
    public void testMultiplyKaratsuba() throws Exception {
        BigNumber n1 = new BigNumber("12");
        BigNumber n2 = new BigNumber("43");
        BigNumber res = n1.multiplyKaratsuba(n2);
        assertThat(res.toString(), equalTo("516"));
        BigNumber multiplier = new BigNumber(4,3,2,1);
        BigNumber result = number.multiplyKaratsuba(multiplier);
        assertThat(result.toString(), equalTo("5332114"));
    }
}