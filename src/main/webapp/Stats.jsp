<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.ArrayList" %>

<%@page import="java.util.List"%>
<%@page import="model.Stats_Model"%>


<%



ArrayList<Stats_Model>  stats_data = (ArrayList<Stats_Model>) request.getAttribute("stats_result");
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
				<div class="card rounded " style="width: 60rem;">
					<div class="card-body ">
						<h4 class="text-center">ข้อมูลสถิติของห้องสมุด</h4>
						<a href="borrow_controller" class="btn btn-primary">Homepage</a>
						
						<div class="row row-cols-2">
						<% for(Stats_Model stm : stats_data){ %>
							<div class="col">
								<div class="card shadow m-3" style="height:150px;">
									<div class="card-body ">
										<h1 style="text-align:center;"><%= stm.getCount() %></h1> <br>
										<h3 style="text-align:center;"><%= stm.getName() %></h3>
									</div>
								</div>
							</div>
						<% }  %>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
