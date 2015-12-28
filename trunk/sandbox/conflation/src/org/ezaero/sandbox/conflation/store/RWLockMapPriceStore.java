package org.ezaero.sandbox.conflation.store;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.ezaero.sandbox.conflation.Price;
import org.ezaero.sandbox.conflation.ROPrice;

public class RWLockMapPriceStore implements PriceStore {

    private final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    private final Map<Long, Price> prices;

    public RWLockMapPriceStore(int size) {
        prices = new HashMap<Long, Price>(size);
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
            prices.put(id, new ROPrice(id, 0, bid, ask, last, volume));
        } finally {
            rwlock.writeLock().unlock();
        }
    }
}
