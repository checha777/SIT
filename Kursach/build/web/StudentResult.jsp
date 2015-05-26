<%-- 
    Document   : StudentResult
    Created on : 24.05.2015, 13:53:15
    Author     : checha777
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="students.view.ApplicantResultView" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="StyleSheet.css"></link>
    <title>Студенты
    </title>
<script type="text/javascript">
function validateForm()
{
var x=document.forms["myForm"]["ResultId"].value;
if (x==null || x=="")
  {
  alert("Поле для воода Id пустое!!!");
  return false;
  }
  if (!((x>-1000)&&(x<3000)))
  {
  alert("Введите корректное Id");
  return false;
  }
  var y=document.forms["myForm"]["Mark"].value;
if (y==null || y=="")
  {
  alert("Поле дл ввода оценки пустое!!!");
  return false;
  }
  if (!((y>0)&&(y<11)))
  {
  alert("Введите оценку от 1 до 10");
  return false;
  }


}
</script>
</head>
<body>

    <table class="table">
        <p style="text-align: center;">
        <img height="150px" width="400px" src="group-cheerful-student-holding-banner-ad-25997010.jpg">
                </p>
        <tr>
            <td>

                <table>
                    
                    <tr class="menu">
                        <td class="menu1"><a class="aMenu" href="index.jsp">Главная</a></td>
                        <td class="menu1"><a class="aMenu" href="${pageContext.request.contextPath}/main">Переход на cтраницу студентов</a></td>
                        <td class="menu1"><a class="aMenu" href="${pageContext.request.contextPath}/simple">Переход на страницу профессий</a></td>
                       <td class="menu1"><a class="aMenu"  href="contacts.jsp">Контакты</a></td>
                    </tr>
                </table>

            </td>
        </tr>

        <tr>
            <td >
                <table>
                    <tr>
                       <td class="mainContent" >
                       <form action="<c:url value="/ResultsServlet"/>" method="POST" name="myForm" onsubmit="return validateForm()">
                           
                           <input type="hidden" name="studentId" value="${student.studentId}"/>
                           
                          
            <table>
     <tr >
                    <td style="background-color: #ccffcc">Оценки:</td>
                    
     </tr>
     <tr>
        
                        <c:forEach var="result" items="${student.resultsList}">
                            <td>
                                <p>id=<c:out value="${result.applicantResultId}"/></p>    
                            <c:out value="${result.subjectName}"/>
                             
                             <input type="text"  value="${result.mark}"/>
                             
                            </td>
                           
                        </c:forEach>
                            
                            
     </tr>  
                    
                
                
            </table>
                           <hr>
            <table>
                <tr> 
                    <td>Id </td>
                    <td>Предмет</td>
                    <td>Оценка</td>
                </tr>
                <tr> 
                    <td><input type="text" name="ResultId" /></td> 
                    <td>
                        <select name="subjectId">
                        <c:forEach var="subject" items="${student.subjects}">
                            <c:choose>
                                <c:when test="${subject.subjectId==student.subjectId}">
                                    <option value="${subject.subjectId}" selected><c:out value="${subject.subjectName}"/></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${subject.subjectId}"><c:out value="${subject.subjectName}"/></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        </select>
                    </td>
                <td><input type="text" name="Mark" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Добавить" name="OK"/></td>
                    <td><input type="submit" value="Удалить" name="Cancel"/></td>
                </tr>
            </table>
                           
                           
        </form>
                       </td>
                        <td class="dopContent">
                            <a href="http://distant.bsuir.by/"><img src="12_100229_1_53059.png"></a><br>
                            <a href="http://abitur.bsuir.by/"><img src="12_100229_1_71326.png"></a><br>
                            <a href="http://www.bsuir.by/"><img src="12_113227_1_49005.jpg"></a><br>
                            <a href="http://edu.gov.by/"><img src="12_113227_1_52888.gif"></a><br>
                        </td>
                    </tr>
                </table>
            </td>
           
        </tr>

        <tr class="bottom">
            <td> © checha777 2015</td>
        </tr>

    </table>

</body>

</html>