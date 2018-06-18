package com.pichafast.db.memtable;

import com.pichafast.db.KeyNotFoundException;

public interface MemTable {

  void put(byte [] key, byte [] val);

  byte [] get(byte [] key) throws KeyNotFoundException;

  boolean hasKey(byte [] key);

}
