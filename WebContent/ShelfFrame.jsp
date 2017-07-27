<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>mmmVideo</title>
<link rel='stylesheet'
	href='<%=org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css")%>'>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator.getWebJarPath("jquery.min.js")%>'></script>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js")%>'></script>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator.getWebJarPath("dist/plotly.js")%>'></script>

<!-- Custom CSS -->
<link href="css/style.css" rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<!-- Navigation -->
	<c:import url="NavigationBar.jsp" />

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<p class="lead">Quality</p>
				<div class="list-group checked-list-box showing">
					<a class="list-group-item">Excellent</a>
					<a class="list-group-item">Good</a>
					<a class="list-group-item">Bad</a>
				</div>
				<p class="lead">Sort</p>
				<div class="list-group checked-list-box sorting">
					<a class="list-group-item">Price</a>
					<a class="list-group-item">Rating</a>
					<a class="list-group-item">ID</a>
					<a class="list-group-item">Title</a>
				</div>
			</div>
			<div class="col-md-9">
				<div class="row">
					<div id="productPlot"></div>
					<script>
			            var plotData = [];
			            Plotly.newPlot("productPlot", []);
			            
					    <c:forEach items="${productsViewCount}" var="timeAndCount" varStatus="i">
					    	var time = [];
					    	var count = [];
					   		<c:forEach items="${timeAndCount.value}" var="pair" varStatus="j">
					   			time.push(new Date(${pair.key}));
					   			count.push("${pair.value}");
					         </c:forEach>
					         Plotly.addTraces("productPlot", {x: time , y: count, name: "ID: ${timeAndCount.key}"});
					    </c:forEach>
			    	</script>
				</div>
				<div class="row">
					<c:forEach var="product" items="${form.products}">
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail" sTitle="${product.title}" sPrice="${product.price}" 
													sId="${product.product_id}" sRating="${product.rating}">
								<a href="${pageContext.request.contextPath}/edit?id=${product.id}">
									<img src="<c:out value="${product.image}"/>" alt="ID:<c:out value="${product.product_id}"/>">
								</a>
								<div class="caption" >
									<h4 class="title">
										<a href="${pageContext.request.contextPath}/edit?id=${product.id}"><c:out
												value="${product.title}" /></a>
									</h4>
									<h4 class="price pull-right" name="">
										$
										<c:out value="${product.price}" />
									</h4>
								</div>
								<div class="rating" >
									<p>
										<c:out value="${product.rating}" />
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<div class="container">
		<hr>
		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; 2017 https://startbootstrap.com/template-overviews/shop-homepage</p>
				</div>
			</div>
		</footer>
	</div>
		<ul>
		    <li>Banana</li>
		    <li>Carrot</li>
		    <li>Apple</li>
		</ul>
		
	<!-- Custom JS -->
	<script type='text/javascript' src='js/shelf-page.js'></script>
</body>

</html>