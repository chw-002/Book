<%--
  Created by IntelliJ IDEA.
  User: ----CHW----
  Date: 2021/3/28
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>&nbsp;
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>&nbsp;
        <%--当前页小于等于2时，隐藏第0页--%>
        <c:if test="${requestScope.page.pageNo > 2}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-2}">${requestScope.page.pageNo-2}</a>&nbsp;
        </c:if>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>
    </c:if>
    【${requestScope.page.pageNo}】
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">${requestScope.page.pageNo+1}</a>&nbsp;
        <%--隐藏超过总页数的页面--%>
        <c:if test="${requestScope.page.pageNo + 2 <= requestScope.page.pageTotal}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+2}">${requestScope.page.pageNo+2}</a>&nbsp;
        </c:if>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>&nbsp;
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>&nbsp;
    </c:if>
    共【${requestScope.page.pageTotal}】页&nbsp;&nbsp;&nbsp;共【${requestScope.page.pageTotalCount}】条记录 &nbsp;&nbsp;
    跳转到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchBtn" type="button" value="确定">

    <script>
        $(function () {
            $("#searchBtn").click(function () {
                let pageNo = $("#pn_input").val();
                location.href="${requestScope.page.url}&pageNo="+pageNo;
            })
        })
    </script>
</div>