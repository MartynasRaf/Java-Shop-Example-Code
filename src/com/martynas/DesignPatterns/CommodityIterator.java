package com.martynas.DesignPatterns;

import com.martynas.Commodity;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CommodityIterator {
    public static Iterator<Commodity> forCommodities(List<Commodity> commodities) {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < commodities.size();
            }

            @Override
            public Commodity next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return commodities.get(index++);
            }
        };
    }
}
