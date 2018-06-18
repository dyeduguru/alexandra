package com.pichafast.db;

public interface MemTable {

  void put(byte [] key, byte [] val);

  byte [] get(byte [] key) throws KeyNotFoundException;

  byte [] hasKey(byte [] key);

}
