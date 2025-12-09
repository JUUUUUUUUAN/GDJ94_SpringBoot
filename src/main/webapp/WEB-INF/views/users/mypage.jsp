<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                        <h1 class="h3 mb-0 text-gray-800">마이페이지</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
	                <!-- Content Row -->
	                <div class="row">
	                <!-- 생성한 contents 작성 -->
	                	<div class="col-lg-7">

							<!-- Profile Card -->
							<div class="card shadow mb-4">

								<div class="card-header py-3 bg-primary text-white">
									<h6 class="m-0 font-weight-bold">내 정보</h6>
								</div>

								<div class="card-body">	
									
									<!-- Profile Image -->
									<div class="text-center mb-4">
										<div class="mt-2 text-muted">프로필 이미지</div>
										
									</div>
									
									<!-- Username -->
									<div class="mb-3">
										<div class="mypage-label">아이디</div>
										<div class="mypage-value">${user.username}</div>
									</div>

									<!-- Name -->
									<div class="mb-3">
										<div class="mypage-label">이름</div>
										<div class="mypage-value">${user.name}</div>
									</div>

									<!-- Email -->
									<div class="mb-3">
										<div class="mypage-label">이메일</div>
										<div class="mypage-value">${user.email}</div>
									</div>

									<!-- Phone -->
									<div class="mb-3">
										<div class="mypage-label">전화번호</div>
										<div class="mypage-value">${user.phone}</div>
									</div>

									<!-- Birth -->
									<div class="mb-3">
										<div class="mypage-label">생년월일</div>
										<div class="mypage-value">${user.birth}</div>
									</div>

									<!-- Buttons -->
									<div class="text-center mt-4">
										<a href="./update" class="btn btn-warning btn-sm px-4">정보 수정</a>
										<a href="./change" class="btn btn-secondary btn-sm px-4">비밀번호 변경</a>
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