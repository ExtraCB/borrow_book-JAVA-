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
								<a href="borrow_controller?mode=borrow"
									class="btn btn-outline-success">ยืนหนังสือ </a> <a href="borrow_controller?mode=return"
									class="btn btn-outline-success active">คืนหนังสือ</a>


								
							</div>
							<div class="col-4"></div>
						</div>
						<div class="row">
							<div class="col">
							<form action="borrow_controller" method="post">
									<div class="input-group mb-3">
										<input type="text" class="form-control" name="search"
											placeholder="" aria-label="Example text with button addon"
											aria-describedby="button-addon1">
										<button class="btn btn-outline-success" type="submit"
											id="button-addon1" name="mode" value="search_return">ค้นหา</button>
									</div>
								</form>
							</div>
						</div>
						<div class="row">
							<div class="col text-center">
								<h3 style="text-align: center;">หนังสือที่ยังไม่ได้รับการคืน</h3>
								<%
								ArrayList<Borrow_Model> brm = (ArrayList<Borrow_Model>) request.getAttribute("bnotrt");
								%>

								<table class="table">
									<thead>
										<tr>
											<th>รหัสหนังสือ</th>
											<th>ชื่อหนังสือ</th>
											<th>ผู้ยืม-คืน</th>
											<th>วันที่ยืม</th>
											<th>วันที่คืน</th>
											<th>ค่าปรับ</th>
											<th>จัดการ</th>
										</tr>
									</thead>
									<tbody>
										<%
										for (Borrow_Model brmd : brm) {
										%>

										<tr>
											<td><%=brmd.getBook().getB_id()%></td>
											<td><%=brmd.getBook().getB_name()%></td>
											<td><%=brmd.getUsr().getM_name()%></td>
											<td><%=brmd.getBr_date_br()%></td>
											<td><%=brmd.getBr_date_rt()%></td>
											<td><%=brmd.getBr_fine()%></td>
											<td>
												<!-- Button trigger modal -->
												<button type="button" class="btn btn-outline-primary"
													data-bs-toggle="modal"
													data-bs-target="#staticBackdrop<%=brmd.getBr_date_br() + brmd.getBook().getB_id() + brmd.getUsr().getM_user()%>">
													คืนหนังสือ</button> <!-- Modal -->
												<div class="modal fade "
													id="staticBackdrop<%=brmd.getBr_date_br() + brmd.getBook().getB_id() + brmd.getUsr().getM_user()%>"
													data-bs-backdrop="static" data-bs-keyboard="false"
													tabindex="-1" aria-labelledby="staticBackdropLabel"
													aria-hidden="true">
													<div class="modal-dialog modal-dialog-centered">
														<form action="borrow_controller" method="post">
															<div class="modal-content">
																<div class="modal-header">
																	<h1 class="modal-title fs-5" id="staticBackdropLabel">คืนหนังสือ</h1>
																	<button type="button" class="btn-close"
																		data-bs-dismiss="modal" aria-label="Close"></button>
																</div>
																<div class="modal-body">
																	<div class="input-group mb-3">
																		<span class="input-group-text" id="basic-addon1">ผู้ยืมหนังสือ</span>
																		<input type="text" class="form-control"
																			placeholder="Username" aria-label="Username"
																			aria-describedby="basic-addon1" disabled
																			value="<%=brmd.getUsr().getM_name()%>">
																	</div>

																	<div class="input-group mb-3">
																		<span class="input-group-text" id="basic-addon1">หนังสือที่ยังไม่ได้คืน</span>
																		<input type="text" class="form-control"
																			placeholder="Username" aria-label="Username"
																			aria-describedby="basic-addon1" disabled
																			value="<%=brmd.getBook().getB_name()%>">
																	</div>

																	<div class="input-group mb-3">
																		<span class="input-group-text" id="basic-addon1">วันที่ที่ยืม</span>
																		<input type="text" class="form-control"
																			placeholder="Username" aria-label="Username"
																			aria-describedby="basic-addon1" disabled
																			value="<%=brmd.getBr_date_br()%>">
																	</div>
																	<div class="input-group mb-3">
																		<span class="input-group-text" id="basic-addon1">วันที่ที่คืน</span>
																		<input type="date" class="form-control"
																			placeholder="โปรดเลือกวันที่จะคืนหนังสือ"
																			name="date_rt" aria-describedby="basic-addon1">
																	</div>

																	<div class="input-group mb-3">
																		<span class="input-group-text" id="basic-addon1">ค่าปรับ</span>
																		<input type="number" class="form-control"
																			placeholder="โปรดเลือกวันที่จะคืนหนังสือ" name="fine"
																			aria-describedby="basic-addon1">
																	</div>

																	<input type="hidden" name="br_date_br"
																		value="<%=brmd.getBr_date_br()%>"> <input
																		type="hidden" name="b_id"
																		value="<%=brmd.getBook().getB_id()%>"> <input
																		type="hidden" name="m_id"
																		value="<%=brmd.getUsr().getM_user()%>">
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-bs-dismiss="modal">Close</button>
																	<button type="submit" name="mode" value="return_submit"
																		class="btn btn-primary">ยืนยัน</button>
																</div>
														</form>

													</div>

												</div>
												</div>

											</td>
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
		</div>
</body>
</html>
