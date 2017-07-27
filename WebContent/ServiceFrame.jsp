<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Management</title>
	<link rel='stylesheet' href='<%=org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css")%>'>
	<script type='text/javascript' src='<%=org.webjars.AssetLocator.getWebJarPath("jquery.min.js")%>'></script>
	<script type='text/javascript' src='<%=org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js")%>'></script>
	
	<%-- <script type='text/javascript' src='js/service-page.js'></script>  --%>
	<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
    <c:import url="NavigationBar.jsp" />
    
    <!-- Page Content -->
    <form method="POST" action="<c:url value="/service"/>" enctype="multipart/form-data">
		<div class="container">
			<div class="row">
			Select file from your PC: 
			</div>
			<div class="row">
			
				<div class="col-sm-6 col-lg-6 col-md-6">
					<input type="file" name="file" id="file" />
				</div>
				<div class="col-sm-6 col-lg-6 col-md-6">
					<input type="submit" value="Upload" name="Upload" id="Upload" />
				</div>
			
			</div>
			<div class="row">
			Or select path to it: 
			</div>
			<div class="row">
				<div class="col-sm-6 col-lg-6 col-md-6">
					<input type="text" value="${savedpath}" name="filepath" />
					
				</div>
				<div class="col-sm-6 col-lg-6 col-md-6">
					<input type="submit" value="Apply" name="Apply" id="Apply" />
				</div>
				Update period 'once in 24 hour' for 'select path' option. You can change it in source code ;)
			</div>
			
		</div>
	</form>
</body>

</html>