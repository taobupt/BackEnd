
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("assets/img/backgrounds/2.jpg");
    
    /*
        Form validation
    */
    $('.signup-form input[type="text"],.signup-form input[type="email"], .signup-form input[type="password"]').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.signup-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"],input[type="email"], input[type="password"]').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
    
});
