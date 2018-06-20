<div class="container-fluid">
	<div class="row">
	   
	   <!-- Losding the sidebar  -->
		<div class="col-md-3">
		
			 <%@include file="./shared/sidebar.jsp" %>
		
		</div>	
		
		<!-- Loading the actual Information  -->
		<div class="col-md-9">
		
			<!-- Loading the Breadcrum  -->
			<div class="row">
			
				<div class="col-lg-12">
				    
				    <c:if test="${userClickAllInformation == true}">
				    <script>
				    	window.categoryId = '';
				    </script>
						
						<ol class="breadcrumb">
						
							<li><a href="${contextRoot}/about">Home / </a></li>
							<li class="active">About Main</li>
						
						</ol>
						
					</c:if>
					
					<c:if test="${userClickCategoryInformation == true}">
					<script>
					    window.categoryId = ${category.id};
				    </script>
					
						<ol class="breadcrumb">
						
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active"> / category</li>
							<li class="active"> / ${category.name}</li>
						
						</ol>
						
					</c:if>
					
				</div>
			
			</div>
			
		<div class="row">
			<div class="col-lg-12">
				<c:if test="${title == 'Basic' || title == 'About Us'}">
					<c:forEach items="${information_list}" var="infoList">
						<a href="#${infoList.id}" class="btn btn-info"> ${infoList.name} </a>
					</c:forEach>   	
				</c:if>
				
				<c:if test="${title == 'Education'}">
					<c:forEach items="${information_list}" var="infoList">
						<a href="#${infoList.id}" class="btn btn-info"> ${infoList.name} </a>
					</c:forEach> 
				</c:if>
				
				<c:if  test="${title == 'struggle'}">
					<c:forEach items="${information_list}" var="infoList">
						<a href="#${infoList.id}" class="btn btn-info"> ${infoList.name} </a>
					</c:forEach>   	
				</c:if>
				
				<c:if  test="${title == 'Carrier'}">
					<c:forEach items= "${information_list}" var="infoList">
						<a href="#${infoList.id}" class="btn btn-info"> ${infoList.name} </a>
					</c:forEach>    	
				</c:if>		
					   	
				
			</div>
		</div>
		<hr/>
		
		<div class="row">
			<div class="col-xs-12">
			 
			 
				 <c:forEach items= "${information_list}" var="infoList">
				 
					<h2 id="${infoList.id}"> ${infoList.name}</h2>
					
						<c:if test="${infoList.url1 != null}">
							<img src="${images}/${infoList.url1}.jpg"/>
						</c:if>
						
						<p> ${infoList.description1} </p>
						
						<c:if test="${infoList.url2 != null}">
							<img src="${images}/${infoList.url2}.jpg"/>
						</c:if>
						
						<p> ${infoList.description2} </p>
						
						<c:if test="${infoList.url3 != null}">
							<img src="${images}/${infoList.url3}.jpg"/>
						</c:if>
					<p> ${infoList.description3} </p>
					<hr/>
				</c:forEach>
			
			 
			</div> 	 
		 </div>		
 		
 		
		</div>
			
	</div>

</div>