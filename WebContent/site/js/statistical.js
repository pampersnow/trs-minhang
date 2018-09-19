function statistical(docid,doctitle,docchannel,docpubtime) {	
	var data = JSON.stringify({"DOCID":docid,"DOCTITLE":doctitle, "DOCCHANNEL":docchannel,"DOCPUBTIME":docpubtime });
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


