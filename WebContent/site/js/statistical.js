function statistical(docid,doctitle,docchannel,docpubtime) {
	var pathName =window.location.pathname;
	pathName = pathName.substring(0,pathName.substring(1).indexOf('/')+1);
	/*注：statisticsid参数必传可和docid相同*/
	var data = JSON.stringify({"DOCID":docid,"DOCTITLE":doctitle, "DOCCHANNEL":docchannel,"DOCPUBTIME":docpubtime });
	$.ajax({
			url : pathName+'/doAddInfoCollect.html',			
			type : "post",
			data : data,
			async:false,
			contentType: "application/json; charset=utf-8",
			success : function(data) {alert(data);},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				console.info("ajaxerr");
				console.info(XMLHttpRequest.status+"_"+XMLHttpRequest.readyState+"_textStatus:"+textStatus);
				console.info(errorThrown);
			}
	}); 
};


