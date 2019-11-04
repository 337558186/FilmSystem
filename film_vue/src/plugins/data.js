/**
 * Created by Administrator on 2017/5/23.
 */
//转换mysql的datetime日期时间格式
function makeDate(date) {
	try {
		var newDate = new Date(date);
		//在小于10的月份前补0
		var month = eval(newDate.getMonth() + 1) < 10 ? '0'+eval(newDate.getMonth() + 1) : eval(newDate.getMonth() + 1);
		//在小于10的日期前补0
		var day = newDate.getDate() < 10 ? '0' + newDate.getDate() : newDate.getDate();
		//在小于10的小时前补0
		var hours = newDate.getHours() < 10 ? '0' + newDate.getHours() : newDate.getHours();
		//在小于10的分钟前补0
		var minutes = newDate.getMinutes() < 10 ? '0' + newDate.getMinutes() : newDate.getMinutes();
		//在小于10的秒数前补0
		var seconds = newDate.getSeconds() < 10 ? '0' + newDate.getSeconds(): newDate.getSeconds();
		//拼接时间
		var stringDate = newDate.getFullYear() + '-' + month + '-' + day + " " + hours + ":" + minutes + ":" + seconds;
	}catch(e){
		var stringDate = "0000-00-00 00:00:00";
	}finally{
		return stringDate;
	}

};

function makeSimpleDate(date) {
	try {
		var newDate = new Date(date);
		//在小于10的月份前补0
		var month = eval(newDate.getMonth() + 1) < 10 ? '0'+eval(newDate.getMonth() + 1) : eval(newDate.getMonth() + 1);
		//在小于10的日期前补0
		var day = newDate.getDate() < 10 ? '0' + newDate.getDate() : newDate.getDate();
		//在小于10的小时前补0
		var hours = newDate.getHours() < 10 ? '0' + newDate.getHours() : newDate.getHours();
		//在小于10的分钟前补0
		var minutes = newDate.getMinutes() < 10 ? '0' + newDate.getMinutes() : newDate.getMinutes();
		//在小于10的秒数前补0
		var seconds = newDate.getSeconds() < 10 ? '0' + newDate.getSeconds(): newDate.getSeconds();
		//拼接时间
		var stringDate = newDate.getFullYear() + '-' + month + '-' + day;
	}catch(e){
		var stringDate = "0000-00-00";
	}finally{
		return stringDate;
	}

};

function  dateDiff(sDate1,  sDate2){    //sDate1和sDate2是2006-12-18格式  
	var strSeparator = "-"; //日期分隔符
	var oDate1;
	var oDate2;
	var iDays;
	oDate1= sDate1.split(strSeparator);
	oDate2= sDate2.split(strSeparator);
	var strDateS = new Date(oDate1[0], oDate1[1]-1, oDate1[2]);
	var strDateE = new Date(oDate2[0], oDate2[1]-1, oDate2[2]);
	iDays = parseInt(Math.abs(strDateS - strDateE ) / 1000 / 60 / 60 /24);//把相差的毫秒数转换为天数
	return iDays ;

}

export{
	dateDiff,
	makeDate,
	makeSimpleDate
}
