   <!-- Portfolio Description -->

    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="text-center">
            <h2>Portfolio</h2>
            <p>Lorem ipsum dolor sit amet consectetur adipiscing elit Cras suscipit arcu<br>
            vestibulum volutpat libero sollicitudin vitae Curabitur ac aliquam <br>
            </p>
			       
          <div class="">
          	<a href="${contextRoot}/portfolio/public" class="btn btn-primary">
          		Public
          	</a>
          	<a href="${contextRoot}/portfolio/personal" class="btn btn-light">
  				Personal
          	</a> 
          </div>
             
          </div>
          
        </div>
      </div>
    </div>


    <!-- End of Portfolio Description -->


    <!-- Photos -->

    <div class="container-fluid">
  		<div class="row"><div class="col">
		    <c:forEach items="${imageList}" var="imgCode">
		    	<a href="${images}/${imgCode.code}.jpg" class="flipLightBox">
		   			<img src="${images}/${imgCode.code}.jpg" style="margin-top:5px;"/>
		          	 <span><b>${imgCode.imgName}</b> ${imgCode.description}</span>
		        </a>
		    </c:forEach>
		</div>    </div>
     </div>

 

<a href="javascript:void(0);" title="Go To Top" id="scroll" style="display:none;">
      <span> </span>
    </a>
