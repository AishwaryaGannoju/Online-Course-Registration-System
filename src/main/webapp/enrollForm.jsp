<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enroll for a course</title>
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
            padding: 10% 30%;
           /* background-color:#6fb9ff; */
            background-image: url(bg.jpeg);
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;
        }
        .contents a{
            text-decoration: none;
        }
        .contents .back:hover{
            transform: scale(1.05);
        }

        .form1 {
            border-radius: 5px;
            margin-top: 20px;
            background-color: rgba(205, 234, 255, 0.541);
            
        }
        .form1 input[type=email],
        .form1 input[type=number]{
            background: rgba(255, 255, 255, 0.37);
            border: 0.9px solid #222e2f ;
            border-radius: 2px;
            padding: 5px 5px;
            text-align: start;
            
        }
        .form1 input::placeholder{
            font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
        }
        .form1 input[type=submit] {
            padding: 6px 24px;
            border: 1px solid #ffffff;
            background: transparent;
            border-radius: 6px;
            cursor: pointer;
        }
        .form1 input[type=submit]:hover {
            transform: scale(1.05);
        }
        .contents h3{
            padding-top: 10px;
        }
        .contents h1{
            margin: 5px;
            color:#02204b;
        }
        .contents h1 span{
            color: #c3f1ff;
        }
        .contents .back{
             position: absolute;
            right: 150px;
            top: 20px;
            color: #222e2f;
        }
       .top{
        color:#c3f1ff;
        font-size:18px;
       }
       .top span{
        color: #222e2f;
       }
</style>
</head>
<body>
<div class="contents">
	<a href="studentHome.jsp"><p class="back">&lt;Back</p></a>
<p class="top">View the list of available courses-<a href="courseList.jsp"><span>Here</span></a></p>
    <h1><span>Online</span> Course Registration</h1>

<div class="form1">
<form action="enroll">
<h3>Choose a course to Register</h3><br>
enter your email id:<input type="email" name="email" placeholder="enter your email" required/><br><br>

enter course id:<input type="number" name="cid" placeholder="enter relevant course id" required/><br><br>
<input type="submit" value="enroll"><br><br>
</form>
</div>
</div>
</body>
</html>