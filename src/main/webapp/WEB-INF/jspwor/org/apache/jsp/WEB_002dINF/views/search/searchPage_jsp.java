/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-25 13:42:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.search;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searchPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1689072618969L));
    _jspx_dependants.put("jar:file:/C:/Users/jy041/Documents/SemiProject/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/C:/Users/jy041/Documents/SemiProject/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>검색 조회</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/main-style.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/search.css\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/a5af36132e.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.7.0.min.js\"\r\n");
      out.write("	integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div id=\"content\">\r\n");
      out.write("		\r\n");
      out.write("		<section class=\"result_search\">\r\n");
      out.write("			<h4 class=\"block\">검색결과</h4>\r\n");
      out.write("			<div class=\"box_search_new\">\r\n");
      out.write("				<div class=\"search_area\">\r\n");
      out.write("					<form action=\"#\" method=\"get\" name=\"search\" class=\"search\">\r\n");
      out.write("						<input type=\"search\" name=\"keyword\" id=\"keyword\"> <a\r\n");
      out.write("							href=\"#\" class=\"search_icon\"> <img\r\n");
      out.write("							src=\"https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/skin/front/pub/images/common/icon_magnifier.png\"\r\n");
      out.write("							alt=\"\">\r\n");
      out.write("						</a>\r\n");
      out.write("					</form>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"popular_keyword\">\r\n");
      out.write("					<strong>인기검색어</strong>\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li><a href=\"#\"><span>#여름밤</span></a></li>\r\n");
      out.write("						<li><a href=\"#\"><span>#과일맛</span></a></li>\r\n");
      out.write("						<li><a href=\"#\"><span>#커피맛</span></a></li>\r\n");
      out.write("						<li><a href=\"#\"><span>#산뜻한</span></a></li>\r\n");
      out.write("\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<p class=\"txt_result\">\r\n");
      out.write("				검색하신 <span>“<em>칵테일</em>”\r\n");
      out.write("				</span> 에 대한 #개의 검색 결과가 있습니다.\r\n");
      out.write("			</p>\r\n");
      out.write("			<div class=\"cocktail_pick_list\">\r\n");
      out.write("				<span class=\"pick_list_num\"> 칵테일 정보( <strong>3</strong> )\r\n");
      out.write("				</span>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"list_prd\">\r\n");
      out.write("				<ul class=\"list-shop\">\r\n");
      out.write("					<div class=\"list_prd\">\r\n");
      out.write("						<ul class=\"list-shop\">\r\n");
      out.write("							<li><a href=\"#\">\r\n");
      out.write("									<div class=\"box_img\">\r\n");
      out.write("\r\n");
      out.write("										<img\r\n");
      out.write("											src=\"https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg\"\r\n");
      out.write("											style=\"width: 382px\">\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"txt_box\">\r\n");
      out.write("										<p class=\"name cocktail\">서울의 밤</p>\r\n");
      out.write("										<p class=\"exple_bow\"\r\n");
      out.write("											style=\"margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;\">매실향\r\n");
      out.write("											짙은 한국형 진</p>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"box_absol\"></div>\r\n");
      out.write("							</a></li>\r\n");
      out.write("							<li><a href=\"#\">\r\n");
      out.write("									<div class=\"box_img\">\r\n");
      out.write("\r\n");
      out.write("										<img\r\n");
      out.write("											src=\"https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg\"\r\n");
      out.write("											style=\"width: 382px\">\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"txt_box\">\r\n");
      out.write("										<p class=\"name cocktail\">서울의 밤</p>\r\n");
      out.write("										<p class=\"exple_bow\"\r\n");
      out.write("											style=\"margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;\">매실향\r\n");
      out.write("											짙은 한국형 진</p>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"box_absol\"></div>\r\n");
      out.write("							</a></li>\r\n");
      out.write("							<li><a href=\"#\">\r\n");
      out.write("									<div class=\"box_img\">\r\n");
      out.write("\r\n");
      out.write("										<img\r\n");
      out.write("											src=\"https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg\"\r\n");
      out.write("											style=\"width: 382px\">\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"txt_box\">\r\n");
      out.write("										<p class=\"name cocktail\">서울의 밤</p>\r\n");
      out.write("										<p class=\"exple_bow\"\r\n");
      out.write("											style=\"margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;\">매실향\r\n");
      out.write("											짙은 한국형 진</p>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"box_absol\"></div>\r\n");
      out.write("							</a></li>\r\n");
      out.write("							<li><a href=\"#\">\r\n");
      out.write("									<div class=\"box_img\">\r\n");
      out.write("\r\n");
      out.write("										<img\r\n");
      out.write("											src=\"https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg\"\r\n");
      out.write("											style=\"width: 382px\">\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"txt_box\">\r\n");
      out.write("										<p class=\"name cocktail\">서울의 밤</p>\r\n");
      out.write("										<p class=\"exple_bow\"\r\n");
      out.write("											style=\"margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;\">매실향\r\n");
      out.write("											짙은 한국형 진</p>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"box_absol\"></div>\r\n");
      out.write("							</a></li>\r\n");
      out.write("							<li><a href=\"#\">\r\n");
      out.write("									<div class=\"box_img\">\r\n");
      out.write("\r\n");
      out.write("										<img\r\n");
      out.write("											src=\"https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg\"\r\n");
      out.write("											style=\"width: 382px\">\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"txt_box\">\r\n");
      out.write("										<p class=\"name cocktail\">서울의 밤</p>\r\n");
      out.write("										<p class=\"exple_bow\"\r\n");
      out.write("											style=\"margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;\">매실향\r\n");
      out.write("											짙은 한국형 진</p>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"box_absol\"></div>\r\n");
      out.write("							</a></li>\r\n");
      out.write("							\r\n");
      out.write("						</ul>\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div class=\"cocktail_pick_list\">\r\n");
      out.write("				<span class=\"pick_list_num\"> 커뮤니티 ( <strong>5</strong> )\r\n");
      out.write("				</span>\r\n");
      out.write("				<br>\r\n");
      out.write("				<div class=\"cocktail_pick_list2\">\r\n");
      out.write("					<table class=\"list-table\">\r\n");
      out.write("						<thead>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<th>글번호</th>\r\n");
      out.write("								<th>제목</th>\r\n");
      out.write("								<th>작성자</th>\r\n");
      out.write("								<th>작성일</th>\r\n");
      out.write("								<th>조회수</th>\r\n");
      out.write("							</tr>\r\n");
      out.write("						</thead>\r\n");
      out.write("						<tbody>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("						</tbody>\r\n");
      out.write("					</table>\r\n");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"cocktail_pick_list\">\r\n");
      out.write("				<span class=\"pick_list_num\"> 믹스올로지 컬럼 ( <strong>1</strong> )\r\n");
      out.write("				</span>\r\n");
      out.write("				<br>\r\n");
      out.write("				<div class=\"cocktail_pick_list2\">\r\n");
      out.write("					<table class=\"list-table\">\r\n");
      out.write("						<thead>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<th>글번호</th>\r\n");
      out.write("								<th>제목</th>\r\n");
      out.write("								<th>작성자</th>\r\n");
      out.write("								<th>작성일</th>\r\n");
      out.write("								<th>조회수</th>\r\n");
      out.write("							</tr>\r\n");
      out.write("						</thead>\r\n");
      out.write("						<tbody>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>10</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<a href=\"#\">10번째글</a>\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>유저일</td>\r\n");
      out.write("								<td>2023-07-17</td>\r\n");
      out.write("								<td>50</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("						</tbody>\r\n");
      out.write("					</table>\r\n");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		</section>\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	");
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
