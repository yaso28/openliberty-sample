package com.yaso.sample;

import java.util.HashMap;
import java.util.Map;

public class UiInfo extends InfoBase {

  private String hostname;

  public UiInfo() throws Exception {
    String hostname = System.getenv("HOSTNAME");
    if (hostname == null) {
      hostname = "NULL";
    }
    this.hostname = hostname;
  }

  public String getHostname() {
    return this.hostname;
  }

  public String toHtml() {
    Map<String, Object> map = new HashMap<>();
    map.put("hostname", this.hostname);
    return this.makeHtml(map);
  }
}
