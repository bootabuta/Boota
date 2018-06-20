<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="jquery" value="/resources/jquery" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Boota Singh - ${title}</title>
    <script>
    window.menu = '${title}';
    window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="${css}/app.css" rel="stylesheet">
    
     <!-- dataTable Bootstrap CSS -->
    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation Loading Here -->
    <%@include file="./shared/navbar.jsp" %>

    <!-- Page Content Loading Here -->
    <c:if test="${userClickHome == true }" >
    <%@include file="home.jsp" %>
    </c:if>
    
    <c:if test="${userClickPortfolio == true }" >
    <%@include file="portfolio.jsp" %>
    </c:if>
    
    <c:if test="${userClickResume == true }" >
    <%@include file="resume.jsp" %>
    </c:if>
    
    <c:if test="${userClickBlogs == true }" >
    <%@include file="blogs.jsp" %>
    </c:if>
    
    <c:if test="${userClickAllInformation == true  or userClickCategoryInformation == true }" >
    <%@include file="listInformation.jsp" %>
    </c:if>

	<c:if test="${userClickContact == true }" >
    <%@include file="contact.jsp" %>
    </c:if>
    
    <!-- Footer Loading Here -->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${jquery}/jquery.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <script src="${js}/responsiveslides.min.js"></script>
     <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap4.js"></script>
   
    
    <c:if test="${userClickPortfolio == true }" >
     <script src="${jquery}/jquery-2-2-2.js"></script>
     <script src="${js}/fliplightbox.min.js"></script>
      <script type="text/javascript">$('body').flipLightBox()</script>
    </c:if>
    
    <script src="${js}/app.js"></script>
    
    
	<script type="text/javascript">
 		$(function () {		
      		$("#slider").responsiveSlides({
        		maxwidth: 800,
        		speed: 800
      		});
	    });  
	</script>
    
    
      <script type="text/javascript">
      $(document).ready(function(){
        $(window).scroll(function(){
          if($(this).scrollTop()>100){
            $('#scroll').fadeIn();
          }
          else {
           $('#scroll').fadeOut(); 
          }
        })
    })

    $('#scroll').click(function(){
      $("html,body").animate({scrollTop:0},600);
      return false;
    })  
    </script>
    

  </body>

</html>