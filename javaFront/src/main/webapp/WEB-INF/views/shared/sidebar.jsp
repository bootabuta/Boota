<h1 class="my-4">Boota Singh</h1>

     <div class="list-group">
     
     	<c:forEach items="${categories}" var="category">
     		<a href="${contextRoot}/show/category/${category.id}/information" id="a_${category.name}" class="list-group-item">${category.name}</a>
     	</c:forEach>
           
    </div>