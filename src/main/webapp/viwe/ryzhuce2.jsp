<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>人员注册</title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>
        <%@include file="/WEB-INF/jspf/zui.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript"src="${path_home}/viwe/js/ryzhuce.js"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <script type="text/javascript">
            var path_home = "${path_home}/";
            $(function () {
                var fa1 = new ztree_select("${path_home}/base/bm/selectVast.jw", {}, "showBMTree", "bm_id2", "bm_id", 220, 390);
                fa1.init(function (treeId, treeNode) {
                    fa1.setMyValue(treeNode)
                    $("#" +fa1.menuContentDIV).fadeOut("fast");
                }, "bm_id", "bm_pid", "bm_name")
                
                var date = new Date();
                var d = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
                iniDate("ry_cdate", d);
//                /loginUser.jsp
            });
        </script>
    </head>
    <body style="background-color: #FFFFF4">
        <div class="navbar navbar-inverse navbar-fixed-top navbar-layoutit"style="background-color: #FFFFF4">
            <!--<div class="navbar-collapse">-->
            <ul  class="nav nav-tabs" >
                <li>
                    <a href="${path_home}/index.jsp">首页</a>
                </li>
                <li>
                    <a href="${path_home}/spage/notice/view/selectVast.jw">公告通知</a>
                </li>
                <li>
                    <a href="${path_home}/viwe/jingyanku.jsp">经验库</a>
                </li>
                <li>
                    <a href="${path_home}/viwe/mendian.jsp">自助门店</a>
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
                        <li>
                            <a href="${path_home}/loginUser_PD.jsp">盘点通道</a>
                            <a href="${path_home}/clientdown.jsp">盘点客户端下载</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!--</div>-->
            <!--/.navbar-collapse -->
        </div>
        <!--/.navbar-fixed-top -->
        <div class="container" style="margin-top: 30px;">
            <h2>人员注册</h2>
            <div style=" color: tomato; margin: 10px">还需要等待审批通过才能正常使用所注册的账号。</div>
            <div class="form-group">
                <label for="bm_id">部门</label>
                <!--<input type="text" class="form-control" name="bm_id2" id="bm_id2"/>-->
                <div id="showBMTree"></div>
            </div>
            <div class="form-group">
                <label for="ry_name">姓名</label>
                <input type="text" class="form-control" name="ry_name" id="ry_name"/>
            </div>
            <div class="form-group">
                <label for="gw_name">岗位</label>
                <input type="text" class="form-control" name="gw_name" id="gw_name"  />
            </div>
            <div class="form-group">
                <label for="ry_sex">性别</label>
                <select name="ry_sex" id="ry_sex"  class="form-control">
                    <option value="女">女</option>
                    <option value="男">男</option>		
                </select>
            </div>
            <div class="form-group">
                <label for="ry_cdate">入职日期</label>
                <input type="text" class="form-control" name="ry_cdate" id="ry_cdate"  />
            </div>
            <div class="form-group">
                <label for="ry_email">邮箱</label>
                <input type="text" class="form-control" name="ry_email" id="ry_email"  />
            </div>
            <div class="form-group">
                <label for="ry_phone">通信</label>
                <input type="text" class="form-control" name="ry_phone" id="ry_phone"  />
            </div>
            <div class="form-group">
                <label for="ry_account ">账号</label>
                <input type="text" class="form-control" name="ry_account" id="ry_account" required />
            </div>    
            <div class="form-group">
                <label for="ry_password">人员密码</label>
                <input type="text" class="form-control" name="ry_password" id="ry_password" required />
            </div>
            <div class="form-group">
                <label for="ry_style">状态</label>
                <select class="form-control" name="ry_style" id="ry_style">
                    <option value="0">新增</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ry_info ">备注</label>
                <input type="text" class="form-control" name="ry_info" id="ry_info"  size="70" />
            </div>  

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" id="postButtonID" class="btn btn-default" onclick="postData();">注册</button>
                </div>
            </div>
        </div>  
    </body>
</html>
