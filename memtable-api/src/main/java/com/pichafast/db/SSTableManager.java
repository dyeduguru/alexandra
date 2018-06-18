package com.pichafast.db;

public interface SSTableManager {
    SSTable add(String path);

    void runCompaction();
}
