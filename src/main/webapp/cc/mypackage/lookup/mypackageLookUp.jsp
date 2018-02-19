<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
        <!--后台UI组件End-->
        <script type="text/javascript">
            var manager;
            $(function () {
                manager = $("#maingrid").ligerGrid({
                    columns: [
                        {display: '名称', name: 'mypackage_name', width: 390, align: 'left'}
                    ], width: '100%'
                    , usePager: false
                    , height: '97%'
                    , tree: {
                        columnName: 'mypackage_name'
                        , columnId: 'mypackage_id'
                        , idField: 'mypackage_id'
                        , parentIDField: 'mypackage_pid'
                    }
                    , url: '${path_home}/cc/mypackage/s/selectVast/GRID.jw'
                    , checkbox: false
                    , nodeWidth: 160
                    , slide: false
                });
            });
            function f_select() {
                return manager.getSelectedRow();
            }
        </script>
    </head>
    <body style="padding: 4px">
        <div id="maingrid">
        </div>
    </body>
</html>
