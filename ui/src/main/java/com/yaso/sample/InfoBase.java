package com.yaso.sample;

import java.util.Map;

abstract class InfoBase {

  protected String makeHtml(Map<String, Object> map) {
    StringBuilder sb = new StringBuilder();
    sb.append("<dl>");
    map.forEach((key, value) -> {
      sb.append("<dt>");
      sb.append(key);
      sb.append("</dt>");
      sb.append("<dd>");
      sb.append(value);
      sb.append("</dd>");
    });
    sb.append("</dl>");
    return sb.toString();
  }
}
