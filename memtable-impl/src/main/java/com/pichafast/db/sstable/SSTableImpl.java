package com.pichafast.db;

import com.pichafast.db.sstable.SSTable;

public class SSTableImpl implements SSTable {
    @Override
    public boolean isPresent(byte[] key) {
        return false;
    }

    @Override
    public byte[] read(byte[] key) {
        return new byte[0];
    }

    @Override
    public String path() {
        return null;
    }
}
