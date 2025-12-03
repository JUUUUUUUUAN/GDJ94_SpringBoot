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
	                                <h6 class="m-0 font-weight-bold">회원 정보 입력</h6>
	                            </div>

	                            <div class="card-body">
	                                <form method="post" enctype="multipart/form-data">

	                                    <!-- ID -->
	                                    <div class="mb-3">
	                                        <label class="form-label">아이디</label>
	                                        <input type="text" name="username" class="form-control">
	                                    </div>

	                                    <!-- Password -->
	                                    <div class="mb-3">
	                                        <label class="form-label">비밀번호</label>
	                                        <input type="password" name="password" class="form-control">
	                                    </div>

	                                    <!-- Name -->
	                                    <div class="mb-3">
	                                        <label class="form-label">이름</label>
	                                        <input type="text" name="name" class="form-control">
	                                    </div>

	                                    <!-- Email -->
	                                    <div class="mb-3">
	                                        <label class="form-label">이메일</label>
	                                        <input type="email" name="email" class="form-control">
	                                    </div>

	                                    <!-- Phone -->
	                                    <div class="mb-3">
	                                        <label class="form-label">전화번호</label>
	                                        <input type="text" name="phone" class="form-control" placeholder="010-0000-0000">
	                                    </div>

	                                    <!-- Birth -->
	                                    <div class="mb-3">
	                                        <label class="form-label">생년월일</label>
	                                        <input type="date" name="birth" class="form-control">
	                                    </div>
	                                    
	                                    <!-- 이미지 -->
	                                    <div>
	                                    	<input type="file" name="img">
	                                    </div>

	                                    <div class="text-center mt-4">
	                                        <button type="submit" class="btn btn-primary btn-block w-100">
	                                            회원가입
	                                        </button>
	                                    </div>

	                                </form>
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