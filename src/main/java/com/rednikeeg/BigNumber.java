package com.rednikeeg;

import java.util.Arrays;

/**
 * The class represent integer, that can hold numbers from -1e100 + 1 to 1e100 - 1
 * @see LAMath
 * @author Maksym "rednikeeg" Bohachov
 */
public class BigNumber {
    private final int[] content;
    private static final int LENGTH = 100;
    private final boolean isNegative;

    public BigNumber() {
        throw new UnsupportedOperationException();
    }

    public BigNumber(BigNumber num) {
        throw new UnsupportedOperationException();
    }

    public int log10() {
        throw new UnsupportedOperationException();
    }

    public BigNumber minus(BigNumber num) {
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
