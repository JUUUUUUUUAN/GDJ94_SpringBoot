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
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
	                <!-- Content Row -->
	                <div class="row">
	                <!-- 생성한 contents 작성 -->
					<div class="container mt-5 col-sm-8">
					  <div class="card shadow">
					
					    <!-- Card Header -->
					    <div class="card-header text-white" style="background-color:#f4c542;">
					      <h4 class="mb-0">Add New Product</h4>
					    </div>
					
					    <div class="card-body">
					      <form method="post">
					
					        <!-- Product Name -->
					        <div class="form-group mt-3">
					          <label for="name">Product Name</label>
					          <input 
					            type="text" 
					            class="form-control" 
					            id="name" 
					            name="productName" 
					            required>
					        </div>
					
					        <!-- Contents -->
					        <div class="form-group mt-3">
					          <label for="contents">Contents</label>
					          <textarea 
					            class="form-control" 
					            id="contents" 
					            name="productContents" 
					            rows="5"
					          ></textarea>
					        </div>
					
					        <!-- Category -->
					        <div class="form-group mt-3">
					          <label for="category">Category</label>
					          <input 
					            type="text" 
					            class="form-control" 
					            id="category" 
					            name="productCategory">
					        </div>
					
					        <!-- Rate -->
					        <div class="form-group mt-3">
					          <label for="rate">Rate (0.00 ~ 9.99)</label>
					          <input type="number" step="0.01" max="9.99" min="0" 
					            class="form-control" id="rate" name="productRate" required>
					        </div>
					
					        <!-- Sale 여부 -->
					        <div class="form-group mt-3">
					          <label for="sale">종료여부</label>
					          <select class="form-control" id="sale" name="productSale">
					            <option value="0">No</option>
					            <option value="1">Yes</option>
					          </select>
					        </div>
					
					        <!-- Submit Button -->
					        <div class="mt-4 text-center">
					          <button type="submit" class="btn text-white px-4"
					            style="background-color:#f4c542; font-weight:bold;">
					            Add
					          </button>
					        </div>
					
					      </form>
					      <!-- ★ form 태그 끝 ★ -->
					
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