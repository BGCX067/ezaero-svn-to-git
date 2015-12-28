package org.ezaero.sandbox.conflation.store;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.ezaero.sandbox.conflation.Price;
import org.ezaero.sandbox.conflation.RWPrice;

public class RWLockMapAltPriceStore implements PriceStore {

    private final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    private final Map<Long, RWPrice> prices;

    public RWLockMapAltPriceStore(int size) {
        prices = new HashMap<Long, RWPrice>(size);
    }

    @Override
    public Price get(long id) {
        rwlock.readLock().lock();
        try {
            return prices.get(id);
        } finally {
            rwlock.readLock().unlock();
        }
    }

    @Override
    public void update(long id, double bid, double ask, double high, double low, double last, long volume) {
        rwlock.writeLock().lock();
        try {
            RWPrice price = prices.get(id);
            if (price == null) {
                price = new RWPrice(id, 0, bid, ask, last, volume);
                prices.put(id, price);
            } else {
                price.update(0, bid, ask, last, volume);
            }
        } finally {
            rwlock.writeLock().unlock();
        }
    }

}
