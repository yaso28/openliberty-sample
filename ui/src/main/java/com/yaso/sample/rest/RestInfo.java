package com.yaso.sample.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import com.yaso.sample.UiInfo;
import com.yaso.sample.UserInfo;

@Path("info")
public class RestInfo {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> getInfo() throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put("ui", new UiInfo());
    return map;
  }

  @GET
  @Path("user")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> getUser() throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put("ui", new UiInfo());
    map.put("user", new UserInfo());
    return map;
  }
}
