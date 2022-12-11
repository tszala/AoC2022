package com.tszala.aoc2022.utils;

import static java.lang.String.format;

public class Tuple<L,R> {
    public final L left;
    public final R right;

    public Tuple(L l, R r) {
        left = l;
        right = r;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public String toString() {
        return format("<%s,%s>", left.toString(), right.toString());
    }

    @Override
    public int hashCode() {
        return left.hashCode() + right.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Tuple)) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        Tuple<L, R> tuple = (Tuple<L, R>) obj;
        return (((Tuple<?, ?>) obj).left.equals(left)) && ((Tuple<?, ?>) obj).right.equals(right);
    }
}
