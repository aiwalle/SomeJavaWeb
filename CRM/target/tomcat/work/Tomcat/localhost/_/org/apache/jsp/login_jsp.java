/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-19 02:13:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>小码哥客户关系管理系统</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/style.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/jquery-easyui/jquery.min.js\"></script> <!-- jQuery核心库 -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        // 提交登录账号和密码:把账号和密码传递到后台\r\n");
      out.write("        function submitForm() {\r\n");
      out.write("            console.log($(\"form\").serialize());\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                type: \"POST\",\r\n");
      out.write("                url: \"/login\",\r\n");
      out.write("                dataType: \"json\",\r\n");
      out.write("                data: $(\"form\").serialize(),\r\n");
      out.write("                success: function(data){\r\n");
      out.write("                   if(data.success){\r\n");
      out.write("//                        window.location.href=\"/index\";\r\n");
      out.write("                   }else{\r\n");
      out.write("//                       $.messager.alert(\"温馨提示\",data.msg,\"warning\");\r\n");
      out.write("                       alert(\"温馨提示\",data.msg,\"warning\");\r\n");
      out.write("                   }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("        // 清除账号和密码\r\n");
      out.write("        function resetForm() {\r\n");
      out.write("            $(\"form\").form(\"clear\");\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header id=\"header\" class=\"\">\r\n");
      out.write("    <h1><img src=\"img/logo.png\" alt=\"\"><span>CRM</span></h1>\r\n");
      out.write("    <ul>\r\n");
      out.write("        <li><a href=\"#\">核心功能</a></li>\r\n");
      out.write("        <li><a href=\"#\">版本与价格</a></li>\r\n");
      out.write("        <li><a href=\"#\">拓展与集成</a></li>\r\n");
      out.write("        <li><a href=\"#\">行业客户</a></li>\r\n");
      out.write("        <li><a href=\"#\">关于我们</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</header><!-- /header -->\r\n");
      out.write("<div id=\"con\">\r\n");
      out.write("    <div class=\"left\">\r\n");
      out.write("        <h2>张小猪CRM管理系统</h2>\r\n");
      out.write("        <p>来自张小猪的在线CRM客户关系管理软件,帮助全球5万+企业管理客户数据,销售过程,营销活动以及服务支持,并能够与丰富第三方应用无缝集成,满足业务运营所需<span>开源,无限期使用!</span></p>\r\n");
      out.write("        <div class=\"icon\">\r\n");
      out.write("            <dl>\r\n");
      out.write("                <dt><img src=\"img/1.png\" alt=\"\"></dt>\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <h3>小码哥CRM管理系统</h3>\r\n");
      out.write("                    <p>CRM Magazine</p>\r\n");
      out.write("                    <p>全球最具权威的CRM媒体平台</p>\r\n");
      out.write("                </dd>\r\n");
      out.write("            </dl>\r\n");
      out.write("            <dl>\r\n");
      out.write("                <dt><img src=\"img/2.png\" alt=\"\"></dt>\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <h3>CRM领导者</h3>\r\n");
      out.write("                    <p>G2Crowd</p>\r\n");
      out.write("                    <p>独立商用软件评测机构</p>\r\n");
      out.write("                </dd>\r\n");
      out.write("            </dl>\r\n");
      out.write("            <dl>\r\n");
      out.write("                <dt>Gartner</dt>\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <h3>CRM线索管理工具象限</h3>\r\n");
      out.write("                    <p>Gartner</p>\r\n");
      out.write("                    <p>全球最具权威的CRM媒体平台</p>\r\n");
      out.write("                </dd>\r\n");
      out.write("            </dl>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <form method=\"post\">\r\n");
      out.write("        <div class=\"right\">\r\n");
      out.write("            <input type=\"text\" name=\"username\" placeholder=\"请输入用户名\">\r\n");
      out.write("            <input type=\"password\" name=\"password\" placeholder=\"请输入密码\">\r\n");
      out.write("            <input type=\"button\" value='登录' onclick=\"submitForm();\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("<footer id=\"footer\">\r\n");
      out.write("    <p>吸引,维护并取悦您的客户,实现\"以客户为中心\"的成功转型</p>\r\n");
      out.write("    <div class=\"detail\">\t\r\n");
      out.write("        <dl>\r\n");
      out.write("            <dt>销售过程管理</dt>\r\n");
      out.write("            <dd>从分配线索,跟踪商机,发送保价到最后成交,全面监督整个销售过程,并关注重要交易</dd>\r\n");
      out.write("        </dl>\r\n");
      out.write("        <dl>\r\n");
      out.write("            <dt>客户数据管理</dt>\r\n");
      out.write("            <dd>从分配线索,跟踪商机,发送保价到最后成交,全面监督整个销售过程,并关注重要交易</dd>\r\n");
      out.write("        </dl>\r\n");
      out.write("        <dl>\r\n");
      out.write("            <dt>市场营销管理</dt>\r\n");
      out.write("            <dd>从分配线索,跟踪商机,发送保价到最后成交,全面监督整个销售过程,并关注重要交易</dd>\r\n");
      out.write("        </dl>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
