package com.pichafast.db.sstable;

public interface SSTable {
    boolean isPresent(byte[] key);

    byte[] read(byte[] key);

    String path();
}
