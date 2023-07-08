<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login to Online Course Registration</title>
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
            padding: 10% 30%;
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
        .form1 input[type=password]{
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
       .bottom{
        color:#c3f1ff;
       }
       .bottom span{
        color: #222e2f;
       }
       
       
    </style>
</head>

<body>
    <div class="contents">
    <a href="index.jsp"><p class="back">&lt;Back</p></a>
    <h1><span>Online</span> Course Registration</h1>
    <div class="form1">
        <form action="./StudentLogin" method="post">
            <h3>Student Login</h3>
            Email: <input type="email" name="email" placeholder="enter your email" required/><br><br>
            Password: <input type="password" name="password" placeholder="enter your password" required><br><br>
            <input type="submit" value="login now"><br><br>

        </form>
    </div>
    <p class="bottom">Don't have an Account?<span>Contact Admin</span></p>
    </div>
</body>

</html>