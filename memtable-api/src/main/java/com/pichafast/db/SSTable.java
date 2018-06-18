package com.pichafast.db;

public interface SSTable {
    boolean isPresent(byte[] key);

    byte[] read(byte[] key);

    String path();
}
