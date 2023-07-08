<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Course Registration</title>
    <style>
        * {
            text-align: center;
            font-family: Cambria;
            box-sizing: border-box;
    
        }
        body{
          background-image: linear-gradient(to right,#003784, #91e8f6);
          background-repeat: no-repeat;
          min-height: 100vh;
        }
        .contents{
          /* background-color:#6fb9ff;*/
            background-image: url(lap.jpg);
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;`
        }
        .contents h1{
           font-size: 50px;
            margin-top: 40px;
			color:#02204b;
        }
        .contents h1 #online{
            color: #c3f1ff;
        }
        .contents h1 #course{
            /* color: #79d6f2; */
            color: #c3f1ff;
        }
        .contents a{
            text-decoration: none;  
        }
        .contents ul li{
            list-style:none;
        }
        
        .options{
        margin:10px 350px;
        display:flex;
        flex-direction:column;
        align-items:start;
        background-color:rgba(205, 234, 255, 0.541);
        border-radius: 5px;
        }
        .options li{
        font-size:20px;
        margin-top:15px;
        color:#222e2f;
        }
        .options li#lastitem{
      
        margin-bottom:15px;
        color:#222e2f;
        }
       .btn{
        margin: 50px;
        padding: 6px 30px;
        background: transparent;
        border-radius: 8px;
        cursor: pointer;
        font-size: 15px;
        position: absolute;
    	right: 0px;
    	top:0px;
    	border: 0.8px solid #222e2f;
    	color: #222e2f;
       }
       
       .btn:hover,a:hover{
        transform: scale(1.05);
       }
       
    </style>
</head>

<body>
<div class="contents">
<a href="index.jsp"><button class="btn">logout</button></a>
   <h1><span id="online">Online</span> <span id="course">Course</span> Registration</h1>
   <h2>Welcome, Admin</h2>
   <ul class="options">
    <a href="studentReg.jsp"><li>&#x2799;  Register a new Student</li></a>
    <a href="<%=request.getContextPath()%>/new"><li>&#x2799;  Add a course to the list</li></a>
    <a href="courseListAdmin.jsp"><li>&#x2799;  View the list of courses available</li></a>
    <a href="<%=request.getContextPath()%>/studentform"><li>&#x2799;  View the no of Courses registered by a student</li></a>
    <a href="<%=request.getContextPath()%>/courseform"><li>&#x2799;  View the no of Students registered for a course</li></a>
    <a href="<%=request.getContextPath()%>/details"><li id="lastitem">&#x2799;  View all the Details of Students and their Courses</li></a>
    
   </ul>
</div>
</body>

</html>