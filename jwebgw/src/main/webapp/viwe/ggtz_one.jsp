<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <table class="table table-bordered">
        <tr>
            <td>标题</td>
            <td>
                ${obj.spage_notice_biaoti}
            </td>
        </tr>
        <tr>
            <td>发布人</td>
            <td>
                ${obj.spage_notice_zhidanren}
            </td>
        </tr>
        <tr>
            <td>发布时间</td>
            <td>
                ${obj.spage_notice_fabushijian}
            </td>
        </tr>
    </table>
    <hr/>
    <div>${obj.spage_notice_neirong}</div>
</div>
