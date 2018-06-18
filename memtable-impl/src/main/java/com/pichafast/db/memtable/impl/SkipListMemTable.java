package com.pichafast.db.memtable.impl;

import apple.laf.JRSUIUtils.Tree;
import com.google.common.base.Preconditions;
import com.pichafast.db.KeyNotFoundException;
import com.pichafast.db.foundation.Row;
import com.pichafast.db.sstable.SSTable;
import com.pichafast.db.sstable.SSTableManager;
import com.pichafast.db.sstable.SSTableManagerImpl;
import com.pichafast.db.storage.StorageTable;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class SkipListMemTable implements StorageTable {

  private final ConcurrentSkipListMap<String, String> map;
  private final SSTableManager ssTableManager;

  public SkipListMemTable() {
    this.map = new ConcurrentSkipListMap<>();
    this.ssTableManager = new SSTableManagerImpl();
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
      String bytes = map.get(toHex(key));
      try {
        return Hex.decodeHex(bytes);
      } catch (DecoderException e) {
        throw new RuntimeException("unable to decode value", e);
      }
    }
  }

  public boolean hasKey(byte[] key) {
    Preconditions.checkNotNull(key, "null key encountered.");
    return map.containsKey(toHex(key));
  }

  @Override
  public SSTable flush() {
    SortedSet<Row> rows = map.entrySet()
        .stream()
        .map(it -> new Row(it.getKey(), it.getValue()))
        .collect(Collectors.toCollection(TreeSet::new));
    return ssTableManager.create(rows);
  }

  private static String toHex(byte [] bytes) {
    return new String(Hex.encodeHex(bytes));
  }

}
