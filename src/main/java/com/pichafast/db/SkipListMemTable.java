package com.pichafast.db;

public class SkipListMemTable implements MemTable {

  public void put(byte[] key, byte[] val) {

  }

  public byte[] get(byte[] key) throws KeyNotFoundException {
    return new byte[0];
  }

  public byte[] hasKey(byte[] key) {
    return new byte[0];
  }

}
