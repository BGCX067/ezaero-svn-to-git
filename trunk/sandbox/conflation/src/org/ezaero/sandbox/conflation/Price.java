package org.ezaero.sandbox.conflation;

public interface Price {

    long getId();
    long getVersion();
    double getBid();
    double getAsk();
    double getLast();
    long getVolume();
}
