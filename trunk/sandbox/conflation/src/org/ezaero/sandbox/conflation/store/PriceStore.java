package org.ezaero.sandbox.conflation.store;

import org.ezaero.sandbox.conflation.Price;

public interface PriceStore {

	void update(long id, double bid, double ask, double high, double low, double last, long volume);
	
	Price get(long id);
}
