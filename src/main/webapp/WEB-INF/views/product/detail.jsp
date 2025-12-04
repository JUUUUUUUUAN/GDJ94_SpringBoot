<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>금융상품 상세보기</title>
<c:import url="/WEB-INF/views/tamplate/head.jsp"></c:import>

<style>
	.detail-label {
		font-weight: bold;
		color: #555;
	}
	.detail-value {
		font-size: 1.05rem;
		color: #333;
	}
</style>
</head>

<body id="page-top">
	<div id="wrapper">

		<!-- sidebar -->
		<c:import url="/WEB-INF/views/tamplate/sidebar.jsp"></c:import>
		<!-- sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<c:import url="/WEB-INF/views/tamplate/topbar.jsp"></c:import>
				<!-- Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Heading -->
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">금융상품 상세보기</h1>

						<a href="../list" class="d-none d-sm-inline-block btn btn-sm btn-secondary shadow-sm">
							<i class="fas fa-arrow-left fa-sm text-white-50"></i> 목록으로
						</a>
					</div>

					<div class="row justify-content-center">
						<div class="col-lg-8">

							<!-- 상세 카드 -->
							<div class="card shadow mb-4">
								<div class="card-header py-3 bg-primary text-white">
									<h6 class="m-0 font-weight-bold">상품 정보</h6>
								</div>

								<div class="card-body">
									<!-- Name -->
									<div class="mb-3">
										<div class="detail-label">상품명</div>
										<div class="detail-value">${product.productName}</div>
									</div>

									<!-- Contents -->
									<div class="mb-3">
										<div class="detail-label">설명</div>
										<div class="detail-value" style="white-space: pre-line;">
											${product.productContents}
										</div>
									</div>

									<!-- Category -->
									<div class="mb-3">
										<div class="detail-label">카테고리</div>
										<div class="detail-value">${product.productCategory}</div>
									</div>

									<!-- Rate -->
									<div class="mb-3">
										<div class="detail-label">금리</div>
										<span class="badge" 
											  style="background-color: #ffd24c; font-size: 1rem;">
											★ ${product.productRate}
										</span>
									</div>

									<!-- Sale -->
									<div class="mb-3">
										<div class="detail-label">판매 여부</div>
										<c:choose>
											<c:when test="${product.productSale}">
												<span class="badge bg-danger">판매 중지</span>
											</c:when>
											<c:otherwise>
												<span class="badge bg-success">판매중</span>
											</c:otherwise>
										</c:choose>
									</div>

									<!-- Back Button -->
									<div class="text-end mt-4">
										<a href="./list" class="btn btn-secondary">
											← 목록으로
										</a>
										<a href="./update?productNum=${product.productNum}" class="btn btn-success">수정</a>
										<a href="./delete?productNum=${product.productNum}" class="btn btn-danger">삭제</a>
									</div>

								</div>
							</div>

						</div>
					</div>

				</div>
				<!-- End Page Content -->

			</div>
			<!-- End Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- End Content Wrapper -->

	</div>
	<!-- End Wrapper -->

	<c:import url="/WEB-INF/views/tamplate/foot.jsp"></c:import>
</body>
</html>
