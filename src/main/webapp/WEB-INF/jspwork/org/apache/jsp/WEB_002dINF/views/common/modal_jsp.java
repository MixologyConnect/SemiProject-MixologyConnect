/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-08-01 01:59:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class modal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1688615096366L));
    _jspx_dependants.put("jar:file:/C:/workspace/semiproject/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.release();
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
      out.write("<div id=\"overlay\">\r\n");
      out.write("    <div id=\"modal-account\">\r\n");
      out.write("        <form id=\"modal-account-form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/login\" method=\"post\">\r\n");
      out.write("            <img id=\"modal-account-logo\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/logo2.svg\">\r\n");
      out.write("            <p id=\"modal-account-head\">Mixology Connect</p>\r\n");
      out.write("            <h3 id=\"modal-account-login\">로그인</h3>\r\n");
      out.write("            <input class=\"modal-account-input\" name=\"inputId\" type=\"text\" placeholder=\"ID\">\r\n");
      out.write("            <input class=\"modal-account-input\" name=\"inputPw\" type=\"password\" placeholder=\"PW\">\r\n");
      out.write("            <span>아이디 저장</span><input type=\"checkbox\">\r\n");
      out.write("            <span>아직 회원이 아니신가요?</span>&nbsp;<a>회원가입</a>\r\n");
      out.write("            <button id=\"modal-account-button\">LOGIN</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"modal-signup\">\r\n");
      out.write("        <form id=\"modal-signup\" action=\"signUp\" method=\"post\" name=\"signUp-form\" onsubmit=\"return signValidate()\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("                <h2>회원가입</h2>\r\n");
      out.write("                <p>회원가입 후 회원들과 소통해보세요.</p>\r\n");
      out.write("                <p class=\"w-pct60 right\" style=\"margin: 0 auto; padding-bottom: 5px; font-size: 13px;\">* 는 필수 입력 항목입니다.</p>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>*성명</td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td> \r\n");
      out.write("                            <input type=\"text\" id=\"memberName\" name=\"memberName\" class=\"chk size1\" maxlength=\"10\"\r\n");
      out.write("                                class=\"size\" placeholder=\"성명\" required>\r\n");
      out.write("                            <div class=\"signUp-message\" id=\"memberNameMessage\">이름을 입력해주세요</div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>*아이디</td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div id=\"info_id\">\r\n");
      out.write("                                <input type=\"text\" id=\"memberId\" name=\"memberId\" class=\"chk size1\" \r\n");
      out.write("                                    maxlength=\"20\" placeholder=\"아이디\" required>\r\n");
      out.write("                                    <button id=\"btn-id\" class=\"btn-fill-s\" type=\"button\"> 중복검사</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"signUp-message\" id=\"idMessage\" >아이디를 입력하세요.(영어 대소문자, 숫자 입력 가능) </div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>*비밀번호 </td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"password\" id=\"memberPw\" name=\"memberPw\" placeholder=\"비밀번호\" maxlength=\"30\" class=\"chk size\" autocomplete=\"off\">\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>*비밀번호 확인</td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"password\" name=\"memberPwConfirm\" id=\"memberPwConfirm\" placeholder=\"비밀번호확인\" class=\"chk size\" maxlength=\"30\" autocomplete=\"off\">\r\n");
      out.write("                            <div class=\"signUp-message\" id=\"pwMessage\">영어, 숫자,특수문자(!,@,#,-,_) 6~30글자 입력해주세요</div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>*전화번호</td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"text\" id=\"memberTel\" name=\"memberTel\"placeholder=\"(-없이 숫자만 입력)\" maxlength=\"11\" required>\r\n");
      out.write("                            <div class=\"signUp-message\" id=\"telMessage\">전화번호을 입력하세요</div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>*이메일</td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"text\" name=\"memberEmail\" id=\"memberEmail\" class=\"chk size\" placeholder=\"이메일\" required>\r\n");
      out.write("                            <div class=\"signUp-message\" id=\"emailMessage\">이메일을 입력해 주세요.</div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>주소</td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <div id=\"info-postNum\">\r\n");
      out.write("                                <input type=\"text\" id=\"sample6_postcode\" name=\"memberAddress\" placeholder=\"우편번호\" readonly>\r\n");
      out.write("                                <input type=\"button\" id=\"postBtn\" onclick=\"sample6_execDaumPostcode()\" name=\"btn-fill-s\" value=\"우편번호찾기\"><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input type=\"text\" id=\"sample6_address\" name=\"memberAddress\" placeholder=\"주소\" readonly><br>\r\n");
      out.write("                            <input type=\"text\" id=\"sample6_detailAddress\" name=\"memberAddress\" placeholder=\"상세주소\" >\r\n");
      out.write("                            <input type=\"text\" id=\"sample6_extraAddress\" name=\"memberAddress\" placeholder=\"참고항목\" readonly>\r\n");
      out.write("                            <!-- <button id=\"postBtn\" class=\"btn-fill-s\" onclick=\"postNum\">우편번호 찾기</button>\r\n");
      out.write("                            <input type=\"text\" name=\"postNum\" class=\"w-px60\" readonly>\r\n");
      out.write("                            <input type=\"text\" name=\"address\" readonly>\r\n");
      out.write("                            <input type=\"text\" name=\"address\"> -->\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </fieldset>\r\n");
      out.write("            <div class=\"btn-area\">\r\n");
      out.write("                <button type=\"reset\" id=\"resetBtn\">회원가입 취소</button>\r\n");
      out.write("                <button id=\"signUp-btn\" type=\"submit\">회원가입</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<input type=\"checkbox\" id=\"theme-switch-cbox\">\r\n");
      out.write("<label for=\"theme-switch-cbox\">\r\n");
      out.write("    <div id=\"theme-switch\">\r\n");
      out.write("        <img>\r\n");
      out.write("    </div>\r\n");
      out.write("</label>\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/common/modal.jsp(110,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty sessionScope.message}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("	<script>\r\n");
          out.write("		alert(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          out.write("	</script>\r\n");
          out.write("	");
          if (_jspx_meth_c_005fremove_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fremove_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_005fremove_005f0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    boolean _jspx_th_c_005fremove_005f0_reused = false;
    try {
      _jspx_th_c_005fremove_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fremove_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /WEB-INF/views/common/modal.jsp(114,1) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fremove_005f0.setVar("message");
      // /WEB-INF/views/common/modal.jsp(114,1) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fremove_005f0.setScope("session");
      int _jspx_eval_c_005fremove_005f0 = _jspx_th_c_005fremove_005f0.doStartTag();
      if (_jspx_th_c_005fremove_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.reuse(_jspx_th_c_005fremove_005f0);
      _jspx_th_c_005fremove_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fremove_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fremove_005f0_reused);
    }
    return false;
  }
}
