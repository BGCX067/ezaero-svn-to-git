package org.ezaero.sandbox.conflation.store;

import java.util.HashMap;
import java.util.Map;

import org.ezaero.sandbox.conflation.Price;
import org.ezaero.sandbox.conflation.ROPrice;

public class PlainMapPriceStore implements PriceStore {

    private final Map<Long, Price> prices;
    
    public PlainMapPriceStore(int size) {
        prices = new HashMap<Long, Price>(size);
    }
    
    @Override
    public Price get(long id) {
        return prices.get(id);
    }

    @Override
    public void update(long id, double bid, double ask, double high, double low, double last, long volume) {
        prices.put(id, new ROPrice(id, 0, bid, ask, last, volume));
    }

}
