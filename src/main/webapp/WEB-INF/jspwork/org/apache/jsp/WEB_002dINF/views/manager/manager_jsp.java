/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-08-01 09:16:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1688615092135L));
    _jspx_dependants.put("jar:file:/C:/workspace/5_Server/.metadata/.plugins/org.eclipse.wst.server.core/tmp3/wtpwebapps/teamTest/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>관리자 회원 게시글 관리</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/main-style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/manager.css\">\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/b5c2a13e26.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.7.0.min.js\" integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("    <div id=\"main\">\r\n");
      out.write("        \r\n");
      out.write("        <section class=\"left-side\">\r\n");
      out.write("            <span><b>관리자페이지</b></span>\r\n");
      out.write("            \r\n");
      out.write("            <ul  class=\"list-group\">\r\n");
      out.write("                <li> <a href=\"#\">회원 및 게시글 관리 </a></li>\r\n");
      out.write("                <li> <a href=\"#\">공지사항 관리</a></li>\r\n");
      out.write("                \r\n");
      out.write("            </ul>\r\n");
      out.write("            \r\n");
      out.write("        </section>\r\n");
      out.write("        \r\n");
      out.write("        <!-- section 나누는 div -->\r\n");
      out.write("        <div class=\"section-d\">\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <section class=\"manager-area1\">\r\n");
      out.write("            \r\n");
      out.write("            <h3>회원 관리</h3>\r\n");
      out.write("            \r\n");
      out.write("            <!-- 회원관리 검색 창 -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"searchArea\">\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"text\" id=\"searchMember\" name=\"search\" \r\n");
      out.write("                placeholder=\"회원아이디 검색\" autocomplete=\"off\">\r\n");
      out.write("                \r\n");
      out.write("                <button type=\"submit\" id=\"member-btn\" class=\"fa-solid fa-magnifying-glass\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <form action=\"#\" method=\"\" name=\"manager-member\">\r\n");
      out.write("                <table>\r\n");
      out.write("                \r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <!-- 전체 선택 체크 박스 -->\r\n");
      out.write("                        <th ></th>\r\n");
      out.write("                        <th >번호</th>\r\n");
      out.write("                        <th >아이디</th>\r\n");
      out.write("                        <th >이름</th>\r\n");
      out.write("                        <th >전화번호</th>\r\n");
      out.write("                        <th >주소</th>\r\n");
      out.write("                        <th >탈퇴여부</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tbody id=\"resultMember\">\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("                <!-- typw=\"submit\" id=\"borderbtn\" -->\r\n");
      out.write("                <input type=\"hidden\" id=\"memberResult\">\r\n");
      out.write("                <button type=\"button\" onclick=\"banMember()\" >회원 탈퇴</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <section class=\"manager-area1\">\r\n");
      out.write("                <br><br>\r\n");
      out.write("                <h3>게시글 관리</h3>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"searchArea\">\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"text\" id=\"searchBoard\" name=\"search1\" \r\n");
      out.write("                placeholder=\"게시글 검색\" autocomplete=\"off\">\r\n");
      out.write("                \r\n");
      out.write("                <button type=\"submit\" id=\"board-btn\" class=\"fa-solid fa-magnifying-glass\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <table>\r\n");
      out.write("            \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <!-- 전체 선택 체크 박스 -->\r\n");
      out.write("                    <th ></th>\r\n");
      out.write("                    <th >게시글 번호</th>\r\n");
      out.write("                    <th >게시글 제목</th>\r\n");
      out.write("                    <th >아이디</th>\r\n");
      out.write("                    <th >전화번호</th>\r\n");
      out.write("                    <th >게시글 삭제 여부</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("                <tbody id=\"resultBoard\">\r\n");
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            </table>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <!-- typw=\"submit\" id=\"borderbtn\" -->\r\n");
      out.write("            <input type=\"hidden\" id=\"boardResult\">\r\n");
      out.write("            <button type=\"button\" onclick=\"deleteBoard()\" >게시글 삭제</button>\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/manager.js\"></script>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
