package org.ezaero.sandbox.conflation.store;

import gnu.trove.TLongObjectHashMap;

import org.ezaero.sandbox.conflation.Price;
import org.ezaero.sandbox.conflation.ROPrice;

public class SyncLongMapPriceStore implements PriceStore {

    private final TLongObjectHashMap<ROPrice> prices;

    public SyncLongMapPriceStore(int size) {
        prices = new TLongObjectHashMap<ROPrice>(size);
    }

    @Override
    public synchronized Price get(long id) {
        return prices.get(id);
    }

    @Override
    public synchronized void update(long id, double bid, double ask, double high, double low, double last, long volume) {
        prices.put(id, new ROPrice(id, 0, bid, ask, last, volume));
    }

}
