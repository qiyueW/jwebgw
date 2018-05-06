<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name=Keywords content="JWeb JWeb框架 JWeb官网 框架 mvc框架 jweb 框架 java">
        <meta name=Description content="JWeb框架 高效、创新、小巧且强健">
        <meta name=renderer content=webkit>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script src="${path_home}/admin/js/indexUser.js" type="text/javascript"></script>

        <title>您好</title>
        <script type="text/javascript">
            $(function () {
                loadUserMainTree("divID_Tree_Main");
                $("#tt").tabs({
                    onContextMenu: function (e, title, index) {
                        e.preventDefault();
                        $("#indexMainTabRClickMenu").menu('show', {
                            left: e.pageX,
                            top: e.pageY
                        });
                        $("#tabsRClickDoSaveValueID").val(title);
                    }
                });
            })
            //刷新当前标签Tabs
            function RefreshTab(currentTab) {
                var url = $(currentTab.panel('options')).attr('href');
                $('#tabs').tabs('update', {
                    tab: currentTab,
                    options: {
                        href: url
                    }
                });
                currentTab.panel('refresh');
            }
        </script>
    </head>
    <body class="easyui-layout"style="margin:0;">
        <input type="hidden" id="tabsRClickDoSaveValueID"/>
        <div data-options="region:'west',split:true" title="菜单" style="width:280px;">
            <div id="divID_Tree_Main"  class="ztree powertablediv">---</div>
        </div>
        <div data-options="region:'center'">
            <div data-options="border:false,fit:true" class="easyui-tabs" id="tt">
                <div title="个人中心" data-options="href:'${path_home}/admin/iniView.jsp'"></div>
            </div>
        </div>



    </body>
    <!-- 以下为tabs右击事件 -->  
    <div id="indexMainTabRClickMenu" class="easyui-menu" style="width:120px;">
        <div onclick="javascript:index_main_tab_close1()">闭关当前页面</div>
        <div onclick="javascript:index_main_tab_close_other()">关闭其他页面</div>
        <div onclick="javascript:index_main_tab_close()">关闭全部页面</div>
        <div onclick="javascript:index_main_tab_reflash()">刷新</div>
    </div>  

    <script>
        function index_main_tab_close1() {
//            $('#tt').tabs('close', $("#tabsRClickDoSaveValueID").val());
            var tabTitle;
            $(".tabs li").each(function (index, obj) {
                tabTitle = $(".tabs-closable", this).text();
                if (tabTitle == $("#tabsRClickDoSaveValueID").val()) {
                    $("#tt").tabs("close", tabTitle);
                    return;
                }
            });

        }
        function index_main_tab_close() {
            $(".tabs li").each(function (index, obj) {
                var tab = $(".tabs-closable", this).text();
                $(".easyui-tabs").tabs('close', tab);
            });
        }
        function index_main_tab_close_other() {
            $(".tabs li").each(function (index, obj) {
                var tabTitle = $(".tabs-closable", this).text();
                if (tabTitle != $("#tabsRClickDoSaveValueID").val()) {
                    $("#tt").tabs("close", tabTitle);
                }
            });
        }
        function index_main_tab_reflash() {
            var currentTab = $('#tt').tabs('getSelected');
            var url = $(currentTab.panel('options')).attr('href');
            $('#tt').tabs('update', {
                tab: currentTab,
                options: {
                    href: url
                }
            });
            currentTab.panel('refresh');
        }
    </script>
</html>
