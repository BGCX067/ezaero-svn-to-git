package org.ezaero.sandbox.conflation;

public class ROPrice implements Price {

    private final long id;
    private final long version;
    private final double bid;
    private final double ask;
    private final double last;
    private final long volume;

    public ROPrice(long id, long version, double bid, double ask, double last, long volume) {
        this.id = id;
        this.version = version;
        this.bid = bid;
        this.ask = ask;
        this.last = last;
        this.volume = volume;
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public double getLast() {
        return last;
    }

    public long getVolume() {
        return volume;
    }
}
