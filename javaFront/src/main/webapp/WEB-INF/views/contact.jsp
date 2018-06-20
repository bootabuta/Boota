 
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
 
 
 <!-- Map View -->

    <div class="container-fluid">
          <div class="map">
            <iframe src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Kuningan,+Jakarta+Capital+Region,+Indonesia&amp;aq=3&amp;oq=kuningan+&amp;sll=37.0625,-95.677068&amp;sspn=37.410045,86.572266&amp;ie=UTF8&amp;hq=&amp;hnear=Kuningan&amp;t=m&amp;z=14&amp;ll=-6.238824,106.830177&amp;output=embed">
            </iframe>
          </div>
    </div>
    <br>
    <!-- End Map View -->

    <!-- Brief Intro -->

    <div>


<svg aria-hidden="true" style="position: absolute; width: 0; height: 0; overflow: hidden;" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
<defs>
<symbol id="icon-home3" viewBox="0 0 32 32">
<title>home3</title>
<path d="M32 19l-6-6v-9h-4v5l-6-6-16 16v1h4v10h10v-6h4v6h10v-10h4z"></path>
</symbol>
<symbol id="icon-phone" viewBox="0 0 32 32">
<title>phone</title>
<path d="M22 20c-2 2-2 4-4 4s-4-2-6-4-4-4-4-6 2-2 4-4-4-8-6-8-6 6-6 6c0 4 4.109 12.109 8 16s12 8 16 8c0 0 6-4 6-6s-6-8-8-6z"></path>
</symbol>
<symbol id="icon-mail2" viewBox="0 0 32 32">
<title>mail2</title>
<path d="M26.667 0h-21.333c-2.934 0-5.334 2.4-5.334 5.334v21.332c0 2.936 2.4 5.334 5.334 5.334h21.333c2.934 0 5.333-2.398 5.333-5.334v-21.332c0-2.934-2.399-5.334-5.333-5.334zM26.667 4c0.25 0 0.486 0.073 0.688 0.198l-11.355 9.388-11.355-9.387c0.202-0.125 0.439-0.198 0.689-0.198h21.333zM5.334 28c-0.060 0-0.119-0.005-0.178-0.013l7.051-9.78-0.914-0.914-7.293 7.293v-19.098l12 14.512 12-14.512v19.098l-7.293-7.293-0.914 0.914 7.051 9.78c-0.058 0.008-0.117 0.013-0.177 0.013h-21.333z"></path>
</symbol>
</defs>
</svg>



    </div>


    <div class="container">
      <div class="row">
        <div class="col-sm-4"><svg class="icon icon-mail2"><use xlink:href="#icon-mail2"></use></svg> Email :<br>
          bootabuta@gmail.com<br><br>
        </div>
        <div class="col-sm-4">
          <svg class="icon icon-phone"><use xlink:href="#icon-phone"></use></svg> Mobile No. : <br>
          (+91) 9815839081<br><br>
        </div>
        <div class="col-sm-4">
          <svg class="icon icon-home3"><use xlink:href="#icon-home3"></use></svg> Address<br>
          Boota Singh s/o Gurnam Singh,<br>
          VPO Panjawa Mandal,<br>
          Tehseel Abohar,
          Fazilka (Punjab),<br>
          India.<br><br>
        </div>

      </div>
      
    <c:if test="${not empty infoMessage}">	
		<div class="row">			
			<div class="col-xs-12 col-md-offset-2 col-md-8">			
				<div class="alert alert-success">${infoMessage}</div>				
			</div>
		</div>
	</c:if>

      <div class="row justify-content-center">
        <div class="col-md-6 ">
           <h2 class="">Drop Your Message</h2>
           
          <sf:form modelAttribute="message" action="${contextRoot}/contact" method="POST">
            <div class="form-group">
                <label>Name *</label>
                <sf:input type="text" path="senderName" class="form-control" placeholder="Enter Your Name" />
                <sf:errors path="senderName" cssClass="help-block" element="em"/> 
            </div>
            <div class="form-group">
                <label>Email *</label>
                <sf:input type="email" path="senderEmail" class="form-control" placeholder="Enter Your Email Address" />
                <sf:errors path="senderEmail" cssClass="help-block" element="em"/> 
            </div>                       
            <div class="form-group">
                <label>Subject *</label>
                <sf:input type="text" path="messageSubject" class="form-control" placeholder="Enter Message's Subject" />
                <sf:errors path="messageSubject" cssClass="help-block" element="em"/> 
            </div>
            <div class="form-group">
                <label>Message *</label>
                <sf:textarea path="mainMessage" class="form-control" rows="8"></sf:textarea>
                <sf:errors path="mainMessage" cssClass="help-block" element="em"/> 
            </div>                        
            <div class="form-group">
                <button type="submit" name="submit" class="btn btn-primary btn-lg" required="required">Submit Message</button>
            </div>
            
            <!-- Hidden Field -->
            <sf:hidden path="id"/>
			<sf:hidden path="read"/>
            
           </sf:form> 
        </div> 
      </div>

      <a href="javascript:void(0);" title="Go To Top" id="scroll" style="display:none;">
      <span> </span>
    </a>
    
    </div>

    <!-- End of Brief Intro -->