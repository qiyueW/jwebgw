<!--%@include file="/WEB-INF/jspf/power/userPower.jspf"%-->
<%
    //    if (!pck.checkUser("J31")) {
    //        return;
    //    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>

    </head>
    <body>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js"
        type="text/javascript"></script>
        <%@include file="/WEB-INF/jspf/zuiLocal.jspf"%>
        <script type="text/javascript"
        src="${path_home}/cc/mybeanfield/js/Mybeanfield_U.js"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript">
            var path_home = "${path_home}/";
            $(function () {
                iniMybeanEventA();

                $("input").addClass("input-sm")

                $('#mybeanfield_zj').val('${obj.mybeanfield_zj}')
                $('#mybean_mc').val('${obj.mybean_mc}')
                $('#mybeanfield_bz').val('${obj.mybeanfield_bz}')
                $('#mybeanfield_dateformat').val('${obj.mybeanfield_dateformat}')

                $('#c_zyy').val('${obj.c_zyy}')
                $('#c_lx').val('${obj.c_lx}')
                $('#c_mc').val('${obj.c_mc}')
                $('#c_bz').val('${obj.c_bz}')

                $('#t_lx').val('${obj.t_lx}')
                $('#t_sy').val('${obj.t_sy}')
                $('#t_yxkong').val('${obj.t_yxkong}')
                $('#t_cd').val('${obj.t_cd}')
                $('#t_bz').val('${obj.t_bz}')

                $('#v_zzbds').val('${obj.v_zzbds}')
                $('#v_cuowuxx').val('${obj.v_cuowuxx}')
                $('#v_bxjiancha').val('${obj.v_bxjiancha}')

                $('#h_lx').val('${obj.h_lx}')
                $('#h_jb').val('${obj.h_jb}')

                $('#e_mc').val('${obj.e_mc}')

            });
            //              class=""
        </script>
        <style>
            /*            table select {
                            min-width: 90px;
                        }*/
            select{
                border: 0;  
                display: block;  
                position: relative;  
                min-height: 1.146667rem;  
                line-height: 1.146667rem;  
                white-space: nowrap;  
                width: 100%;
                height: 26px;
                overflow: hidden;  
                padding-right: .6rem;  
                background-color: #eee;  
                background: transparent;  
                appearance:none;  
                -moz-appearance:none; /* Firefox */  
                -webkit-appearance:none; /* Safari 和 Chrome */ 
                text-align: center;
            }
            table input{
                border:0; 
                height: 30px;
            }
            .show2 {
                color: #00f;
                margin: 5px;
            }
            .show2 table{
                background-color: #ddddf7
            }

            .show3 {
                /*color: #ff9933;*/
                margin: 5px;
            }

            .showtitle {
                font-size: 18px;
            }
        </style>
        <div id="root" class="container" style=" overflow-y:scroll;">
            <input type="hidden" id="mybeanfield_zj"/>
            <!--            <div class="show2">
                            <table cellspacing="0" cellpadding="0" border="1">
                                <tr height="34">
                                    <td rowspan="2" height="68" width="72"><div align="center">bean相关</div></td>
                                    <td width="200"><div align="center">分类</div></td>
                                    <td width="200"><div align="center">bean</div></td>
                                </tr>
                                <tr height="34">
                                    <td height="34"><div align="center">
                                            <div id="showmypackageTree" style="position: relative; z-index: 1000"></div>
                                        </div></td>
                                    <td><div align="center"><div id="showmybeanTree" style="position: relative; z-index: 888"></div></div></td>
                                </tr>
                            </table>
                        </div>-->
            <div class="show3">
                <table cellspacing="0" cellpadding="0" border="1">
                    <tr height="34">
                        <td rowspan="2" height="68" width="72"><div align="center" style=" font-style: initial"><div>预设</div>方案</div></td>
                        <td width="124"><div align="center">备注</div></td>
                        <td width="150"><div align="center">Date格式</div></td>
                    </tr>
                    <tr height="34">
                        <td><div align="center"> <input type="text" name="mybeanfield_bz" id="mybeanfield_bz" /> </div></td>
                        <td><div align="center">
                                <select id="mybeanfield_dateformat">
                                    <option value=""></option>
                                    <option value="yyyy-MM-dd">yyyy-MM-dd</option>
                                    <option value="yyyy-MM-dd HH:mm:ss">yyyy-MM-dd HH:mm:ss</option>
                                </select>
                            </div></td>
                    </tr>
                </table>
            </div>

            <div class="show2">
                <table cellspacing="0" cellpadding="0" border="1">
                    <td rowspan="2" height="68" width="72"><div align="center">JAVA类</div></td>
                    <td width="107" height="23"><div align="center">c作用域</div></td>
                    <td width="124"><div align="center">c类型</div></td>
                    <td width="139"><div align="center">c属性名</div></td>
                    <td width="200"><div align="center">c备注</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">
                                <select id="c_zyy">
                                    <option value="private">private</option>
                                    <option value="public">public</option>
                                    <option value="protected">protected</option>
                                </select>
                            </div></td>
                        <td><div align="center">
                                <select id="c_lx">
                                    <option value="String">String</option>
                                    <option value="Integer">Integer</option>
                                    <option value="Date">Date</option>
                                    <option value="Double">Double</option>
                                </select>
                            </div></td>
                        <td><div align="center">
                                <input type="text" name="c_mc" id="c_mc" />
                            </div></td>
                        <td><div align="center">
                                <input type="text" name="c_bz" id="c_bz" style="width:200px"/>
                            </div></td>
                    </tr>
                </table>
            </div>
            <div class="show3">
                <table cellspacing="0" cellpadding="0" border="1">
                    <td rowspan="2" height="68" width="72"><div align="center">数据表</div></td>
                    <td width="107" height="23"><div align="center">t类型</div></td>
                    <td width="124"><div align="center">t索引</div></td>
                    <td width="50"><div align="center">t允许空</div></td>
                    <td width="90"><div align="center">t长度</div></td>
                    <td width="200"><div align="center">t备注</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">
                                <select id="t_lx">
                                    <option value="VARCHAR">VARCHAR</option>
                                    <option value="CHAR">CHAR</option>
                                    <option value="TEXT">TEXT</option>
                                    <option value="DATE">DATE</option>
                                    <option value="DATETIME">DATETIME</option>
                                    <option value="INT">INT</option>
                                    <option value="DOUBLE">DOUBLE</option>
                                </select>
                            </div></td>
                        <td><div align="center">
                                <select id="t_sy">
                                    <option value="f">否</option>
                                    <option value="s">是</option>
                                    <option value="wy">唯一</option>
                                    <option value="zj">主键</option>
                                    <!--<option value="wj">外键</option>-->
                                </select>
                            </div></td>
                        <td  style="width:49px"><div align="center">
                                <select id="t_yxkong">
                                    <option value="s">是</option>
                                    <option value="f">否</option>
                                </select>
                            </div></td>
                        <td><div align="center">
                                <input type="number" name="t_cd" id="t_cd"  style="width:90px"/>
                            </div></td>
                        <td><div align="center">
                                <input type="text" name="t_bz" id="t_bz"  style="width:200px"/>
                            </div></td>
                    </tr>
                </table>
            </div>
            <div class="show2">

                <table cellspacing="0" cellpadding="0" border="1">
                    <tr height="34">
                        <td rowspan="2" height="68" width="72"><div align="center"><div>后台</div>检验</div></td>
                        <td width="107"><div align="center">v必须检查</div></td>
                        <td width="300" height="23"><div align="center">v正则规则</div></td>
                        <td width="300"><div align="center">v错误信息</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">
                                <select id="v_bxjiancha">
                                    <option value="s">是</option>
                                    <option value="f">否</option>
                                    <option value="w">不存在检查</option>
                                </select>
                            </div></td>
                        <td><div align="center"><input type="text" name="v_zzbds" id="v_zzbds" style=" width: 299px;"/></div></td>
                        <td><div align="center"><input type="text" name="v_cuowuxx" id="v_cuowuxx"  style=" width: 299px;"/></div></td>
                    </tr>
                </table>
            </div>
            <div class="show3">
                <table cellspacing="0" cellpadding="0" border="1">
                    <tr height="34">
                        <td rowspan="2" height="68" width="72"><div align="center">html相关</div></td>
                        <td width="107"><div align="center">h类型</div></td>
                        <td width="90" height="23"><div align="center">h脚本校验</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">
                                <select id="h_lx">
                                    <option value="text">文本</option>
                                    <option value="number">数字</option>
                                    <option value="float">浮点</option>
                                    <option value="select">选择框</option>
                                    <option value="checkbox">复选框</option>
                                    <option value="radio">单选框</option>
                                    <option value="date">日期/时间</option>
                                    <option value="file">文件</option>
                                    <option value="ueditor">文本ueditor</option>
                                </select>
                            </div></td>
                        <td><div align="center"><select id="h_jb">
                                    <option value="s">是</option>
                                    <option value="f">否</option>
                                </select></div></td>
                    </tr>
                </table>
            </div>
            <div class="show2">
                <table cellspacing="0" cellpadding="0" border="1">
                    <tr height="34">
                        <td rowspan="2" height="68" width="72"><div align="center">excel相关</div></td>
                        <td width="107"><div align="center">e展示名</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">
                                <input type="text" name="e_mc" id="e_mc" />
                            </div></td>
                    </tr>
                </table>
            </div>

            <div style="width:100%">
                <button type="submit" id="myMybeanButton" data-loading-text="执行中" style="width:1000px;"
                        class="btn btn-primary" >修改</button>
            </div>
        </div>
        <!--root div end-->
    </body>
</html>
