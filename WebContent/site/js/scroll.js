
(function($){    
		$.fn.eKingScroll = function(options){
			var defaults={ 
			  direction             :"left",      //方向  "left" or "top"
			  autoScroll			:true        //是否开启自动滚动,"true" or "false"	
				};

			var options = $.extend(defaults,options);
			var oSlider=$(this);
			var	ad_box  = $(this).find('[data-role="ad_box"]');
			var	len  = $(this).find('[data-role="ad_box"]').find("li").length -1;
			var	ad_num  = $(this).find('[data-role="ad_num"]');
			var	scrollPrev  = $(this).find('[data-role="scroll_prev"]');
			var	scrollNext  = $(this).find('[data-role="scroll_next"]');
			
			var	index = 0;
			var adTimer,mantual=false;
	  oSlider.find('[data-role="ad_num"]').find("li:first").addClass("on");
	
	  ad_num.find("li").click(function(){
		mantual=true;							 
		index  =  ad_num.find("li").index(this);
		showImg(index);
	  });
	
	//是否开启自动滚动	
		if(options.autoScroll){
			adTimer = setInterval(function(){
				if(!mantual){
					if(index==len){
						index =0;
					}else{
						index++;
					}
					showImg(index);
				}
			} , 5000);
		};
	
	oSlider.hover(function(){
		mantual=true;
	},function(){
		mantual=false;
	});
	
		
	
	//下一条按钮
	scrollNext.click(function(){
	   mantual=true;
		if(index==len){
				index =0;
		}else{
			index++;
		}
		showImg(index);
		 });
	
	//上一条按钮
	scrollPrev.click(function(){
	  mantual=true;
		if(index==0){
			index =len;
		}else{
			index--;
		}
		showImg(index);
		 });

		function showImg(index){
			if(len==0){
			  mantual=false;
		    }
			else{
			ad_box.find("li").fadeOut(400).eq(index).fadeIn(400);
			ad_num.find("li").fadeOut(400).eq(index).fadeIn(400);
			}
			}
}})(jQuery);


(function($){ 
$.fn.aboutScroll = function(options){
			var defaults={ 
			      num         :6
				  }

			var options = $.extend(defaults,options);			
			var page = 1;
			var Slider=$(this);		
			var scrollBox = $(this).find('[data-role="scroll_box"]');
			var scrollCon = $(this).find('[data-role="scroll_con"]');
			var scrollNext = $(this).find('[data-role="scroll_next"]');
			var scrollPrev = $(this).find('[data-role="scroll_prev"]');
			var scrollWidth = scrollBox.width() ;
			var len = scrollCon.find("li").length;
			var count = Math.ceil(len / options.num) ;
	
	     scrollCon.css("left","0");
         scrollCon.find("li:first-child a").addClass("on");
		 
	     Slider.undelegate('[data-role="scroll_next"]', "click");
	     Slider.undelegate('[data-role="scroll_prev"]', "click");
		 
		 Slider.delegate('[data-role="scroll_next"]', "click", function(){
			var scrollBox = $(this).parent().find('[data-role="scroll_box"]'); 
			var scrollWidth = scrollBox.width();															
			var len = scrollCon.find("li").length;
			var count = Math.ceil(len / options.num) ;															
			if( page == count ){  
				scrollCon.stop(true,true).animate({ left : 0}, 400);
				page = 1;
			}else{
				scrollCon.stop(true,true).animate({ left : '-='+scrollWidth}, 400); 
				page++;
			}
			
   });
	
	Slider.delegate('[data-role="scroll_prev"]', "click", function(){
		    var scrollBox = $(this).parent().find('[data-role="scroll_box"]');
			var scrollWidth = scrollBox.width() ;													   
			var len = scrollCon.find("li").length;
			var count = Math.ceil(len / options.num) ;
			if( page == 1 ){
				scrollCon.stop(true,true).animate({ left : '-='+scrollWidth*(count-1)}, 400); 
				page = count;
			}else{
				scrollCon.stop(true,true).animate({ left : '+='+scrollWidth }, 400); 
				page--;
			}
    });
			
}})(jQuery);





		   

