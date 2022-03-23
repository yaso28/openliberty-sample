<%@ page import="com.yaso.sample.UiInfo"%>
<%@ page import="com.yaso.sample.UserInfo"%>
<%
  String uiInfo = new UiInfo().toJson();
  String userInfo = new UserInfo().toJson();
%>
<html>
  <head>
    <title>SAMPLE UI</title>
  </head>
  <body>
    <h1>USER - SAMPLE UI</h1>

    <h2>UI</h2>
    <p style="white-space: pre-wrap;"><%=uiInfo%></p>

    <h2>USER</h2>
    <p style="white-space: pre-wrap;"><%=userInfo%></p>

    <hr />

    <ul>
      <li><a href="/">[page] HOME</a></li>
      <li><a href="/user">[page] USER (saml2.0 auth required)</a></li>
      <li><a href="/api/info">[api] INFO</a></li>
      <li><a href="/api/info/user">[api] INFO USER (saml2.0 auth required)</a></li>
    </ul>
  </body>
</html>
