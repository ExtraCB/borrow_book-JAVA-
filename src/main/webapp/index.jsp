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

						<form action="borrow_controller" method="post">
							<div class="input-group mb-3">
								<input type="text" class="form-control" name="search_result"
									placeholder="" aria-label="Example text with button addon"
									aria-describedby="button-addon1" required>
								<button class="btn btn-outline-success" type="submit"
									id="button-addon1">ค้นหา</button>
								<input type="hidden" name="mode" value="search_book" />
								<a href="borrow_controller" class="btn btn-primary">refresh</a>
							</div>
						</form>


						<div class="row">
							<div class="col-8"></div>
							<div class="col-4">
								<a href="borrow_controller?mode=stats"
									class="btn btn-outline-success ">ข้อมูลสถิติ</a>
									<a href="borrow_controller?mode=borrow"
									class="btn btn-outline-success ">ยืม-คืนหนังสือ</a>
							</div>


						</div>


						<table class="table">
							<thead>
								<tr>
									<th>รหัสหนังสือ</th>
									<th>ชื่อหนังสือ</th>
									<th>ผู้ยืม-คืน</th>
									<th>วันที่ยืม</th>
									<th>วันที่คืน</th>
									<th>ค่าปรับ</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (Borrow_Model brmd : borrow_list) {
								%>

								<tr>
									<td><%=brmd.getBook().getB_id()%></td>
									<td><%=brmd.getBook().getB_name()%></td>
									<td><%=brmd.getUsr().getM_name()%></td>
									<td><%=brmd.getBr_date_br()%></td>
									<td><%=brmd.getBr_date_rt()%></td>
									<td><%=brmd.getBr_fine()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
