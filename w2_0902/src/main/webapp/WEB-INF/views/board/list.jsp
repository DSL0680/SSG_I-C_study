<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Tables</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
    For more information about DataTables, please visit the <a target="_blank"
                                                               href="https://datatables.net">official DataTables documentation</a>.</p>
${result}
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>BNO</th>
                    <th>TITLE</th>
                    <th>WRITER</th>
                    <th>REGDATE</th>
                    <th>MODDATE</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${result.list}" var="board">
                <tr>
                    <th><c:out value="${board.bno}"/></th>
                    <th>
                        <c:if test="${board.fileName != null}">
                        <img src="http://localhost:8081/attach/s_${board.fileName}">
                        </c:if>
                        <c:out value="${board.title}"/>
                    </th>
                    <th><c:out value="${board.writer}"/></th>
                    <th>REGDATE</th>
                    <th>MODDATE</th>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@include file="../includes/footer.jsp"%>