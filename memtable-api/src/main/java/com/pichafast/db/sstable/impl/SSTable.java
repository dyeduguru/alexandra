package com.pichafast.db.sstable.impl;

public interface SSTable {
    boolean isPresent(byte[] key);

    byte[] read(byte[] key);

    String path();
}
