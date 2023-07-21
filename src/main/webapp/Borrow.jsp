<%@page import="model.Member_Model"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Borrow_Model"%>

<%
ArrayList<Borrow_Model> borrow_list = (ArrayList<Borrow_Model>) request.getAttribute("borrowlist");



%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" />
<script src="webjars/bootstrap/5.3.0/js/bootstrap.bundle.js"></script>
</head>
<body>
	<div
		class="container d-flex align-items-center justify-content-center vh-100">
		<div class="row">
			<div class="col">
				<div class="card rounded" style="width: 60rem;">
					<div class="card-body ">
						<h4 class="text-center">การจัดการข้อมูลการยืมหนังสือ-ยืมหนังสือ</h4>


						<div class="row mb-5 mt-4">
							<div class="col-4"></div>
							<div class="col-4 text-center">
								<a href="Borrow.jsp?form=1"
									class="btn btn-outline-success ">ยืนหนังสือ </a> <a
									href="Borrow.jsp?form=2"
									class="btn btn-outline-success ">คืนหนังสือ</a>
							</div>
							<div class="col-4"></div>
						</div>
						
						
						
						<div class="row">
						<div class="col-4"></div>
							<div class="col-4">
							<% 
							String form = (String) request.getParameter("form");

							
							if(form != null && form.equals("1")){ %>
								<form action="borrow_controller" method="post">
									<h3 style="text-align:center;">ยืมหนังสือ</h3>
									
									<label class="form-label">
										ผู้ที่ต้องการยืม : 
									</label>
									<select class="form-control">
									<option selected>โปรดเลือก ผู้ที่ต้องการยืมหนังสือ</option>
									<% 
									ArrayList<Member_Model> mm =  (ArrayList<Member_Model>)request.getAttribute("MemberAll");
									
									
									for(Member_Model ml : mm) { %>
										<option value="<%= ml.getM_user() %>"><%= ml.getM_user() + "  " + ml.getM_name() %></option>
									<%  }
									%>
									</select>
									
								</form>
							<% }  %>
							</div>
						</div>


<div class="col-4"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
