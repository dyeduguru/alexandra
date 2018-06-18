package com.pichafast.db.foundation;

import java.util.Objects;

public class Row {

  private final String hexKey;
  private final String hexValue;

  public Row(String hexKey, String hexValue) {
    this.hexKey = hexKey;
    this.hexValue = hexValue;
  }

  public String getHexKey() {
    return hexKey;
  }

  public String getHexValue() {
    return hexValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Row row = (Row) o;
    return Objects.equals(hexKey, row.hexKey) &&
        Objects.equals(hexValue, row.hexValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hexKey, hexValue);
  }
}
