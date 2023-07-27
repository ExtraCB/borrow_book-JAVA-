<%@page import="model.Book_Model"%>
<%@page import="model.Member_Model"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Borrow_Model"%>

<%
ArrayList<Borrow_Model> borrow_list = (ArrayList<Borrow_Model>) request.getAttribute("borrowlist");

String success = (String) session.getAttribute("success");
String error = (String) session.getAttribute("error");


String name_member = (String) session.getAttribute("name_memberFind");
String user_member = (String) session.getAttribute("user_memberFind");


String name_book = (String) session.getAttribute("name_BookFind");
String id_book = (String) session.getAttribute("id_BookFind");
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
				<%
				if (success != null) {
				%>
				<div class="alert alert-success">
					<%=success%>
					<%
					session.invalidate();
					%>
				</div>
				<%
				} else if (error != null) {
				%>
				<div class="alert alert-danger">
					<%=error%>
					<%
					session.invalidate();
					%>
				</div>
				<%
				}
				%>
				<div class="card rounded" style="width: 60rem;">
					<div class="card-body ">
						<h4 class="text-center">การจัดการข้อมูลการยืมหนังสือ-ยืมหนังสือ</h4>

						<div class="row mb-5 mt-4">
							<div class="col-4"></div>
							<div class="col-4 text-center">
								<a href="" class="btn btn-outline-success  active">ยืนหนังสือ
								</a> <a href="borrow_controller?mode=return"
									class="btn btn-outline-success ">คืนหนังสือ</a>
							</div>
							<div class="col-4"></div>
						</div>



						<div class="row">
							<div class="col-4"></div>
							<div class="col-4">

								<h3 style="text-align: center;">ยืมหนังสือ</h3>

								<label class="form-label"> ผู้ที่ต้องการยืม : </label>
								<form action="borrow_controller" method="post">

									<div class="input-group mb-3">

										<input type="text" class="form-control" name="search_member"
											placeholder="กรอกชื่อผู้ใช้ที่ต้องการยืม"
											aria-label="Recipient's username"
											aria-describedby="button-addon2">
										<button class="btn btn-outline-primary" name="mode"
											value="filter_member" type="submit" id="button-addon2">ตกลง</button>

									</div>
								</form>

								<label class="form-label">หนังสือที่ต้องการยืม : </label>
								
								<form action="borrow_controller" method="post">

								<div class="input-group mb-3">
									<input type="text" class="form-control" name="search_book"
										placeholder="หนังสือที่ต้องการยืม"
										aria-label="Recipient's username"
										aria-describedby="button-addon2">
									<button class="btn btn-outline-primary" type="submit" name="mode" value="filter_book"
										id="button-addon2">ตกลง</button>
								</div>
								
								</form>

								<hr />

								<form action="borrow_controller" method="post">
									<label class="form-label">ผู้ที่ต้องการยืม : </label> <input
										type="text" class="form-control" name="showMember" value="<%= name_member != null ? name_member : ""  %>" id="showMember" required />
										
										
										 
										<label class="form-label">หนังสือต้องการยืม: </label>
										 <input type="text" class="form-control" name="showBook" value="<%= name_book != null ? name_book : ""  %>"
										id="showBook" required /> 
										
										<label class="form-label">รหัสหนังสือต้องการยืม: </label>
										 <input type="text" class="form-control" name="b_id" value="<%= id_book != null ? id_book : ""  %>"
										id="showBook" required />
										
										<label class="form-label">วันที่ยืม
										: </label> 
										<input type="date" class="form-control" name="DateSelected" required /> 
										<input type="hidden" name="m_id" id="mid" value="<%= user_member != null ? user_member : ""  %>" />


									<button type="submit" class="btn btn-success mt-3" name="mode"
										value="borrow_submit">เพิ่มข้อมูล</button>
								</form>
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
