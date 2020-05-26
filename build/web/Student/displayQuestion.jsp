<%-- 
    Document   : displayQuestion
    Created on : Nov 28, 2017, 11:29:18 AM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.QuestionBean"%>
<%@page import="ict.bean.quiz"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1>Question</h1>
        <DIV id="CountMsg" class="HotDate"> 

<span id="t_h">00时</span> 
<span id="t_m">00分</span> 
<span id="t_s">00秒</span> 
</DIV> 
<script type="text/javascript"> 
    var EndTime= new Date(); //截止时间 

var a = new Date(); 
var et=a.getMinutes()+20;
//EndTime.setSeconds(et*60);
EndTime.setTime('10:00:00');
var t =600000;
function getRTime(){ 
var NowTime = new Date(); 

//var t =EndTime.getTime() - NowTime.getTime(); 
t-=1000;

  
var h=Math.floor(t/1000/60/60%24); 
var m=Math.floor(t/1000/60%60); 
var s=Math.floor(t/1000%60); 
 


document.getElementById("t_m").innerHTML = m + "分"; 
document.getElementById("t_s").innerHTML = s + "秒"; 
} 
setInterval(getRTime,1000);
</script> 
        <%

            ArrayList<QuestionBean> questions =(ArrayList<QuestionBean> )request.getAttribute("questions");
          //  int t= (int)request.getAttribute("timeSet");
            out.println("<h1></h1>");
         //   out.println(t);
            out.println("<form action='./HandleQuizResult' method='get' >");
            int quizid=0;
            int setTime;
            for (int i = 0; i < questions.size(); i++) {
                QuestionBean c = questions.get(i);
                if(i==0)
                    out.println("<hr>");
                out.println("<p>"+(i+1)+" : "+c.getContent()+"</p>");
                out.println("<input type='text' name='A"+(i+1)+"' value='"+c.getAnswer()+"' hidden />");
                out.println("<p>A."+c.getOptionA()+"<input type='radio' name='Q"+(i+1)+"' value='A' required='required' />"+"</p>");
                out.println("<p>B."+c.getOptionB()+"<input type='radio' name='Q"+(i+1)+"' value='B'  required='required' />"+"</p>");
                out.println("<p>C."+c.getOptionC()+"<input type='radio' name='Q"+(i+1)+"' value='C' required='required' />"+"</p>");
                out.println("<p>D."+c.getOptionD()+"<input type='radio' name='Q"+(i+1)+"' value='D' required='required'  />"+"</p>");
                quizid=c.getQuizID();
                
                out.println("<hr>");
            }
            out.println("<input type='text' name='quizNo' value='"+quizid+"' hidden />");
            out.println("<input type='text' name='questionNo' value='"+questions.size()+"' hidden />");
            out.println("<input type='submit' >");
            out.println("</form>");
      
           %>

    </body>
</html>
