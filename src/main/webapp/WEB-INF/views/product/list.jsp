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
                        <h1 class="h3 mb-0 text-gray-800">금융상품</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
	                <!-- Content Row -->
	                <div class="row">
	                <!-- 생성한 contents 작성 -->
					<table class="table table-hover mt-5 col-sm-8 mx-auto">
					  <thead style="background-color: #ffe98a;">
					    <tr>
					      <th scope="col">Name</th>
					      <th scope="col">Category</th>
					      <th scope="col">Rate</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach items="${list}" var="product">
					      <tr>
					        <td>
					        ${product.productNum}
					        </td>
					        <td>
					        <a href="./detail?productNum=${product.productNum}">${product.productName}</a>
					        </td>
					        <td>
					          <span class="badge" 
					                style="background-color: #ffd24c; font-size: 1rem;">
					            ★ ${product.productRate}
					          </span>
					        </td>
					      </tr>					  	
					  	</c:forEach>
					  </tbody>
					</table>
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