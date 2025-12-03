<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/tamplate/head.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<!-- side bar -->
		<c:import url="/WEB-INF/views/tamplate/sidebar.jsp"></c:import>
		<!-- side bar -->
		
		<!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
            <div id="content">
            
				<!-- topbar -->
				<c:import url="/WEB-INF/views/tamplate/topbar.jsp"></c:import>  
				<!-- topbar -->				
			
				<!-- Begin Page Content -->
                <div class="container-fluid">
                	<!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">${category} Detail</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
	                <!-- Content Row -->
	                <div class="row justify-content-center">
	                <!-- 생성한 contents 작성 -->
                		<div class="col-sm-6">
							  <div>
							    <label for="title">제목</label>
						    	<input type="text" class="form-control" value="${notice.boardTitle}" id="title" readonly="readonly">
							  </div>
							  <div>
							    <label for="writer">작성자</label>
						    	<input type="text" class="form-control" value="${notice.boardWriter}" id="writer" readonly="readonly">
							  </div>
							  <div>
							  	<label for="contents">내용</label>
							    <textarea class="form-control"  id="contents" rows="6" cols="" readonly="readonly">${notice.boardContents}</textarea>
							  </div>
							  <div>
							  	<c:forEach items="${notice.fileDTOs}" var="file">
							  		<a href="/files/${category}/${file.fileName}">${file.fileOrigin}</a>
							  	</c:forEach>
							  </div>
							  <div class="mt-3">
							  	  <form action="./delete?boardNum=${notice.boardNum}" method="post" style="display:inline-block">
								  	<button type="submit" class="btn btn-danger">삭제</button>							  	  
							  	  </form>
								  <button type="submit" class="btn btn-success">
								  	<a href="./update?boardNum=${notice.boardNum}">수정</a> 
								  </button>
								  <c:if test="${category ne 'notice'}">
								  	<a href="./reply?boardNum=${notice.boardNum}" class="btn btn-primary">답글</a>							  								  
								  </c:if>
							  </div>
                		</div>
	                </div>          
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
            
            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->
		</div>	
	</div>
	
	<c:import url="/WEB-INF/views/tamplate/foot.jsp"></c:import>
</body>
</html>