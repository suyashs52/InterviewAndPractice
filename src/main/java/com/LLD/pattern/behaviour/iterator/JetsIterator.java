package com.LLD.pattern.behaviour.iterator;

import java.util.List;

public class JetsIterator implements Iterator {
    public JetsIterator(List<IAircraft> jets) {
    }

    @Override
    public Object next() {
        return next();
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
