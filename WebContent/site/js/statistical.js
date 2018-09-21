function statistical(statisticsid,docid,doctitle,docchannel,docpubtime) {	
	/*注：statisticsid参数必传可和docid相同*/
	var data = JSON.stringify({"STATISTICSID":statisticsid,"DOCID":docid,"DOCTITLE":doctitle, "DOCCHANNEL":docchannel,"DOCPUBTIME":docpubtime });
	$.ajax({
			url : '../doAddInfoCollect.html',			
			type : "post",
			data : data,
			dataType : "json",
			async:false,
			contentType: "application/json; charset=utf-8",
			success : function(data) {alert("成功!");}					
	}); 
};


