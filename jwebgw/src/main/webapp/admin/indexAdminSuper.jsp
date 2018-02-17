<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>超级管理区</title>
        <%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
        <!--<script src="admin/indexdata.js" type="text/javascript"></script>-->
        <script type="text/javascript">
            var tab = null;
            var accordion = null;
            var tree = null;
            var tabItems = [];
            $(function ()
            {
                //布局
                $("#layout1").ligerLayout({
                    leftWidth: 190,
                    height: '100%',
                    heightDiff: -34,
                    space: 4,
                    onHeightChanged: f_heightChanged,
                    onLeftToggle: function ()
                    {
                        tab && tab.trigger('sysWidthChange');
                    },
                    onRightToggle: function ()
                    {
                        tab && tab.trigger('sysWidthChange');
                    }
                });

                var height = $(".l-layout-center").height();

                //Tab
                tab = $("#framecenter").ligerTab({
                    height: height,
                    showSwitchInTab: true,
                    showSwitch: true,
                    onAfterAddTabItem: function (tabdata)
                    {
                        tabItems.push(tabdata);
                        saveTabStatus();
                    },
                    onAfterRemoveTabItem: function (tabid)
                    {
                        for (var i = 0; i < tabItems.length; i++)
                        {
                            var o = tabItems[i];
                            if (o.tabid == tabid)
                            {
                                tabItems.splice(i, 1);
                                saveTabStatus();
                                break;
                            }
                        }
                    },
                    onReload: function (tabdata)
                    {
                        var tabid = tabdata.tabid;
                        addFrameSkinLink(tabid);
                    }
                });

                //面板
                $("#accordion1").ligerAccordion({
                    height: height - 24, speed: null
                });

                $(".l-link").hover(function ()
                {
                    $(this).addClass("l-link-over");
                }, function ()
                {
                    $(this).removeClass("l-link-over");
                });
                //树
                $("#tree1").ligerTree({
                    idFieldName: 'power_id',
                    parentIDFieldName: 'power_pid',
                    textFieldName: 'power_name',
                    url: '${path_home}/sys/superadmin/manager/v/showMenu.jw',
                    checkbox: false,
                    slide: false,
                    nodeWidth: 120,
//                    idFieldName: 'id', 
//                    parentIDFieldName:'pid',
                    btnClickToToggleOnly: false,
                    render: function (a) {
                        if (!a.isnew)
                            return a.power_name;
                        return '<a href="' + a.view_url + '" target="_blank">' + a.power_name + '</a>';
                    }
                    , onSelect: function (node)
                    {
                        if (!node.data.view_url)
                            return;
                        if (node.data.isnew)
                        {
                            return;
                        }
                        var tabid = $(node.target).attr("tabid");
                        if (!tabid)
                        {
                            tabid = new Date().getTime();
                            $(node.target).attr("tabid", tabid);
                        }
                        f_addTab(tabid, node.data.power_name, node.data.view_url);
                    }
                });
                //树
//                $("#tree2").ligerTree({
//                    data: indexdata2,
//                    checkbox: false,
//                    slide: false,
//                    nodeWidth: 120,
//                    btnClickToToggleOnly :false,
//                    idFieldName: 'id', 
//                    parentIDFieldName:'pid',
//                    render: function(a) {
//                        if (!a.isnew)
//                            return a.text;
//                        return '<a href="' + a.url + '" target="_blank">' + a.text + '</a>';
//                    },
//                    onSelect: function(node)
//                    {
//                        if (!node.data.url)
//                            return;
//                        if (node.data.isnew)
//                        {
//                            return;
//                        }
//                        var tabid = $(node.target).attr("tabid");
//                        if (!tabid)
//                        {
//                            tabid = new Date().getTime();
//                            $(node.target).attr("tabid", tabid);
//                        }
//                        f_addTab(tabid, node.data.text, node.data.url);
//                    }
//                });
                tab = liger.get("framecenter");
                accordion = liger.get("accordion1");
                tree = liger.get("tree1");
                $("#pageloading").hide();
                css_init();
                pages_init();
            });
            function f_heightChanged(options)
            {
                if (tab)
                    tab.addHeight(options.diff);
                if (accordion && options.middleHeight - 24 > 0)
                    accordion.setHeight(options.middleHeight - 24);
            }
            function f_addTab(tabid, text, url)
            {
                tab.addTabItem({
                    tabid: tabid,
                    text: text,
                    url: url,
                    callback: function ()
                    {
                        addFrameSkinLink(tabid);
                    }
                });
            }
            function addFrameSkinLink(tabid)
            {
                var prevHref = getLinkPrevHref(tabid) || "";
                var skin = getQueryString("skin");
                if (!skin)
                    return;
                skin = skin.toLowerCase();
                attachLinkToFrame(tabid, prevHref + skin_links[skin]);
            }
            var skin_links = {
                "aqua": "lib/ligerUI/skins/Aqua/css/ligerui-all.css",
                "gray": "lib/ligerUI/skins/Gray/css/all.css",
                "silvery": "lib/ligerUI/skins/Silvery/css/style.css",
                "gray2014": "lib/ligerUI/skins/gray2014/css/all.css"
            };
            function pages_init()
            {
//                var tabJson = $.cookie('liger-home-tab');
//                if (tabJson)
//                {
//                    var tabitems = JSON2.parse(tabJson);
//                    for (var i = 0; tabitems && tabitems[i]; i++)
//                    {
//                        f_addTab(tabitems[i].tabid, tabitems[i].text, tabitems[i].url);
//                    }
//                }
            }
            function saveTabStatus()
            {
                $.cookie('liger-home-tab', JSON2.stringify(tabItems));
            }
            function css_init()
            {
                var css = $("#mylink").get(0), skin = getQueryString("skin");
                $("#skinSelect").val(skin);
                $("#skinSelect").change(function ()
                {
                    if (this.value)
                    {
                        location.href = "admin/index.jsp?skin=" + this.value;
                    } else
                    {
                        location.href = "admin/index.jsp";
                    }
                });


                if (!css || !skin)
                    return;
                skin = skin.toLowerCase();
                $('body').addClass("body-" + skin);
                $(css).attr("href", skin_links[skin]);
            }
            function getQueryString(name)
            {
                var now_url = document.location.search.slice(1), q_array = now_url.split('&');
                for (var i = 0; i < q_array.length; i++)
                {
                    var v_array = q_array[i].split('=');
                    if (v_array[0] == name)
                    {
                        return v_array[1];
                    }
                }
                return false;
            }
            function attachLinkToFrame(iframeId, filename)
            {
                if (!window.frames[iframeId])
                    return;
                var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
                var fileref = window.frames[iframeId].document.createElement("link");
                if (!fileref)
                    return;
                fileref.setAttribute("rel", "stylesheet");
                fileref.setAttribute("type", "text/css");
                fileref.setAttribute("href", filename);
                head.appendChild(fileref);
            }
            function getLinkPrevHref(iframeId)
            {
                if (!window.frames[iframeId])
                    return;
                var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
                var links = $("link:first", head);
                for (var i = 0; links[i]; i++)
                {
                    var href = $(links[i]).attr("href");
                    if (href && href.toLowerCase().indexOf("ligerui") > 0)
                    {
                        return href.substring(0, href.toLowerCase().indexOf("lib"));
                    }
                }
            }
        </script> 
        <style type="text/css"> 
            body,html{height:100%;}
            body{ padding:0px; margin:0;   overflow:hidden;}  
            .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
            .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
            .l-layout-top{background:#102A49; color:White;}
            .l-layout-bottom{ background:#E5EDEF; text-align:center;}
            #pageloading{position:absolute; left:0px; top:0px; background:white url('lib/images/loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
            .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
            .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
            .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
            .space{ color:#E7E7E7;}
            /* 顶部 */ 
            .l-topmenu{ margin:0; padding:0; height:31px; line-height:31px; background:url('lib/images/top.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
            .l-topmenu-logo{ color:#E7E7E7; padding-left:35px; line-height:26px;background:url('lib/images/topicon.gif') no-repeat 10px 5px;}
            .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#070A0C;}
            .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline} 
            .body-gray2014 #framecenter{
                margin-top:3px;
            }
            .viewsourcelink {
                background:#B3D9F7;  display:block; position:absolute; right:10px; top:3px; padding:6px 4px; color:#333; text-decoration:underline;
            }
            .viewsourcelink-over {
                background:#81C0F2;
            }
            .l-topmenu-welcome label {color:white;
            }
            #skinSelect {
                margin-right: 6px;
            }
        </style>
    </head>
    <body style="padding:0px;background:#EAEEF5;">  
        <div id="pageloading"></div>  
        <div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; "> 
            <div position="left"  title="主要菜单" id="accordion1"> 
                <div title="业务" class="l-scroll">
                    <ul id="tree1" style="margin-top:3px;"></ul>
                </div>
                <!--                <div title="基础与设置">
                                        <ul id="tree2" style="margin-top:3px;"></ul>
                                </div>-->

            </div>
            <div position="center" id="framecenter"> 
                <div tabid="home" title="我的主页" style="height:300px" >
                    <!--<iframe frameborder="0" name="home" id="home" src="admin/iniView.jsp"></iframe>-->
                </div>
            </div>
        </div>
        <div id="topmenu" style="height:15px;">
            <div style="height:32px; line-height:32px; text-align:center;">
                <%=hyy%> 
                <a href="javascript:void(0)" onclick="return updateMypassword()">修改密码</a>
                &nbsp;&nbsp;&nbsp;
                <a href="${path_home}/sys/superadmin/manager/loginOut.jw">退出登陆</a>
            </div>
        </div>
        <script>
            function updateMypassword() {
                $.ligerDialog.open({title: '修改密码', url: '${path_home}/admin/usersafe/superAadminSelf.jsp', height: 500, width: 600, isResize: true});
            }
        </script>
    </body>
</html>
