$(function(){
			
	$("body").delegate('[data-role="select_box"]', "click", function(event){
		
			var selectBox = $(this);																 
			var	selectTxt  = $(this).find('[data-role="select_txt"]');
			var	selectClose  = $(this).find('[data-role="select_close"]');
			var	optionCon  = $(this).find('[data-role="option_con"]');
           
		 
			if( optionCon.css("display")=="block"){
				optionCon.hide();
				$("body").find('[data-role="select_box"]').css("z-index","0");
			}
			else{
				$(document).find('[data-role="option_con"]').hide();
				$("body").find('[data-role="select_box"]').css("z-index","0");
				optionCon.show();
				selectBox.css("z-index","10");
				}
			$(document).on("click", function () {
					optionCon.hide();
					$("body").find('[data-role="select_box"]').css("z-index","0");
					}); 
			event.stopPropagation();
			
			optionCon.delegate('[data-role="option_item"]', "click", function(event){	
				selectTxt.val($(this).text());
				optionCon.hide(); 
				$("body").find('[data-role="select_box"]').css("z-index","0");
				selectClose.show();
				event.stopPropagation();
			});
		
});

})