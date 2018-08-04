<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script language="JavaScript">  
  
function sele(){  
  
       if(document.getElementById("agreement").checked==false)     //判断单选框此时状态为未选agreement为单选框id  
  
            {  
  
                 document.getElementById("button_disabled").style.display="inline";   //显示不可用按钮  
  
                 document.getElementById("button_enabled").style.display="none";   //隐藏不可用按钮  
  
   
  
            }  
  
        else        //判断单选框此时状态为已选  
  
           {  
  
                document.getElementById("button_disabled").style.display="none";     
  
                 document.getElementById("button_enabled").style.display="inline";  
  
     }  
  
}  
  
</script>  
  
 
  
<input type="checkbox" id="agreement" name="form_agreement"  onchange="sele()"></input> //用onchange触发事件  
  
 <input type="submit" value="注册1" id="button_disabled">  
  
  <input type="submit" value="注册2" id="button_enabled" style="display:none" >  
  



</body>
</html>