<%@ page import="com.yaso.sample.UiInfo"%>
<%
  String uiInfo = new UiInfo().toHtml();
%>
<html>
  <head>
    <title>SAMPLE UI</title>
  </head>
  <body>
    <h1>HOME - SAMPLE UI</h1>

    <h2>UI</h2>
    <%=uiInfo%>

    <hr />

    <ul>
      <li><a href="/">[page] HOME</a></li>
      <li><a href="/user">[page] USER (saml2.0 auth required)</a></li>
      <li><a href="/api/info">[api] INFO</a></li>
      <li><a href="/api/info/user">[api] INFO USER (saml2.0 auth required)</a></li>
      <li><a href="/ibm/saml20/defaultSP/samlmetadata">[spMetadata]</a></li>
    </ul>
  </body>
</html>
