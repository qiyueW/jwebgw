<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <td>标题</td>
            <td>
                ${obj.spage_jingyanku_biaoti}
            </td>
        </tr>
        <tr>
            <td>关键词</td>
            <td>
                ${obj.spage_jingyanku_gjc}
            </td>
        </tr>
        <tr>
            <td>发布人</td>
            <td>
                ${obj.spage_jingyanku_zhidanren}
            </td>
        </tr>
        <tr>
            <td>发布时间</td>
            <td>
                ${obj.spage_jingyanku_fabushijian}
            </td>
        </tr>
        <tr>
            <td>归档分类</td>
            <td>
                ${obj.jingyankufl_name}
            </td>
        </tr>
    </table>
    <hr/>
    <div>${obj.spage_jingyanku_neirong}</div>
</div>