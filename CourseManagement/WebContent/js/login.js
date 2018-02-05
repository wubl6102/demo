// 输入检查
function isValid(){
	// 检查是否输入账号
	if(frmLogin.id.value == ""){
		window.alert("你必须完成账号的输入！");
		// 显示错误
		document.frmLogin.elements(0).focus();
		// 将光标移至账号输入栏
		return false;
	}
	
	// 检查是否输入账号密码
	if(frmLogin.password.value == ""){
		window.alert("你必须完成密码的输入！");
		// 显示错误信息
		document.frmLogin.elements(1).focus();
		// 将光标移至密码输入栏
		return false;
	}
	
	frmLogin.submit();
}

function makearray(size){
	this.length = size;
	for(i=1; i<=size; i++){
		this[i] = 0;
	}
	return this;
}

msg = new makearray(3);
msg[1] = "你好，欢迎使用学生课绩管理系统！！！";
msg[2] = "请您选择用户类型，输入正确的用户名、密码";
msg[3] = "谢谢您的使用！！！";

interval = 100;
seq = 0;
i = 1;
function Scroll(){
	document.tmForm.tmText.value = msg[i].substring(0,seq+1);
	seq++;
	
	if(seq >= msg[i].length){
		seq = 0;
		i++;
		interval = 900;
	}
	
	if(i>3){
		i=1;
	}
	window.setTimeout("Scroll();",interval);
	interval = 100;
}






















