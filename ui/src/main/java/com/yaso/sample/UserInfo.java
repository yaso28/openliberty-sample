package com.yaso.sample;

import com.ibm.websphere.security.auth.WSSubject;
import com.ibm.websphere.security.saml2.Saml20Token;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class UserInfo extends InfoBase {

  private String nameId;

  public UserInfo() throws Exception {
    Set<Saml20Token> credentials = WSSubject.getCallerSubject().getPrivateCredentials(Saml20Token.class);
    Saml20Token token = credentials.toArray(new Saml20Token[0])[0];

    this.nameId = token.getSAMLNameID();
  }

  public String getNameId() {
    return this.nameId;
  }

  public String toHtml() {
    Map<String, Object> map = new HashMap<>();
    map.put("nameId", this.nameId);
    return this.makeHtml(map);
  }
}
