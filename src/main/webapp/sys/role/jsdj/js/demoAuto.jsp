<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="sys/role/jsdj/js/jsdjAuto.js"></script>
        <script type="text/javascript" src="CJ.js"></script>
        
        <script type="text/javascript">
            var ASGRID;
            $(function () {
                iniEvent();
                ASGRID = $('#divID_GRID_SA1').ligerGrid({
                    columns: [
                        {display: '类别', name: 'khsc_lb', width: 60, align: 'center'}
                        , {display: '客户/商场名称', name: 'khsc_mc', width: 160, align: 'center'}
                        , {display: '区域', name: 'khsc_qy', width: 70, align: 'center'}
                        , {display: '快递公司', name: 'ktgs', width: 80, align: 'center'}
                        , {display: '快递单号', name: 'ktdh', width: 130, align: 'center'}
                        , {display: '日期', name: 'xsth_rq', width:80, align: 'center'}
                        , {display: '退货数量', name: 'xsth_sl', width: 60, align: 'center'}
                        , {display: 'R', name: 'xsth_slr', width: 60, align: 'center'}
                        , {display: 'N', name: 'xsth_sln', width: 60, align: 'center'}
                        , {display: '维修', name: 'xsth_wxsl', width:60, align: 'center'}
                        , {display: '类型', name: 'xsth_lx', width: 100, align: 'center'}
                        , {display: '备注', name: 'xsth_bz', width: 80, align: 'center'}
                    ]
                    , usePager: false
                    , url: path_home+'services/xsth/s/select10ByAdd.jw'
                    , width: '1050px'
                    , height: '230px'
                });
                toSelect("jsdj_selectID",path_home+"sys/power/jsdj/s/selectAllByJson.jw","jsdj_id","jsdj_name");
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        
                    </div>
                    <div id="bm_divID" class="panel-body">
                        <form id="xsth_formID" method="post" class="form-horizontal" onsubmit="return false;">
                            <div class="form-group">
                                <input type="hidden" name="khsc_zj" id="khsc_zj"  />
                                <table cellspacing="0" cellpadding="0"  border="1">
                                    <col width="72" />
                                    <col width="56" />
                                    <col width="74" />
                                    <col width="44" />
                                    <col width="118" />
                                    <col width="53" />
                                    <col width="70" />
                                    <col width="75" />
                                    <col width="100" />
                                    <tr height="33">
                                        <td height="33" width="72">快递单号</td>
                                        <td colspan="5" width="345"><input type="text" name="ktdh" id="ktdh" autocomplete="off" /></td>
                                        <td width="70">快递公司</td>
                                        <td colspan="2" width="175">
                                            <select name="ktgs" id="ktgs">
                                              
                                            </select>
                                        </td>
                                    </tr>
                                    <tr height="23" >
                                        <td rowspan="2" height="46" class="gehangyanse">退货</td>
                                        <td class="gehangyanse">R</td>
                                        <td class="gehangyanse" colspan="3"><input type="text" name="xsth_slr" id="xsth_slr" size="15" autocomplete="off"/></td>
                                        <td class="gehangyanse" colspan="2" rowspan="2"><input type="text" name="xsth_sl" id="xsth_sl" disabled="true" size="9"/></td>
                                        <td colspan="2" rowspan="3">
                                            <select name="xsth_lx" id="xsth_lx">
<!--                                                <option value="退货换货">退货换货</option>
                                                <option value="维修">维修</option>
                                                <option value="退货换货/维修">退货换货/维修</option>
                                                <option value="配件">配件</option>-->
                                            </select>
                                        </td>
                                    </tr>
                                    <tr height="23">
                                        <td height="23" class="gehangyanse">N</td>
                                        <td colspan="3" class="gehangyanse"><input type="text" name="xsth_sln" id="xsth_sln"  size="15" autocomplete="off"/></td>
                                    </tr>
                                    <tr height="26">
                                        <td height="26">维修</td>
                                        <td colspan="6"><input type="text" name="xsth_wxsl" id="xsth_wxsl" size="25" autocomplete="off" /></td>
                                    </tr>
                                    <tr height="26" class="gehangyanse">
                                        <td colspan="2" height="26">客户/商场名称</td>
                                        <td colspan="7"><input type="text" name="khsc_mc" id="khsc_mc" autocomplete="off"/></td>
                                    </tr>
                                    <tr height="26" class="gehangyanse">
                                        <td height="26">类型</td>
                                        <td colspan="4">
                                            <select name="khsc_lb" id="khsc_lb">
                                                <option value="商场">商场</option>
                                                <option value="经销">经销</option>
                                                <option value="电商">电商</option>
                                                <option value="散户">散户</option>
                                            </select>
                                        </td>
                                        <td>区域</td>
                                        <td colspan="3"><input type="text" name="khsc_qy" id="khsc_qy"  autocomplete="off"/></td>
                                    </tr>
                                    <tr height="29">
                                        <td height="29">日期</td>
                                        <td colspan="2"><input type="text" name="xsth_rq" id="xsth_rq" required size="10" /></td>
                                        <td>备注</td>
                                        <td colspan="5"><input type="text" name="xsth_bz" id="xsth_bz" size="40" autocomplete="off" /></td>
                                    </tr>
                                </table><br/>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-4">
                                    <button type="button" id="myButton" data-loading-text="执行中"
                                            class="btn btn-primary">添加</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
<div id="divID_GRID_SA1">

                        </div>
    </body>
</html>
