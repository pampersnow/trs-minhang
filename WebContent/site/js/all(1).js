//选项卡
function tab(tSel,wSel,sItemSel){
		$(tSel+" li").mouseenter(function(){
			var title = $(this).index();
			$(tSel+" li a").removeClass("on");
			$(this).children("a").addClass("on");
			$(wSel+" "+sItemSel).hide().get(title).style.display="block";
		});
};

function doZoom(size,obj){ 
document.getElementById('zoom').style.fontSize=size+'px'; 
$('.c_yellow').removeClass('c_yellow').addClass('c_gray');
obj.className='c_yellow';

} 

$(function(){	

//关闭右侧
  $("#f_close").click(function(){
	$(this).parent().hide();						   
  });
  
//tab 
  tab("#n_tab01","#n_con01",".n_item");
  tab("#n_tab02","#n_con02",".n_item");
  tab("#n_tab03","#n_con03",".n_item");
  tab("#m_tab","#m_box",".ma_list");
  //tab("#o_tab","#o_panel",".o_list");
  tab("#sys_tab","#sys_box",".sys_list");
  
//字体大小
  $('[ data-role="fontSize"]').click(function(){
    $('[ data-role="fontSize"]').removeClass("c_yellow").addClass("c_gray");
	$(this).removeClass("c_gray").addClass("c_yellow");
  });
  
  $("#font_big").click(function(){
    $('[data-role="n_content"]').find("p").css("font-size","18px");
  });
  
  $("#font_middle").click(function(){
    $('[data-role="n_content"]').find("p").css("font-size","16px");
  });
  
  $("#font_small").click(function(){
    $('[data-role="n_content"]').find("p").css("font-size","14px");
  });
  
//
  $(".table_list").find(".tr_con").each(function(){	   
if($(this).next(".tr_sub").length > 0){
		  $(this).find(".tr_no").hide();
		  $(this).find(".tr_open").addClass("show");
		  $(this).find("td:nth(1)").find("i:nth(3)").removeClass("n_root").addClass("root_icon");
		  $(this).find("td:nth(2)").find("a").attr("style","display:none;");
		  $(this).find(".has_child").attr("href","javascript:;");
		  $(this).find(".has_child").removeAttr("target");
		}
		else{
			$(this).find(".tr_no").show();
		    $(this).find(".tr_open").removeClass("show");
			}
});

	$(".tr_con .has_child").live("click",function(){
		if(!$(this).parents(".tr_con").find(".tr_open").is(":hidden"))
		{
			$(this).parents(".tr_con").find(".tr_open").click();
		}
		else if(!$(this).parents(".tr_con").find(".tr_close").is(":hidden"))
		{
			$(this).parents(".tr_con").find(".tr_close").click();
		}
	});
  
    $(".tr_open").click(function(){
	  var tr_sub = $(this).parents(".tr_con").next(".tr_sub");
		  $(this).removeClass("show");
		  $(this).parents(".tr_con").find(".tr_close").addClass("show");
           tr_sub.show();
        
	});
	
	$(".tr_close").click(function(){
	  var tr_sub = $(this).parents(".tr_con").next(".tr_sub");
		  $(this).removeClass("show");
		  $(this).parents(".tr_con").find(".tr_open").addClass("show");
           tr_sub.hide();
	});

//关于民航 
//新修改关于民航效果代码
$("#mh_item li").click(function(){
	if($(this).find('[data-role="mh_con"]').css("width")=="500px"){
		$(this).find('[data-role="mh_con"]').stop(true,true).css({width:0});
		}
		else{
			$("#mh_item li").parents("#mh_item").find('[data-role="mh_con"]').css("width","0");
			$(this).find('[data-role="mh_con"]').stop(true,true).css({width:500});
			}
      });
	  
	  //政府信息公开页新增鼠标划过效果
	
	$(".gov_list dd").mouseenter(function(){
	   if($(this).find(".gov_list_con").find("p").length!=0)
		$(this).find(".gov_list_con").slideDown(100);
	});
	$(".gov_list dd").mouseleave(function(){
	   if($(this).find(".gov_list_con").find("p").length!=0)
		$(this).find(".gov_list_con").slideUp(100);
	});
})

//双边协定
$(document).ready(function(){
	//一级菜单显示隐藏
	var $menu=$(".global_region>ul>li span");
	$menu.click(function(){
	    $menu.addClass('selected');
        $(".region_content").slideUp(100);
		if($(this).parent().next(".region_content").is(":visible")){
       		$(this).addClass('selected');
      	}
      	else{
        	$(this).removeClass('selected');
      	}
		$(".region_content").eq($menu.index(this)).stop().toggle(100);
	});
	//二级菜单显示隐藏
	
	
	/*$('.country_content').click(function(){
		return false;
	});	*/
	$('.country_content .right').click(function(){
		$('.country_content').hide();
	});
	
	//控制双边关系颜色显示
	$(".region_content a").each(function(){
    var thisobj = $(this);
    if(thisobj.attr("lang")==0){
      thisobj.css("color","#999").css("cursor","text");
    }
	else{
        var $that=thisobj.parent();
		$that.click(function(){
			$('.country_content').slideUp(100);
			$(".country_content").eq($that.index(this)).stop().toggle(100);
			$(".region_content").css("overflow","visible");
		});
	}
  })
    $(".region_content_search a").each(function(){
    var thisobj = $(this);
    if(thisobj.attr("lang")==0){
      thisobj.css("color","#999").css("cursor","text");
    }
	else{
        var $that=thisobj.parent();
		$that.click(function(){
			$('.country_content').slideUp(100);
			$(".country_content").eq($that.index(this)).stop().toggle(100);
			$(".region_content").css("overflow","visible");
		});
	}
  })
});

function GetChannelID(id)
{
   switch(id)
   {
      case "507":
	     return "71";
		 break;
	  case "755":
	     return "72";
		 break;
	  case "756":
	     return "73";
		 break;
	  case "757":
	     return "74";
		 break;
	  case "758":
	     return "77";
		 break;
	  case "759":
	     return "80";
		 break;
	  case "760":
	     return "81";
		 break;
	  case "761":
	     return "82";
		 break;
	  case "762":
	     return "87";
		 break;
	  case "763":
	     return "94";
		 break;
	  case "764":
	     return "95";
		 break;
	  case "765":
	     return "96";
		 break;
	  case "766":
	     return "97";
		 break;
	  case "767":
	     return "98";
		 break;
	  case "768":
	     return "99";
		 break;
	  case "769":
	     return "104";
		 break;
	  case "770":
	     return "105";
		 break;
	  case "771":
	     return "106";
		 break;
	  case "772":
	     return "107";
		 break;
	  case "773":
	     return "108";
		 break;		 
	  case "774":
	     return "415";
		 break;	
	  case "775":
	     return "416";
		 break;	
	  case "776":
	     return "417";
		 break;		
	  case "777":
	     return "418";
		 break;		
	  case "778":
	     return "419";
		 break;		
	  case "779":
	     return "420";
		 break;		
	  case "780":
	     return "421";
		 break;		
	  case "781":
	     return "422";
		 break;		
	  case "782":
	     return "423";
		 break;		
	  case "783":
	     return "424";
		 break;		
	  case "784":
	     return "425";
		 break;			
	  case "785":
	     return "426";
		 break;			
	  case "786":
	     return "427";
		 break;			
	  case "787":
	     return "428";
		 break;			
	  case "788":
	     return "430";
		 break;			
	  case "789":
	     return "1404";
		 break;	
	  case "3931":
	     return "3933";
		 break;	
	  case "4258":
	     return "4565";
		 break;	
	  case "4258":
	     return "4565";
		 break;
	  case "997":
	     return "112";
		 break;
	  case "3931":
	     return "3933";
		 break;
	  case "4256":
	     return "4567";
		 break;
	  case "4260":
	     return "4568";
		 break;
	  case "4658":
	     return "4660";
		 break;
	  case "4909":
	     return "4964";
		 break;
	  case "4910":
	     return "4965";
		 break;
	  case "4818":
	     return "4966";
		 break;
	  default :
	     return "71";	 
		 
   }   
}
