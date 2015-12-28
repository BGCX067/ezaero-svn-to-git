package org.ezaero.sandbox.conflation;

public class RWPrice implements Price {

    private long id;
    private long version;
    private double bid;
    private double ask;
    private double last;
    private long volume;

    public RWPrice(long id, long version, double bid, double ask, double last, long volume) {
        this.id = id;
        this.version = version;
        this.bid = bid;
        this.ask = ask;
        this.last = last;
        this.volume = volume;
    }

    public void update(long version, double bid, double ask, double last, long volume) {
        this.version = version;
        this.bid = bid;
        this.ask = ask;
        this.last = last;
        this.volume = volume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

}
