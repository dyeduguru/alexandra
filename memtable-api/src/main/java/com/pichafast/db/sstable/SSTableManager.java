package com.pichafast.db.sstable;


import com.pichafast.db.foundation.Row;
import java.util.SortedSet;

public interface SSTableManager {
    void add(SSTable path);

    void runCompaction();

    SSTable create(SortedSet<Row> sortedRows);

}
