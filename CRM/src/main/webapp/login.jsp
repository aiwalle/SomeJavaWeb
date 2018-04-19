<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码哥客户关系管理系统</title>
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" src="/js/jquery-easyui/jquery.min.js"></script> <!-- jQuery核心库 -->
    <%--<%@include file="/WEB-INF/views/common.jsp"%>--%>
    <script type="text/javascript">
        // 提交登录账号和密码:把账号和密码传递到后台
        function submitForm() {
            console.log($("form").serialize());
            $.ajax({
                type: "POST",
                url: "/login",
                dataType: "json",
                data: $("form").serialize(),
                success: function(data){
                   if(data.success){
//                        window.location.href="/index";
                   }else{
//                       $.messager.alert("温馨提示",data.msg,"warning");
                       alert("温馨提示",data.msg,"warning");
                   }
                }
            });
        }
        // 清除账号和密码
        function resetForm() {
            $("form").form("clear");
        }
        
    </script>
</head>
<body>
<header id="header" class="">
    <h1><img src="img/logo.png" alt=""><span>CRM</span></h1>
    <ul>
        <li><a href="#">核心功能</a></li>
        <li><a href="#">版本与价格</a></li>
        <li><a href="#">拓展与集成</a></li>
        <li><a href="#">行业客户</a></li>
        <li><a href="#">关于我们</a></li>
    </ul>
</header><!-- /header -->
<div id="con">
    <div class="left">
        <h2>张小猪CRM管理系统</h2>
        <p>来自张小猪的在线CRM客户关系管理软件,帮助全球5万+企业管理客户数据,销售过程,营销活动以及服务支持,并能够与丰富第三方应用无缝集成,满足业务运营所需<span>开源,无限期使用!</span></p>
        <div class="icon">
            <dl>
                <dt><img src="img/1.png" alt=""></dt>
                <dd>
                    <h3>小码哥CRM管理系统</h3>
                    <p>CRM Magazine</p>
                    <p>全球最具权威的CRM媒体平台</p>
                </dd>
            </dl>
            <dl>
                <dt><img src="img/2.png" alt=""></dt>
                <dd>
                    <h3>CRM领导者</h3>
                    <p>G2Crowd</p>
                    <p>独立商用软件评测机构</p>
                </dd>
            </dl>
            <dl>
                <dt>Gartner</dt>
                <dd>
                    <h3>CRM线索管理工具象限</h3>
                    <p>Gartner</p>
                    <p>全球最具权威的CRM媒体平台</p>
                </dd>
            </dl>
        </div>
    </div>
    <form method="post">
        <div class="right">
            <input type="text" name="username" placeholder="请输入用户名">
            <input type="password" name="password" placeholder="请输入密码">
            <input type="button" value='登录' onclick="submitForm();">
        </div>
    </form>
</div>
<footer id="footer">
    <p>吸引,维护并取悦您的客户,实现"以客户为中心"的成功转型</p>
    <div class="detail">	
        <dl>
            <dt>销售过程管理</dt>
            <dd>从分配线索,跟踪商机,发送保价到最后成交,全面监督整个销售过程,并关注重要交易</dd>
        </dl>
        <dl>
            <dt>客户数据管理</dt>
            <dd>从分配线索,跟踪商机,发送保价到最后成交,全面监督整个销售过程,并关注重要交易</dd>
        </dl>
        <dl>
            <dt>市场营销管理</dt>
            <dd>从分配线索,跟踪商机,发送保价到最后成交,全面监督整个销售过程,并关注重要交易</dd>
        </dl>
    </div>
</footer>
</body>
</html>