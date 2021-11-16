package com.rednikeeg;

import java.util.Arrays;

/**
 * The class represents integer, that can hold numbers from -1e100 + 1 to 1e100 - 1
 *
 * @author Maksym "rednikeeg" Bohachov
 * @see LAMath
 */
public final class BigNumber {
    /**
     * Internal array of integers
     */
    private final int[] content;
    /**
     * Fixed length of BigNumber
     */
    private static final int LENGTH = 100;
    /**
     * Indicates whether BigNumber is negative or not
     */
    private final boolean isNegative;

    /**
     * Copy constructor
     * @param num - BigNumber should be copied
     */
    public BigNumber(BigNumber num) {
        content = new int[LENGTH];
        System.arraycopy(num.content, 0, content, 0, LENGTH);

        isNegative = num.isNegative;
    }

    /**
     * Initializes BigNumber from the String value
     * @param str String value
     */
    public BigNumber(String str) {
        isNegative = str.toCharArray()[0] == '-';

        if (isNegative) {
            str = str.substring(1);
        }

        content = parse(str);
    }

    /**
     * Initializes new BigNumber from array and negativity sign
     * @param content certain array of values
     * @param isNegative indicates whether BigNumber should be negative or not
     */
    private BigNumber(int[] content, boolean isNegative) {
        this.content = parse(content);
        this.isNegative = isNegative;
    }

    /**
     * Initializes empty (filled with zeros array) with size of LENGTH
     * @return array filled with zeros
     */
    private int[] parse() {
        int[] result = new int[LENGTH];

        Arrays.fill(result, 0);

        return result;
    }

    /**
     * @param str String to parse
     * @return array as a result of String parsing
     */
    private int[] parse(String str) {
        char[] chars = str.toCharArray();

        int[] result = parse();

        int length = chars.length;

        for (int i = LENGTH - 1; i >= LENGTH - length - 1; i--) {
            result[i] = parse(chars[i - length]);
        }

        return result;
    }

    /**
     * @param arr input array
     * @return resulting array, that holds inner value of BigNumber
     */
    private int[] parse(int[] arr) {
        int[] result = parse();

        System.arraycopy(content, 0, result, LENGTH - content.length, content.length);

        return result;
    }

    /**
     * @param ch char should be parsed to int
     * @return int value of char
     */
    private int parse(char ch) {
        return ch - '0';
    }

    /**
     * @return log10 of this number
     */
    public int log10() {
        throw new UnsupportedOperationException();
    }

    /**
     * Subtracts from this BigNumber another one
     * @param num BigNumber should be subtracted from this
     * @return result of subtraction
     */
    public BigNumber minus(BigNumber num) {
        throw new UnsupportedOperationException();
    }

    /**
     * Does subtraction with swapped (if needed) numbers
     * @param higher highest number in subtraction pair
     * @param lower lowest number in subtraction pair
     * @param isNegative sign of resulting number
     * @return result of subtraction
     */
    private static BigNumber minus(BigNumber higher, BigNumber lower, boolean isNegative) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds to this BigNumber another one
     * @param num BigNumber should be added to this
     * @return result of addition
     */
    public BigNumber plus(BigNumber num) {
        throw new UnsupportedOperationException();
    }

    /**
     * Multiplies this BigNumber by another one
     * @param num BigNumber should be multiplied by this
     * @return result of multiplication
     */
    public BigNumber multiply(BigNumber num) {
        throw new UnsupportedOperationException();
    }

    /**
     * Divides this BigNumber by another one
     * @param num BigNumber by which this one should be divided
     * @return result of division
     */
    public BigNumber divide(BigNumber num) {
        throw new UnsupportedOperationException();
    }

    /**
     * Takes square root of this BigNumber
     * @return square root of this number
     */
    public BigNumber sqrt() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BigNumber)) {
            return false;
        }

        BigNumber num = (BigNumber) o;

        return isNegative == num.isNegative && Arrays.equals(content, num.content);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(content).dropWhile(v -> v == 0).forEach(sb::append);

        return sb.toString();
    }
}
