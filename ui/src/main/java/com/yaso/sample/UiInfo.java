package com.yaso.sample;

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
}
