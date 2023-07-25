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
								<a href="" class="btn btn-outline-success  active">ยืนหนังสือ
								</a> <a href="borrow_controller?mode=return"
									class="btn btn-outline-success ">คืนหนังสือ</a>
							</div>
							<div class="col-4"></div>
						</div>



						<div class="row">
							<div class="col-4"></div>
							<div class="col-4">
								<form action="" method="post">
									<h3 style="text-align: center;">ยืมหนังสือ</h3>

									<label class="form-label"> ผู้ที่ต้องการยืม : </label> <select
										class="form-control" id="selectMember">
										<option selected>โปรดเลือก ผู้ที่ต้องการยืมหนังสือ</option>
										<%
										ArrayList<Member_Model> mm = (ArrayList<Member_Model>) request.getAttribute("MemberAll");

										for (Member_Model ml : mm) {
										%>
										<option value="<%=ml.getM_user()%>"><%=ml.getM_user() + "  " + ml.getM_name()%></option>
										<%
										}
										%>
									</select> <label class="form-label">หนังสือที่ต้องการยืม : </label> <select
										class="form-control" id="selectBook">
										<option selected>โปรดเลือก หนังสือที่ต้องการยืม</option>
										<%
										ArrayList<Book_Model> bm = (ArrayList<Book_Model>) request.getAttribute("BookAll");

										for (Book_Model bbm : bm) {
										%>
										<option value="<%=bbm.getB_id()%>"><%=bbm.getB_id() + "  " + bbm.getB_name()%></option>
										<%
										}
										%>
									</select>
								</form>
								<hr />

								<form action="borrow_controller" method="post">
									<label class="form-label">ผู้ที่ต้องการยืม : </label> <input
										type="text" class="form-control" name="showMember"
										id="showMember" required /> <label class="form-label">หนังสือต้องการยืม
										: </label> <input type="text" class="form-control" name="showBook"
										id="showBook" required /> <label class="form-label">วันที่ยืม
										: </label> <input type="date" class="form-control" name="DateSelected"
										required /> <input type="hidden" name="b_id" id="bid" /> <input
										type="hidden" name="m_id" id="mid" />


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
	<script>
		const bookselect = document.getElementById('selectBook');
		const memberselect = document.getElementById('selectMember');

		const bid = document.getElementById('bid');
		const mid = document.getElementById('mid');

		const showMember = document.getElementById('showMember');
		const showBook = document.getElementById('showBook');

		bookselect
				.addEventListener(
						'change',
						function() {
							const selectBookValue = bookselect.value;
							const selectBookOption = bookselect.options[bookselect.selectedIndex];
							const selectBookContent = selectBookOption.textContent;
							const textBook = selectBookContent.trim();

							bid.value = selectBookValue;
							showBook.value = textBook;

							console.log("b id ", bid.value);
						});

		memberselect
				.addEventListener(
						'change',
						function() {
							const selectMemberValue = memberselect.value;
							const selectMemberOption = memberselect.options[memberselect.selectedIndex];
							const selectMemberContent = selectMemberOption.textContent;
							const textMember = selectMemberContent.trim();

							mid.value = selectMemberValue;
							showMember.value = textMember;

							console.log(mid.value);
						});
	</script>
</body>
</html>
