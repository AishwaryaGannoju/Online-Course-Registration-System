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
     /*  background-image: url("<%=request.getContextPath()%>/bg4.jpg");
     */       background-image: linear-gradient(to right,#003784, #91e8f6);  
       		background-repeat: no-repeat;
          	min-height: 100vh; 
        }
        .contents{
          /* background-color:#6fb9ff; */
          /*  background-image: url("lap.jpg");
            */ background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;`
        }
        .contents .container a{
            text-decoration: none;  
        }

       .container{
        display: flex;
        justify-content:center;
        align-items:center;
        
       }
       .btn1,.btn2{
        margin: 50px;
        padding: 6px 50px;
        background: transparent;
        border-radius: 200px;
        cursor: pointer;
        font-size: 20px;
       }
       .btn1{
        border:0.8px solid #c3f1ff;
        color: #c3f1ff;
       }
       .btn1:hover,.btn2:hover{
        transform: scale(1.05);
       }
       .btn2{
        border: 0.8px solid #fff;
       }
        .contents h1{
           font-size: 50px;
            margin-top: 150px;
            color:#02204b;
        }
        .contents h1 #online{
            color: #c3f1ff;
        }
        .contents h1 #course{
            color: #c3f1ff;

        }
    </style>
</head>

<body >
   <div class="contents">
   <h1><span id="online">Online</span> <span id="course">Course</span> Registration</h1>
   <div class="container">
    <a href="adminLogin.jsp"><button class="btn1">Admin</button></a>
    <a href="studentLogin.jsp"><button class="btn2">Student</button></a>
   </div>
   </div>
</body>

</html>