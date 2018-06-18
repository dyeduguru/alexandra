package com.pichafast.db.sstable;

public interface SSTableManager {
    void add(SSTable path);

    void runCompaction();
}
