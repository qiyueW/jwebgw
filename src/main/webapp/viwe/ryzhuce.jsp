<%@page import="plugins.CheckMPC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(CheckMPC.isMobileDevice(request)||CheckMPC.isWeChat(request)||CheckMPC.isIOSDevice(request)){
         String home=application.getAttribute("path_home").toString();
         request.getRequestDispatcher(home+"/viwe/ryzhuce2.jsp").forward(request,response);
         return;
    }
%>
<!--后台UI组件Start-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>人员注册</title>
        <link href="${path_home}/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <script src="${path_home}/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
        <script src="${path_home}/lib/ligerUI/myligerui.js" type="text/javascript"></script> 
        <%@include file="/WEB-INF/jspf/zui.jspf"%>

        <!--后台UI组件End-->
        <style type="text/css">
            .title2{
                background-color:#CCCCCC;
                font-size:16px; 
                font-size-adjust:inherit;
            }
            body{
                font-size: 15px;	
            }
        </style>
        <script type="text/javascript"src="${path_home}/admin/base/bm/lookup/bmLookUp.js" ></script>
        <script type="text/javascript"src="${path_home}/viwe/js/ryzhuce.js"></script>

        <script type="text/javascript">
            var path_home = "${path_home}/";
            $(function () {
                var cb = f_dcBaseBM("bm_id2", "bm_id", 150);
                var date = new Date();
                var d = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
                iniDate("ry_cdate", d);
            });
        </script>
    </head>
    <body style="background-color: #FFFFF4">
        <div class="navbar navbar-inverse navbar-fixed-top navbar-layoutit"style="background-color: #FFFFF4">
            <!--<div class="navbar-collapse">-->
            <ul  class="nav nav-tabs" >
                <li>
                    <a href="${path_home}/spage/index/s/selectOne.jw">首页</a>
                </li>
                <li>
                    <a href="${path_home}/spage/notice/view/selectVast.jw">发布与公告</a>
                </li>
                <li>
                    <a href="${path_home}/viwe/jingyanku.jsp">经验库</a>
                </li>
                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown">人员通道<strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li class="active">
                            <a href="${path_home}/viwe/ryzhuce.jsp">人员注册</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="${path_home}/loginUser.jsp">用户登陆</a>
                        </li>
                        <li class="divider"></li>
                    </ul>
                </li>
            </ul>
            <!--</div>-->
            <!--/.navbar-collapse -->
        </div>
        <!--/.navbar-fixed-top -->



        <div class="container">
            <h2>人员注册</h2>
            <div style=" color: tomato; margin: 10px">还需要等待审批通过才能正常使用所注册的账号。</div>
            <table border="1" cellspacing="0" cellpadding="0">
                <col width="51" />
                <col width="182" />
                <col width="176" />
                <col width="138" />
                <col width="231" />
                <tr height="35">
                    <td rowspan="6" height="188" width="51"><div align="center">个<br />
                            人<br />
                            信<br />
                            息</div></td>
                    <td colspan="4" width="727" 	style="background-color:#CCCCCC; font-size:16px; font-size-adjust:inherit;">基础信息</td>
                </tr>
                <tr height="30">
                    <td height="30">部门</td>
                    <td><input type="text" name="bm_id2" id="bm_id2" required /></td>
                    <td>姓名</td>
                    <td><input type="text" name="ry_name" id="ry_name"  /></td>
                </tr>
                <tr height="30">
                    <td height="30">岗位</td>
                    <td><input type="text" name="gw_name" id="gw_name"  /></td>
                    <td>性别</td>
                    <td>
                        <select name="ry_sex" id="ry_sex">
                            <option value="女">女</option>
                            <option value="男">男</option>		
                        </select>
                    </td>
                </tr>
                <tr height="30">
                    <td height="30">入职日期</td>
                    <td><input type="text" name="ry_cdate" id="ry_cdate"  /></td>
                    <td>邮箱</td>
                    <td><input type="text" name="ry_email" id="ry_email"  /></td>
                </tr>
                <tr height="30">
                    <td height="30">状态</td>
                    <td>
                        <select name="ry_style" id="ry_style">
                            <option value="0">新增</option>
                        </select>
                    </td>
                    <td>通信</td>
                    <td><input type="text" name="ry_phone" id="ry_phone"  /></td>
                </tr>
                <tr height="33">
                    <td height="33">备注</td>
                    <td colspan="3"><input type="text" name="ry_info" id="ry_info"  size="70" /></td>
                </tr>
                <tr height="34">
                    <td rowspan="2" width="51"><div align="center">请记住<br />账号密码
                        </div>
                    </td>
                    <td colspan="4" height="37" style="background-color:#CCCCCC; font-size:16px; font-size-adjust:inherit;">OA系统账号密码</td>
                </tr>
                <tr height="37">
                    <td height="37" >人员账号</td>
                    <td><input type="text" name="ry_account" id="ry_account" required /></td>
                    <td>人员密码</td>
                    <td><input type="text" name="ry_password" id="ry_password" required /></td>
                </tr>
                <tr>
                    <td colspan="5" height="40"><div align="center">	<button id="postButtonID" onclick="postData();" style="width: 200px; height:30px;"  >提交</button></div></td>
                </tr>
            </table>
        </div> 
    </body>
</html>
