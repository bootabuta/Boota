$(function(){
	//solving the active menu problem
	switch(menu) {
	 
	case 'Contact Us' :
		 $('#contact').addClass('active');
		 break; 
		 
	case 'Blogs' :
		 $('#blogs').addClass('active');
		 break;	 
		 
	case 'Portfolio' :
		 $('#portfolio').addClass('active');
		 break;	 
		 
	case 'Resume' :
		 $('#resume').addClass('active');
		 break;	
		 
	case 'Home' :
		 $('#home').addClass('active');
		 break;	
		 
		 
	default :
		 if(menu == 'About Us') {
			 $('#about').addClass('active');
			 $('#a_Basic').addClass('active');
		 }
		 else{
			 $('#about').addClass('active');
			 $('#a_'+menu).addClass('active');
		 }
		 
	   	 break;
	
	}
	 
	
	
	// code for jquery dataTables
	
	var $table = $('#info');
	 	
	if($table.length){
		
		var jsonUrl = ' ';
		console.log('inside the all information');
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/information';
			console.log("inside the all information");
		}
		else {
			
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/information';
			console.log("inside the category information");
		}
		
		
		$table.DataTable( {
			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'All Records']],
			pageLength: 3,
			"ajax": {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			
			{
				data : 'name'		
			},
			{
				data : 'brand'		
			},
			{
				 data : 'unitPrice',
				 mRender: function(data, type, row){
					 return '&#8377;' +data
				 }
			},
			{
				data : 'quantity'		
			}
			
			
			]
			
		});
	
	}

			
});