package com.rednikeeg;

import java.util.Arrays;

/**
 * The class represents integer, that can hold numbers from -1e100 + 1 to 1e100 - 1
 *
 * @author Maksym "rednikeeg" Bohachov
 * @see LAMath
 */
public final class BigNumber {
    private final int[] content;
    private static final int LENGTH = 100;
    private final boolean isNegative;

    public BigNumber(BigNumber num) {
        content = new int[LENGTH];
        System.arraycopy(num.content, 0, content, 0, LENGTH);

        isNegative = num.isNegative;
    }

    public BigNumber(String str) {
        isNegative = str.toCharArray()[0] == '-';

        if (isNegative) {
            str = str.substring(1);
        }

        content = parse(str);
    }

    private BigNumber(int[] content, boolean isNegative) {
        this.content = parse(content);
        this.isNegative = isNegative;
    }

    private int[] parse() {
        int[] result = new int[LENGTH];

        Arrays.fill(result, 0);

        return result;
    }

    private int[] parse(String str) {
        char[] chars = str.toCharArray();

        int[] result = parse();

        int length = chars.length;

        for (int i = LENGTH - 1; i >= LENGTH - length - 1; i--) {
            result[i] = parse(chars[i - length]);
        }

        return result;
    }

    private int[] parse(int[] arr) {
        int[] result = parse();

        System.arraycopy(content, 0, result, LENGTH - content.length, content.length);

        return result;
    }

    private int parse(char ch) {
        return ch - '0';
    }

    public int log10() {
        throw new UnsupportedOperationException();
    }

    public BigNumber minus(BigNumber num) {
        throw new UnsupportedOperationException();
    }

    private static BigNumber minus(BigNumber higher, BigNumber lower, boolean isNegative) {
        throw new UnsupportedOperationException();
    }

    public BigNumber plus(BigNumber num) {
        throw new UnsupportedOperationException();
    }

    public BigNumber multiply(BigNumber num) {
        throw new UnsupportedOperationException();
    }

    public BigNumber divide(BigNumber num) {
        throw new UnsupportedOperationException();
    }

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
