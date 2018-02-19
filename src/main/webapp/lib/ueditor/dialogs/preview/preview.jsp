<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<base href="${path_home}/">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <style>
            html,body{
                height:100%;
                width:100%;
                padding:0;
                margin:0;
            }
            #preview{
                width:100%;
                height:100%;
                padding:0;
                margin:0;
            }
            #preview *{font-family:sans-serif;font-size:16px;}
        </style>
        <script type="text/javascript" src="lib/ueditor/dialogs/internal.js"></script>
        <script src="lib/ueditor/ueditor.parse.min.js"></script>
        <title></title>
    </head>
    <body class="view">
        <div id="preview" style="margin:8px">

        </div>
    </body>
    <script>
        document.getElementById('preview').innerHTML = editor.getContent();
        uParse('#preview', {
            rootPath: 'lib/ueditor/',
            chartContainerHeight: 500
        })
        dialog.oncancel = function () {
            document.getElementById('preview').innerHTML = '';
        }
    </script>
</html>