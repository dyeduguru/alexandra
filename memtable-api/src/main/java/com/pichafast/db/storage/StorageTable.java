package com.pichafast.db.storage;

import com.pichafast.db.KeyNotFoundException;
import com.pichafast.db.sstable.SSTable;

public interface StorageTable {

  void put(byte [] key, byte [] val);

  byte [] get(byte [] key) throws KeyNotFoundException;

  boolean hasKey(byte [] key);

  SSTable flush();

}
