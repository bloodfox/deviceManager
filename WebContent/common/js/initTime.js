/*
 * ʹ��˵����initTime(obj)���Ը����ݹ�����object��ֵ����ʽΪyyyy-MM-dd hh:mm:ss
 * ���ļ��е������´��룬���ʼ��ʱ����ı�����idΪinputTime��
 * $(document).ready( function() {
 *			initTime($("#inputTime"));
 *		});
 * 
 */
// ��ʼ��obj��ֵΪ��ǰʱ��
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
// ��ʱ���ʽ��������������10��ǰ�油0��
function comTime(time) {
	if (time < 10) {
		time = '0' + time;
	}
	return time;
}