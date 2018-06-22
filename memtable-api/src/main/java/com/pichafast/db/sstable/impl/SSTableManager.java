package com.pichafast.db.sstable.impl;

public interface SSTableManager {
    void add(SSTable path);

    void runCompaction();
}
