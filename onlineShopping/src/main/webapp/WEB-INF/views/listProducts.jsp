<div class="container">

	<div class="row">
		<!-- Would be dispaly sidebar -->

		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>

		<!-- To dispaly the actual Products -->
		<div class="col-md-9">
			<!--  Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts==true}">
						<o1 class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</li>
						</o1>
					</c:if>

					<c:if test="${userClickCatgoryProducts==true}">
						<o1 class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
						</o1>
					</c:if>
				</div>
			</div>
		</div>