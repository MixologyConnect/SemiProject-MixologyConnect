/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-30 06:58:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUpterms_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1688650288722L));
    _jspx_dependants.put("jar:file:/Users/imilae/SemiProject-MixologyConnect/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/Users/imilae/SemiProject-MixologyConnect/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425946270000L));
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>회원가입약관</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/main-style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/join-terms.css\">\n");
      out.write("	<link href=\"https://fonts.cdnfonts.com/css/segoe-ui-4\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"terms-area\">\n");
      out.write("        <div id=\"content-area\" >\n");
      out.write("            <h2>약관동의</h2>\n");
      out.write("            <div id=\"terms\">\n");
      out.write("                <label><input type=\"checkbox\" id=\"all-check\"><span id=\"all\" class=\"blue\">믹스올로지의 모든 약관을 확인하고 전체 동의 합니다</span> </label>\n");
      out.write("                <div id=\"check-area\">\n");
      out.write("                    <input type=\"checkbox\" name=\"checkbox\" value=\"UseYes\">\n");
      out.write("                    <label><span class=\"blue\">(필수)</span>이용약관</label>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"scroll-box\">\n");
      out.write("                    <p>\n");
      out.write("    믹스오롤지 커넥션 이용약관\n");
      out.write("    <br><br>\n");
      out.write("    제1조 (목적)<br>\n");
      out.write("    이 약관은 \"Mixology Connect\" 인터넷 사이트 (www.mixologyconnection.com, 이하 “믹스올로지 커넥션”이라 함) 통해서 제공하는 전자상거래 관련 서비스 및 기타 온라인 서비스 (이하 “서비스”라 함)를 이용하는 자간의 권리, 의무를 확정하고 이를 이행함으로써 상호 발전을 도모하는 것을 그 목적으로 합니다.\n");
      out.write("    <br><br>\n");
      out.write("    제2조(약관의 명시, 효력과 개정)<br>\n");
      out.write("    1. 회사는 이 약관의 내용을 회원이 확인할 수 있도록 \"믹스올로지\"초기 서비스화면 또는 연결화면에 게시합니다.\n");
      out.write("    <br>\n");
      out.write("    2. 회사가 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행 약관과 함께 초기화면에 그 적용일자 7일 (다만, 회원에게 불리한 내용으로 변경하는 경우에는 30일) 이전부터 적용일자 전일까지 공지합니다. 변경된 약관은 관련 법령에 특별한 규정 기타 부득이한 사유가 없는 한 그 적용일자 이전으로 소급하여 적용되지 아니합니다\n");
      out.write("    <br>\n");
      out.write("    3. 회원이 명시적으로 거부의사를 표명하지 않을 경우에는 개정된 약관에 동의하는 것으로 간주하며, 변경된 약관에 동의하지 않는 회원은 회원 탈퇴를 요청할 수 있습니다. 제3항의 조치에도 불구하고 약관의 개정 사실을 알지 못함으로써 발생하는 회원의 피해에 대하여 회사는 책임을 지지 않습니다.\n");
      out.write("    <br><br>\n");
      out.write("    제3조 (용어의 정의)<br>\n");
      out.write("    1. 이 약관에서 사용하는 용어의 정의는 다음과 같습니다.\n");
      out.write("    <br>\n");
      out.write("    1) 회원: 회사에 개인정보를 제공하여 회원등록을 한 개인 또는 법인입니다\n");
      out.write("    <br>\n");
      out.write("    2) 아이디(ID): 회원의 식별과 서비스 이용을 위하여 회원이 설정하고 회사가 승인하여 등록된 문자와 숫자의 조합을 말합니다.\n");
      out.write("    <br>\n");
      out.write("    3) 비밀번호: 회원의 동일성 확인과 회원의 권익 및 비밀보호를 위하여 회원 스스로가 설정하여 회사에 등록한 영문과 숫자의 조합을 말합니다.\n");
      out.write("    <br>\n");
      out.write("    4) 운영자: 회사가 제공하는 서비스의 전반적인 관리와 원활한 운영을 위하여 회사에서 선정한 자를 말합니다..\n");
      out.write("    <br><br>\n");
      out.write("    제4조 (서비스의 종류)<br>\n");
      out.write("    1. 회사가 제공하는 서비스는 다음과 같습니다.<br>\n");
      out.write("    1) 칵테일 정보 제공<br>\n");
      out.write("    2) 기타 회사가 정하는 서비스 또는 업무<br>\n");
      out.write("    \n");
      out.write("    <br><br>\n");
      out.write("    제5조 (서비스의 중단)<br>\n");
      out.write("    1. 회사는 천재지변 또는 이에 준하는 불가항력, 컴퓨터 등 정보통신설비의 보수점검•교체, 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을 일시적으로 중단할 수 있습니다.<br>\n");
      out.write("    2. 회사는 제1항의 사유로 서비스의 제공이 일시적으로 중단됨으로 인하여 회원이 입은 손해에 대하여 배상합니다. 단, 회사가 고의 또는 과실이 없음을 입증하는 경우에는 그러하지 아니합니다.<br>\n");
      out.write("    3. 사업 종목의 전환, 사업의 종료 또는 포기, 회사의 폐업, 합병, 분할, 영업양도 등의 이유로 서비스를 제공할 수 없게 되는 경우에는 회사가 정한 방법으로 회원에게 통지합니다.<br>\n");
      out.write("    <br><br>\n");
      out.write("    제6조 (이용계약의 성립)<br>\n");
      out.write("    1. 서비스 이용계약은 회사가 정한 가입 양식에 따라 회원정보(전자우편주소, 비밀번호, 닉네임 등)를 기입하여 회원가입신청을 하고 회사가 이러한 신청에 대하여 승인함으로써 체결됩니다.<br>\n");
      out.write("    2. 회원가입은 만 19세 이상의 성인만 할 수 있으며, 이용신청자는 실명으로 가입신청을 해야 하며, 실명이 아니거나 타인의 정보를 도용하는 경우 서비스이용이 제한되거나 관련 법령에 의거 처벌받을 수 있습니다.<br>\n");
      out.write("    3. 판매회원의 경우에는 전통주 판매권한을 득한 회원이 회사가 정한 절차에 따라 정보를 기입하여 판매회원 신청을 하고 회사가 신청을 승인하면 판매회원으로서 서비스를 이용할 수 있습니다.<br>\n");
      out.write("    4. 이용신청의 처리는 신청순서에 의하며, 회원가입의 성립시기는 회사의 승낙이 회원에게 도달한 시점으로 합니다.<br>\n");
      out.write("    5. 회사는 다음과 같은 사유가 발생한 경우 이용신청에 대한 승낙을 거부하거나 유보할 수 있습니다.<br>\n");
      out.write("    1) 회사의 실명확인절차에서 실명가입신청이 아님이 확인된 경우<br>\n");
      out.write("    2) 이미 가입된 회원과 이름 및 주민등록번호(또는 사업자등록번호)가 동일한 경우<br>\n");
      out.write("    3) 회사에 의하여 이용계약이 해지된 날로부터 2개월 이내에 재이용신청을 하는 경우<br>\n");
      out.write("    4) 회사로부터 회원자격 정지 조치 등을 받은 회원이 그 조치기간 중에 이용계약을 임의 해지하고 재이용신청을 하는 경우<br>\n");
      out.write("    <br>5) 기타 이 약관에 위배되거나 위법 또는 부당한 이용신청임이 확인된 경우 및 회사가 합리적인 판단에 의하여 필요하다고 인정하는 경우\n");
      out.write("    <br>6. 타인의 개인정보를 도용하는 등 부정한 목적 또는 방법으로 이용신청을 한 회원의 ID는 사전 통지 없이 이용 계약이 해지될 수 있으며, 당해 회원은 관계법령에 따라 처벌을 받을 수 있습니다.\n");
      out.write("    <br><br>\n");
      out.write("    제7조 (개인정보의 변경, 보호)\n");
      out.write("    <br>1. 회원은 이용신청 시 허위의 정보를 제공하여서는 아니 되며, 기재한 사항이 변경되었을 경우에는 즉시 변경사항을 최신의 정보로 수정하여야 합니다. 이름, ID, 주민등록번호 등은 수정할 수 없으나 법령에 의한 경우는 예외적으로 수정 가능합니다.\n");
      out.write("    <br>2. 회사의 회원에 대한 통지는 회원이 제공한 주소 또는 e-mail주소에 도달하거나 회원이 제공한 휴대폰번호에 알림톡 등 전자적 안내방법으로 도달함으로써 통지된 것으로 보며, 수정하지 않은 정보로 인하여 발생하는 손해는 당해 회원이 전적으로 부담하며, 회사는 이에 대하여 아무런 책임을 지지 않습니다.\n");
      out.write("    <br>3. 회사는 이용계약을 위하여 회원이 제공한 정보를 회원이 동의한 회사 서비스 운영을 위한 목적 이외의 용도로 사용할 수 없으며, 새로운 이용목적이 발생한 경우 또는 제3자에게 제공하는 경우에는 이용•제공단계에서 당해 회원에게 그 목적을 고지하고 동의를 받습니다. 다만, 관련 법령에 달리 정함이 있는 경우에는 예외로 합니다.\n");
      out.write("    <br>4. 회사는 회원의 개인정보를 보호하기 위해 제3자에게 구매회원의 개인정보를 제공할 필요가 있는 경우에는 실제 청약시에 제공되는 개인정보 항목, 제공받는 자, 제공받는 자의 개인정보 이용목적 및 보유•이용기간 등을 명시하여 구매회원의 동의를 받고, 개인정보를 위탁하는 경우에는 관련 법령이 정하는 바에 따라 \"개인정보처리방침\"을 수립하고 개인정보 보호 책임자를 지정하여 이를 게시하고 운영합니다.\n");
      out.write("    <br><br>\n");
      out.write("    제8조 (아이디 및 비밀번호의 관리)\n");
      out.write("    <br>1. 아이디(ID) 및 비밀번호에 대한 관리책임은 회원에게 있으며, 회원은 어떠한 경우에도 본인의 아이디(ID) 또는 비밀번호를 타인에게 양도하거나 대여할 수 없습니다.\n");
      out.write("    <br>2. 회사의 귀책사유 없이 아이디(ID) 또는 비밀번호의 유출, 양도, 대여로 인하여 발생하는 손실이나 손해에 대하여는 회원 및 이용자 본인이 그에 대한 책임을 부담합니다.\n");
      out.write("    <br>3. 회원은 아이디(ID) 또는 비밀번호를 도난당하거나 제3자가 무단으로 이를 사용하고 있음을 인지한 경우, 이를 즉시 회사에 통보하여야 하고 회사는 이에 대한 신속한 처리를 위하여 최선의 노력을 다하여야 합니다.\n");
      out.write("    <br><br>\n");
      out.write("    제9조 (이용계약의 종료)\n");
      out.write("    <br>1. 회원의 해지\n");
      out.write("    <br>1) 회원은 언제든지 해당 서비스화면을 통하여 회사에게 해지의사를 통지함으로써 이용계약을 해지할 수 있습니다. 다만, 회원은 해지의사를 통지하기 최소한 7일 전에 모든 거래를 완결시키는데 필요한 조치를 취하여야만 합니다.\n");
      out.write("    <br>2) 전호의 기간 내에 회원이 발한 의사표시로 인해 발생한 불이익에 대한 책임은 회원 본인이 부담하여야 하며, 이용계약이 종료되면 회사는 회원에게 부가적으로 제공한 각종 혜택을 회수할 수 있습니다.\n");
      out.write("    <br>3) 회원의 의사로 이용계약을 해지한 후, 추후 재이용을 희망할 경우에는 재이용 의사가 회사에 통지되고, 이에 대한 회사의 승낙이 있는 경우에만 서비스 재이용이 가능합니다.\n");
      out.write("    <br>2. 회사의 해지\n");
      out.write("    <br>1) 회사는 다음과 같은 사유가 발생하거나 확인된 경우 이용계약을 해지할 수 있습니다\n");
      out.write("    <br>① 다른 회원 또는 타인의 권리나 명예, 신용 기타 정당한 이익을 침해하거나 대한민국 법령 또는 공서양속에 위배되는 행위를 한 경우\n");
      out.write("    <br>② 회사가 제공하는 서비스의 원활한 진행을 방해하는 행위를 하거나 시도한 경우\n");
      out.write("    <br>③ 제6조 제5항의 승낙거부사유가 있거나 제25조 제3항의 이용계약의 해지사유에 해당하는 경우\n");
      out.write("    <br>④ 기타 회사가 합리적인 판단에 기하여 서비스의 제공을 거부할 필요가 있다고 인정할 경우\n");
      out.write("    <br>2) 회사가 해지를 하는 경우 회사는 회원에게 e-mail, SMS, 기타의 방법을 통하여 해지사유를 밝혀 해지의사를 통지합니다. 이용계약은 회사의 해지의사를 회원에게 통지한 시점에 종료됩니다.\n");
      out.write("    <br>3) 본 항에 의하여 회사가 이용계약을 해지하더라도, 해지 이전에 이미 체결된 매매계약의 완결과 관련해서는 이 약관이 계속 적용됩니다.\n");
      out.write("    <br>4) 본 항에서 정한 바에 따라 이용계약이 종료될 시에는 회사는 회원에게 부가적으로 제공한 각종 혜택을 회수할 수 있습니다.\n");
      out.write("    <br>5) 본 항에서 정한 바에 따라 이용계약이 종료된 경우에는, 회원의 재이용신청에 대하여 회사는 이에 대한 승낙을 거절할 수 있습니다.\n");
      out.write("    <br>3. 회사는 회원이 1년 이상 로그인 하지 않으면, 휴면계정으로 간주하고 회사가 제공하는 서비스 이용을 제한할 수 있습니다. 휴면계정으로 지정된 이후 다시 서비스를 이용하려면 거래안전을 위해 회사가 정하는 본인확인 절차 등을 이행하여야 합니다.\n");
      out.write("    <br><br>\n");
      out.write("    제10조 (서비스기간과 중단)\n");
      out.write("    <br>1. 본 약관에 따른 서비스 기간은 서비스 신청일로부터 이용계약의 해지 시까지 입니다.\n");
      out.write("    <br>2. 회사는 컴퓨터 등 정보통신설비의 보수, 점검, 교체 및 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을 일시적으로 중단할 수 있습니다. 이 경우 서비스 일시 중단 사실과 그 사유를 초기화면에 통지합니다.\n");
      out.write("    <br>3. 회사는 천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스의 제공을 제한하거나 일시 중단할 수 있습니다.\n");
      out.write("    <br><br>\n");
      out.write("    <br>제11조 (게시물에 대한 책임)\n");
      out.write("    <br>1. 회사는 회원이 게시하거나 전달하는 서비스 내의 게시물이 다음 각 호의 경우에 해당한다고 판단되는 경우 사전 통지 없이 삭제할 수 있으며, 이에 대해 회사는 어떠한 책임도 지지 않습니다.\n");
      out.write("    <br>1) 회사, 다른 회원 또는 제3자를 비방하거나 중상모략으로 명예를 손상시키는 내용인 경우\n");
      out.write("    <br>2) 공공질서 및 미풍양속에 위반되는 내용의 게시물에 해당하는 경우\n");
      out.write("    <br>3) 범죄 행위에 결부된다고 인정되는 내용인 경우\n");
      out.write("    <br>4) 회사 또는 제3자의 저작권, 기타 타인의 권리를 침해하는 내용인 경우\n");
      out.write("    <br>5) 회사가 정한 개별 서비스 별 세부이용지침에 반하는 내용인 경우\n");
      out.write("    <br>6) 회사에서 제공하는 서비스와 관련 없는 내용인 경우\n");
      out.write("    <br>7) 불필요하거나 승인되지 않은 광고, 판촉물을 게재하는 경우\n");
      out.write("    <br>8) 타인의 명의 등을 무단으로 도용하여 작성한 내용이거나, 타인이 입력한 정보를 무단으로 위ㆍ변조한 내용인 경우\n");
      out.write("    <br>9) 동일한 내용을 중복하여 다수 게시하는 등 게시의 목적에 어긋나는 경우\n");
      out.write("    <br>10) 게시물의 정보를 외부 서비스에서 사용하는 행위를 금지하는 사이트에서 URL 정보를 수집하여 게재하는 경우\n");
      out.write("    <br>11) 기타 관계 법령 및 회사의 개별 서비스 별 세부이용지침 등에 위반된다고 판단되는 경우\n");
      out.write("    <br>2. 회사는 개별 서비스 별로 게시물과 관련된 세부이용지침을 별도로 정하여 시행할 수 있으며, 회원은 그 지침에 따라 게시물(회원간 전달 포함)을 게재하여야 합니다.\n");
      out.write("    <br>3. 회사는 회원 간의 자유로운 전자상거래에 있어서 필요로 하는 각종 서비스를 제공하고 회사의 내부 정책에 따라 그에 대한 이용료(서비스 이용료)를 부과할 수 있습니다.\n");
      out.write("    <br><br>\n");
      out.write("    제12조 (게시물의 저작권 등)\n");
      out.write("    <br>1. 회원이 서비스 내에 게시한 게시물의 저작권은 저작권법에 의해 보호를 받으며, 회사가 작성한 저작물에 대한 저작권 및 기타 지적재산권은 회사에 귀속합니다.\n");
      out.write("    <br>2. 회사는 서비스와 관련하여 회원에게 회사가 정한 이용조건에 따라 계정, 아이디, 콘텐츠 등을 이용할 수 있는 이용권한만을 부여하며, 회원 및 서비스 이용자는 서비스를 이용함으로써 얻은 정보 중 회사에게 지식재산권이 귀속된 정보를 회사의 사전 승낙 없이 복제, 송신, 전송, 출판, 배포, 방송 기타 방법에 의하여 영리 목적으로 이용하거나 제3자에게 이용하게 하여서는 안됩니다.\n");
      out.write("    <br>3. 회원은 자신이 서비스 내에 게시한 게시물을 회사가 국내ㆍ외에서 다음 각 호의 목적으로 사용하는 것을 허락합니다.\n");
      out.write("    <br>1) 서비스(제3자가 운영하는 사이트 또는 미디어의 일정 영역 내에 입점하여 서비스가 제공되는 경우 포함) 내에서 게시물을 사용하기 위하여 게시물의 크기를 변환하거나 단순화하는 등의 방식으로 수정하는 것\n");
      out.write("    <br>2) 회사 또는 관계사가 운영하는 본 서비스 및 연동 서비스 에 게시물을 복제ㆍ전송ㆍ전시하는 것. 다만, 회원이 게시물의 복제ㆍ전송ㆍ전시에 반대 의견을 e-mail을 통해 관리자에게 통지할 경우에는 그러하지 않습니다.\n");
      out.write("    <br>3) 회사의 서비스를 홍보하기 위한 목적으로 미디어, 소셜미디어를 포함한 디지털 마케팅 채널, 통신사 등에게 게시물의 내용을 보도, 방영하게 하는 것.\n");
      out.write("    <br>4. 전 항의 규정에도 불구하고, 회사가 게시물을 전 항 각 호에 기재된 목적 이외에 제3자에게 게시물을 제공하고 금전적 대가를 지급받는 경우에는 사전에 전화, e-mail 등의 방법으로 회원의 동의를 얻습니다. 이 경우 회사는 회원에게 별도의 보상을 제공합니다.\n");
      out.write("    <br>5. 회원이 서비스에 게시물을 게재하는 것은 다른 회원이 게시물을 서비스 내에서 사용하거나, 회사가 검색결과로 사용하는 것을 허락한 것으로 봅니다. 그리고 스마트폰, 태블릿 PC의 서비스 이용자(앱 또는 브라우저로 서비스를 비가입 방문한 경우도 포함)가 소프트웨어(예: 앱, 브라우저) 또는 하드웨어(예: 스마트폰, 태블릿PC)에서 제공하는 기능을 이용하여 게시물을 저장한 후 활용하는 것을 허락한 것으로 봅니다.\n");
      out.write("    <br>6. 제9조에 의해 이용계약이 해지되는 경우 공개된 게시판에 작성한 게시물 등은 삭제되지 않으며 삭제를 원할 경우 본인이 직접 삭제 후 탈퇴하여야 합니다.\n");
      out.write("    <br>7. 회사는 서비스 운영정책상 또는 회사가 운영하는 사이트간의 통합 등을 하는 경우 게시물의 내용을 변경하지 아니하고 게시물의 게재 위치를 변경ㆍ이전하거나 사이트간 공유로 하여 서비스할 수 있습니다. 다만, 게시물의 이전ㆍ변경 또는 공유를 하는 경우에는 사전에 공지합니다\n");
      out.write("    <br><br>\n");
      out.write("    \n");
      out.write("    제13조 (이용자 관리)\n");
      out.write("    <br>1. 회사는 이 약관의 본지와 관련 법령 및 상거래의 일반원칙을 위반한 회원에 대하여 다음과 같은 조치를 할 수 있습니다.\n");
      out.write("    <br>1) 회사가 부가적으로 제공한 혜택의 일부 또는 전부의 회수\n");
      out.write("    <br>2) 특정서비스 이용제한\n");
      out.write("    <br>3) 이용계약의 해지\n");
      out.write("    <br>4) 손해배상의 청구\n");
      out.write("    <br>2. 회사가 전항 각 호에 정한 조치를 할 경우 회사는 사전에 회원에게 유선 또는 e-mail로 통보하며, 회원의 연락이 두절되거나 긴급을 요하는 것과 같이 부득이한 경우 선조치 후 사후 통보할 수 있습니다.\n");
      out.write("    <br>3. 회원은 본조에 의한 회사의 조치에 대하여 항변의 사유가 있는 경우 이에 대하여 항변을 할 수 있습니다.\n");
      out.write("    <br><br>\n");
      out.write("    \n");
      out.write("    제14조 (저작물 책임)\n");
      out.write("    <br>1. 회사는 서비스를 이용함에 있어 저작권자의 저작권 보호를 위한 정책을 수립하여 운영하며 회원은 회사의 저작권 정책을 준수하여야 합니다.\n");
      out.write("    <br>2. 회원이 회사가 제공하는 서비스를 이용하면서 작성한 각종 게시물의 저작권은 이를 작성한 회원 본인에게 있으며, 해당 게시물이 타인의 저작권을 침해하는 경우 그에 대한 책임은 회원 본인이 부담합니다.\n");
      out.write("    <br>3. 회사는 게시물이 다음 각 호에 해당하는 경우 사전 통보 없이 해당 게시물을 삭제하거나 게시자에 대하여 특정서비스의 이용제한, 이용계약의 해지 등의 조치를 할 수 있습니다.\n");
      out.write("    <br>1) 타인을 모욕, 비방, 비하하거나 타인의 명예를 훼손하는 게시물\n");
      out.write("    <br>2) 범죄 및 불법 행위에 악용될 수 있는 정보를 담고 있는 게시물\n");
      out.write("    <br>3) 타인의 저작권, 상표권 등 권리를 침해하는 게시물\n");
      out.write("    <br>4) 음란물 또는 일반인의 성적 굴욕감이나 수치심을 유발할 수 있는 내용의 게시물(그러한 내용이 담긴 웹사이트, 앱 등으로 연결될 수 있는 게시물을 포함)\n");
      out.write("    <br>5) 특정인의 개인정보가 노출된 게시물\n");
      out.write("    <br>6) 정치, 경제, 이념적 분쟁을 야기하는 내용을 포함하는 게시물\n");
      out.write("    <br>7) 특정 상품 등을 소개하여 판매하거나, 이를 구매, 사용하도록 권하거나 연락을 유도하는 등 직간접적으로 영리추구를 위한 내용을 담고 있는 게시물\n");
      out.write("    <br>8) 이용 목적에 부합하지 않거나 해당 서비스의 취지와 무관한 내용의 게시물\n");
      out.write("    <br>9) 악성코드나 스파이웨어 등이 실행되어 다른 회원, 회사, 판매자 기타 제3자의 시스템 성능 저하, 개인정보 유출 등의 피해를 줄 수 있는 악의적인 코드를 담고 있는 게시물\n");
      out.write("    <br>10) 정당한 사유 없이 회사가 제공하는 백술닷컴 서비스의 원활한 진행을 방해하는 내용의 게시물\n");
      out.write("    <br>11) 기타 이 약관 또는 법령에 위배되거나 공서양속에 반하는 내용의 게시물\n");
      out.write("    <br>4. 회원이 작성한 각종 게시물은 회사가 제휴한 타사이트에 복제, 배포, 전송, 전시 될 수 있으며, 본질적인 내용에 변경을 가하지 않는 범위 내에서 수정, 편집될 수 있습니다.\n");
      out.write("    <br><br>\n");
      out.write("    제15조 (게시물의 관리)\n");
      out.write("    <br>1. 회원의 게시물이 『정보통신망 이용촉진 및 정보보호 등에 관한 법률』, 『개인정보 보호법』 및 『저작권법』등 관련 법령에 위반되는 내용을 포함하는 경우, 권리자는 관련 법령이 정한 절차에 따라 해당 게시물의 게시중단 및 삭제 등을 요청할 수 있으며, 회사는 관련 법령에 따라 조치를 취하여야 합니다.\n");
      out.write("    <br>2. 회사는 전항에 따른 권리자의 요청이 없는 경우라도 권리침해가 인정될 만한 사유가 있거나 기타 회사 정책 및 관련 법령에 위반되는 경우에는 관련 법령에 따라 해당 게시물에 대해 임시조치 등을 취할 수 있습니다.\n");
      out.write("    <br>3. 세부절차는 『정보통신망 이용촉진 및 정보보호 등에 관한 법률』, 『개인정보 보호법』 및 『저작권법』등 관련 법령이 규정한 범위 내에서 회사가 정한 게시중단요청서비스에 따릅니다.\n");
      out.write("    <br><br>\n");
      out.write("    \n");
      out.write("    제16조 (회사의 면책)\n");
      out.write("    <br>1. 회사는 통신판매중개자로서 백술닷컴을 기반으로 한 거래시스템만을 제공할 뿐이며, 백술닷컴의 거래시스템을 이용한 거래 내용에 관한 모든 분쟁에 대해서는 당해 거래 당사자가 책임을 져야 합니다.\n");
      out.write("    <br>2. 회사는 천재지변, 디도스(DDOS)공격, IDC장애, 기간통신사업자의 회선 장애 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이 면제됩니다.\n");
      out.write("    <br>3. 회사는 회원의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다.\n");
      out.write("    <br>4. 회사는 회원이 게재한 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 관해서는 책임을 지지 않습니다.\n");
      out.write("    <br>5. 회사는 회원의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다.\n");
      out.write("    <br>6. 회사는 무료로 제공되는 서비스 이용과 관련하여 관련 법령에 특별한 규정이 없는 한 책임을 지지 않습니다.\n");
      out.write("    <br>7. 회원이 자신의 개인정보를 타인에게 유출 또는 제공함으로써, 발생하는 피해에 대해서 회사는 일체의 책임을 지지 않습니다.\n");
      out.write("    <br><br>\n");
      out.write("    제18조 (관할법원)\n");
      out.write("    <br>이 약관과 이용계약 및 회원 상호간의 분쟁에 대해 회사를 당사자로 하는 소송이 제기될 경우에는 회사의 본사 소재지를 관할하는 법원을 합의관할법원으로 정합니다.\n");
      out.write("    <br><br>\n");
      out.write("    제19조 (재판권 및 준거법)\n");
      out.write("    <br>1. 이 약관의 해석 및 회사와 회원 간의 분쟁에 대하여는 대한민국의 법률을 적용합니다.\n");
      out.write("    <br>2, 이 약관 및 서비스 이용과 관련하여 회사와 회원 사이에 분쟁이 발생하여 소송이 제기되는 경우에는 『민사소송법』에 따라 관할법원을 정합니다.\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"check-area\">\n");
      out.write("                    \n");
      out.write("                    <input type=\"checkbox\" name=\"checkbox\" value=\"inforYes\">\n");
      out.write("                    <label><span class=\"blue\">(필수)</span>개인정보 수집 및 이용 </label>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div id=\"scroll-box\">\n");
      out.write("                    <p>\n");
      out.write("    회사는 회원가입, 민원 등 고객상담 처리, 본인확인(19세 미만 아동 및 청소년 확인) 등 의사소통을 위한 정보 활용 및 이벤트 등과 같은 마케팅용도 활용, 회원의 서비스 이용에 대한 통계, 이용자들의 개인정보를 통한 서비스 개발을 위해 아래와 같은 개인정보를 수집하고 있습니다.\n");
      out.write("    <br><br>\n");
      out.write("    <br>1. - 목적 : 이용자 식별 및 본인여부 확인\n");
      out.write("    <br>- 항목 : 이름, 아이디, 비밀번호,닉네임, 이메일, 휴대폰번호, 주소, 전화번호 등\n");
      out.write("    <br>- 보유 및 이용기간 : 회원탈퇴 후 5일까지\n");
      out.write("    <br><br>\n");
      out.write("    <br>2. – 목적 : 민원 등 고객 고충처리\n");
      out.write("    <br>- 항목 : 이름, 아이디, 이메일, 휴대폰번호, 전화번호, 주소, 구매자정보,결제정보,상품 구매/취소/교환/반품/환불 정보, 수령인정보\n");
      out.write("    <br>- 보유 및 이용기간 : 회원탈퇴 후 5일까지\n");
      out.write("    <br><br>\n");
      out.write("    <br>3. – 목적 : 만 19세 미만 아동 및 청소년 확인\n");
      out.write("    <br>- 항목 : 법정 생년월일\n");
      out.write("    <br>- 보유 및 이용기간 : 회원탈퇴 후 5일까지\n");
      out.write("    <br><br>\n");
      out.write("    <br>이용자의 개인정보는 원칙적으로 개인정보의 수집 및 이용 목적 달성 시 지체없이 파기합니다. 다만 다른 법령에서 별도의 기간을 정하고 있는 경우나 이용자의 요청에 따라 기간을 달리 정한 경우에는 그 기간이 경과한 후 파기 등의 필요한 조치를 취합니다.\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"btn-area\">\n");
      out.write("                   <form action=\"signUp\" method=\"get\" onsubmit=\"return nextBtn()\">\n");
      out.write("                       \n");
      out.write("                     <button id=\"next-btn\">다음</button>\n");
      out.write("                   </form>\n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("    \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/join-terms.js\"></script>");
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
