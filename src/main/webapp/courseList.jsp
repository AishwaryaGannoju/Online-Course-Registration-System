<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Courses Offered</title>
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
       /* background-color:#6fb9ff; */
            background-image: url(bg.jpeg);
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;
        }
        .contents h1{
           font-size: 50px;
            margin-top: 40px;
            color:#02204b;
        }
        .contents .back{
             position: absolute;
            right: 150px;
            top: 20px;
            color: #222e2f;
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
        
        .courses{
        display:flex;
        justify-content:center;
        margin:30px 350px;
        background-color:rgba(205, 234, 255, 0.541);
        border-radius: 5px;
        }
        table {
   		 border-collapse: separate;
    	border-spacing: 50px 10px;
		}
        .courses th{
        font-size:18px;
        margin-top:15px;
        color:#000;
        }
        .courses td{
        font-size:20px;
        margin-top:15px;
        color:#222e2f;
        }
        .btns{
        display:inline-block;
        }
        .btn1{
        margin: 50px;
        padding: 6px 30px;
        background: transparent;
        border-radius: 8px;
        cursor: pointer;
        font-size: 15px;
        position: relative;
    	right: 0px;
    	top:0px;
    	border: 0.8px solid #c3f1ff;
    	color: #c3f1ff;
       }
  
       .btn2{
        margin: 50px;
        padding: 6px 30px;
        background: transparent;
        border-radius: 8px;
        cursor: pointer;
        font-size: 15px;
        position: relative;
    	right: 0px;
    	top:0px;
    	border: 0.8px solid #222e2f;
    	color: #222e2f;
       }
       
       .contents a:hover,.contents btns:hover{
        transform: scale(1.05);
        
       }
       table td.actions a{
       font-size:18px;
       font-family:Arial;
      }
       
    </style>
</head>

<body>

	<div class="contents">
		<a href="enrollForm.jsp"><p class="back">&lt;Back</p></a>
   <h1><span id="online">Online</span> <span id="course">Course</span> Registration</h1>
<div class="btns">
<a href="<%=request.getContextPath()%>/new" class="btn1">Add New Course</a>
<a href="<%=request.getContextPath()%>/list" class="btn2">Refresh the list</a>	
</div>
 <div class="courses">
 <table>
	<thead>
	<tr><th>Course Id</th><th>Course Name</th></tr>
	</thead>
	<tbody>
		<c:forEach var="course" items="${listCourse}">
			<tr>
				<td><c:out value="${course.cid}" /></td>
				<td><c:out value="${course.cname}" /></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
 </div>
	</div>
 
</body>

</html>