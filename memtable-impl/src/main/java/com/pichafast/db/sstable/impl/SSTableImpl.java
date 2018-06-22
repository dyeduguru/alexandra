package com.pichafast.db.sstable.impl;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.pichafast.db.foundation.Row;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.SortedSet;

public class SSTableImpl implements SSTable {
    private static String BLOOMFILTER_FILENAME = "bloomfilter";
    private static String SSTABLE_FILENAME = "sstable.proto";
    public SSTableImpl(Path baseDir, SortedSet<Row> rows) throws IOException {
        Path tempDir = Files.createTempDirectory(baseDir, "");
        Path bloomFilterPath = Files.createFile(Paths.get(tempDir.toString(), BLOOMFILTER_FILENAME));
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),rows.size());
        rows.forEach(it -> bloomFilter.put(it.getHexKey()));
        bloomFilter.writeTo(new FileOutputStream(bloomFilterPath.toFile()));
        FileWriter writer = new FileWriter(Paths.get(tempDir.toString(), SSTABLE_FILENAME).toString());
        rows.forEach(it -> writer.write());
    }

    @Override
    public boolean isPresent(byte[] key) {
        return false;
    }

    @Override
    public byte[] read(byte[] key) {
        return new byte[0];
    }

    @Override
    public String path() {
        return null;
    }
}
