package com.pichafast.db.storage;

import com.pichafast.db.KeyNotFoundException;

public interface StorageTable {

  void put(byte [] key, byte [] val);

  byte [] get(byte [] key) throws KeyNotFoundException;

  boolean hasKey(byte [] key);

}
