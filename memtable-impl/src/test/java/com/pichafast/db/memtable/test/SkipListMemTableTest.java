package com.pichafast.db.memtable.test;

import com.pichafast.db.memtable.impl.SkipListMemTable;
import com.pichafast.db.sstable.SSTableManagerImpl;
import com.pichafast.db.storage.StorageTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkipListMemTableTest {

  private StorageTable skipListStorageTable;

  @Before
  public void init() {
    skipListStorageTable = new SkipListMemTable(new SSTableManagerImpl());
  }

  @Test
  public void testHasKey() {
    byte[] key = fromString("testKey");
    byte[] value = fromString("testValue");
    skipListStorageTable.put(key, value);
    Assert.assertTrue(skipListStorageTable.hasKey(key));
  }

  @Test
  public void testGetKey() throws Exception {
    byte[] key = fromString("testKey");
    String testValue = "testValue";
    byte[] value = fromString(testValue);
    skipListStorageTable.put(key, value);
    Assert.assertEquals(testValue, new String(skipListStorageTable.get(key)));
  }

  private static byte [] fromString(String s) {
    return s.getBytes();
  }


}
