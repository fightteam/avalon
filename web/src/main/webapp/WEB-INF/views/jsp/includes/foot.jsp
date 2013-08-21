<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${scripts}" var="entry">
    <c:if test="${entry.key != 'jquery'}">
        <script type="text/javascript" src="${entry.value}"></script>
    </c:if>
</c:forEach>
<!--datatables-->
<%--<script type="text/javascript" src="/static/components/datatables/js/jquery.dataTables.min.js"></script>--%>

</body>
</html>