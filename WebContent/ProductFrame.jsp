<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Product</title>
<link rel='stylesheet'
	href='<%=org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css")%>'>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator.getWebJarPath("jquery.min.js")%>'></script>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js")%>'></script>
<script type='text/javascript' src='js/product-page.js'></script>

<link href="css/shop-homepage.css" rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
	<c:import url="NavigationBar.jsp" />

	<!-- Page Content -->
	<form action="<c:url value="/edit"/>" method="POST" role="form">
		<div class="container">
			<div class="row">
				<div class="col-sm-1 col-lg-1 col-md-1">
					<div>ID</div>
					<div>
						<input name="id" type="text" class="form-control input-md"
							value="<c:out value="${pForm.id}"/>" readonly>
					</div>
				</div>
				<div class="col-sm-2 col-lg-2 col-md-2">
					<div>PRODUCT ID</div>
					<div>
						<input name="product_id" type="text" class="form-control input-md"
							value="<c:out value="${pForm.product_id}"/>">
					</div>
					<div>VIEW COUNT</div>
					<div><input name="id" type="text" class="form-control input-md"
							value="<c:out value="${productsViewCount}"/>" readonly></div>
				</div>
				<div class="col-sm-3 col-lg-3 col-md-3">
					<div>TITLE</div>
					<div>
						<textarea name="title" class="form-control has-feedback" rows="3"
							style="resize: none"><c:out value="${pForm.title}"/></textarea>
						<span class="glyphicon form-control-feedback"
							style="top: 27; right: 15"></span>
					</div>

				</div>
				<div class="col-sm-6 col-lg-6 col-md-6">
					<div>DESCRIPTION</div>
					<div>
						<textarea name="description" class="form-control" rows="7"
							style="resize: none"><c:out value="${pForm.description}"/></textarea>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-1 col-lg-1 col-md-1">
					<div>RATING</div>
					<div>
						<input name="rating" type="text" class="form-control input-md"
							value="<c:out value="${pForm.rating}"/>">
					</div>
				</div>
				<div class="col-sm-2 col-lg-2 col-md-2">
					<div>PRICE</div>
					<div>
						<input name="price" type="text" class="form-control input-md"
							value="<c:out value="${pForm.price}" />">
					</div>
				</div>
				<div class="col-sm-2 col-lg-2 col-md-2">
					<div>INET PRICE</div>
					<div>
						<input name="inet_price" type="text" class="form-control input-md"
							value="<c:out value="${pForm.inet_price}" />">
					</div>
				</div>
				<div class="col-sm-4 col-lg-4 col-md-4">
					<div>IMAGE</div>
					<div>
						<input name="image" type="text" class="form-control input-md"
							value="<c:out value="${pForm.image}" />">
					</div>
				</div>
				<div class="col-sm-3 col-lg-3 col-md-3">
					<div>&nbsp;</div>
					<div>
						<input type="submit" value="Create" name="Create" />
						<input type="submit" value="Delete" name="Delete" />
						<input type="submit" value="Cancel" name="Cancel" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>