package com.pichafast.db.memtable.impl;

import com.google.common.base.Preconditions;
import com.pichafast.db.KeyNotFoundException;
import com.pichafast.db.memtable.MemTable;
import java.util.concurrent.ConcurrentSkipListMap;
import org.apache.commons.codec.binary.Hex;

public class SkipListMemTable implements MemTable {

  private final ConcurrentSkipListMap<String, String> map;

  public SkipListMemTable() {
    this.map = new ConcurrentSkipListMap<>();
  }

  private SkipListMemTable(ConcurrentSkipListMap<String, String> map) {
    this.map = map;
  }

  public void put(byte[] key, byte[] val) {
    Preconditions.checkNotNull(key, "null key encountered.");
    Preconditions.checkNotNull(val, "null value encountered.");
    map.put(toHex(key), toHex(val));
  }

  public byte[] get(byte[] key) throws KeyNotFoundException {
    if (!hasKey(key)) {
      throw new KeyNotFoundException();
    } else {
      return map.get(toHex(key)).getBytes();
    }
  }

  public boolean hasKey(byte[] key) {
    Preconditions.checkNotNull(key, "null key encountered.");
    return map.containsKey(toHex(key));
  }

  private static String toHex(byte [] bytes) {
    return new String(Hex.encodeHex(bytes));
  }

}
