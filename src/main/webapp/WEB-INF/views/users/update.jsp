<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <h1 class="h3 mb-0 text-gray-800">회원가입</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
	                <!-- Content Row -->
	                <div class="row">
	                <!-- 생성한 contents 작성 -->
	                <div class="col-lg-6">

	                        <!-- 회원가입 카드 -->
	                        <div class="card shadow mb-4">
	                            <div class="card-header py-3 bg-primary text-white">
	                                <h6 class="m-0 font-weight-bold">회원 정보 수정</h6>
	                            </div>

	                            <div class="card-body">
	                            	
	                            	<form:form modelAttribute="userDTO" method="post" enctype="multipart/form-data">
	                                    <!-- Name -->
	                                    <div class="mb-3">
	                                        <label class="form-label">이름</label>
	                                        <form:input path="name" id="name" cssClass="form-control"/>
	                                        <form:errors path="name"></form:errors>
	                                    </div>

	                                    <!-- Email -->
	                                    <div class="mb-3">
	                                        <label class="form-label">이메일</label>
	                                        <form:input path="email" id="email" cssClass="form-control"/>
	                                        <form:errors path="email"></form:errors>
	                                    </div>

	                                    <!-- Phone -->
	                                    <div class="mb-3">
	                                        <label class="form-label">전화번호</label>
	                                        <form:input path="phone" id="phone" cssClass="form-control"/>
	                                        <form:errors path="phone"></form:errors>
	                                    </div>

	                                    <!-- Birth -->
	                                    <div class="mb-3">
	                                        <label class="form-label">생년월일</label>
	                                        <form:input path="birth" id="birth" type="date"/>
	                                        <form:errors path="birth"></form:errors>
	                                    </div>

	                                    <div class="text-center mt-4">
	                                        <button type="submit" class="btn btn-primary btn-block w-100">
	                                            수정
	                                        </button>
	                                    </div>

	                                </form:form>
	                            </div>
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