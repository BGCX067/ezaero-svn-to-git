package org.ezaero.sandbox.conflation.store;

import java.util.HashMap;
import java.util.Map;

import org.ezaero.sandbox.conflation.Price;
import org.ezaero.sandbox.conflation.RWPrice;

public class SyncMapAltPriceStore implements PriceStore {

    private final Map<Long, RWPrice> prices;

    public SyncMapAltPriceStore(int size) {
        prices = new HashMap<Long, RWPrice>(size);
    }

    @Override
    public synchronized Price get(long id) {
        return prices.get(id);
    }

    @Override
    public synchronized void update(long id, double bid, double ask, double high, double low, double last, long volume) {
        RWPrice price = prices.get(id);
        if (price == null) {
            price = new RWPrice(id, 0, bid, ask, last, volume);
            prices.put(id, price);
        } else {
            price.update(0, bid, ask, last, volume);
        }
    }

}
