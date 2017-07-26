<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Management</title>
	<link rel='stylesheet' href='<%=org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css")%>'>
	<script type='text/javascript' src='<%=org.webjars.AssetLocator.getWebJarPath("jquery.min.js")%>'></script>
	<script type='text/javascript' src='<%=org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js")%>'></script>
	
	<%-- <script type='text/javascript' src='js/service-page.js'></script>  --%>
	<link href="css/shop-homepage.css" rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
    <c:import url="NavigationBar.jsp" />
    
    <!-- Page Content -->
		<div class="container">
			<div class="row">
			Select file from your PC: 
			</div>
			<div class="row">
			<form method="POST" action="<c:url value="/service"/>" enctype="multipart/form-data">
				
				<div class="col-sm-6 col-lg-6 col-md-6">
					<input type="file" name="file" id="file" />
				</div>
				<div class="col-sm-6 col-lg-6 col-md-6">
					<input type="submit" value="Upload" name="Upload" id="Upload" />
				</div>
			</form>
			</div>
			<div class="row">
			Or select path to it: 
			</div>
			<div class="row">
				<div class="col-sm-6 col-lg-6 col-md-6">
					<input type="text" value="" name="filepath" />
				</div>
				<div class="col-sm-6 col-lg-6 col-md-6">
					<input type="submit" value="Apply" name="Apply" id="Apply" />
				</div>
			</div>
			
		</div>
	
</body>

</html>