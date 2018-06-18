package com.pichafast.db.memtable.test;

import com.pichafast.db.memtable.MemTable;
import com.pichafast.db.memtable.impl.SkipListMemTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkipListMemTableTest {

  private MemTable skipListMemTable;

  @Before
  public void init() {
    skipListMemTable = new SkipListMemTable();
  }

  @Test
  public void testHasKey() {
    byte[] key = fromString("testKey");
    byte[] value = fromString("testValue");
    skipListMemTable.put(key, value);
    Assert.assertTrue(skipListMemTable.hasKey(key));
  }

  @Test
  public void testGetKey() throws Exception {
    byte[] key = fromString("testKey");
    String testValue = "testValue";
    byte[] value = fromString(testValue);
    skipListMemTable.put(key, value);
    Assert.assertEquals(testValue, new String(skipListMemTable.get(key)));
  }

  private static byte [] fromString(String s) {
    return s.getBytes();
  }


}
