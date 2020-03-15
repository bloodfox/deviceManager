/*
 * 使用说明：initTime(obj)可以给传递过来的object赋值，格式为yyyy-MM-dd hh:mm:ss
 * 在文件中调用以下代码，需初始化时间的文本框，其id为inputTime；
 * $(document).ready( function() {
 *			initTime($("#inputTime"));
 *		});
 * 
 */
// 初始化obj的值为当前时间
function initTime(obj) {
	var myDate = new Date();
	var time = "";
	time += myDate.getFullYear();
	time += "-";
	time += comTime(myDate.getMonth() + 1);
	time += "-";
	time += comTime(myDate.getDate());
	time += " ";
	time += comTime(myDate.getHours());
	time += ":";
	time += comTime(myDate.getMinutes());
	time += ":";
	time += comTime(myDate.getSeconds());
	obj.attr("value", time);
}
function initDate(obj){
	var myDate = new Date();
	var time = "";
	time += myDate.getFullYear();
	time += "-";
	time += comTime(myDate.getMonth() + 1);
	time += "-";
	time += comTime(myDate.getDate());
	obj.attr("value", time);
}
// 将时间格式补充完整（不足10的前面补0）
function comTime(time) {
	if (time < 10) {
		time = '0' + time;
	}
	return time;
}