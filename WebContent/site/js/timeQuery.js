var today = new Date(); //获取今天日期
	today.setDate(today.getDate() - 7);
	var dateArray = []; 
	var dateTemp; 
	var flag = 1; 
	for (var i = 0; i < 7; i++) {
	    dateTemp =today.getFullYear()+"-"+ (today.getMonth()+1)+"-"+today.getDate();
	    dateArray.push(dateTemp);
	    today.setDate(today.getDate() + flag);
	} 
	$("#input").val(dateArray[0])
	$("#input").val(dateTemp)
	document.getElementById("today").value = dateArray[0]
	document.getElementById("weeks").value = dateTemp