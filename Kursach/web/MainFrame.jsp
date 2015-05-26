<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="StyleSheet.css"></link>
    <title>Студенты
    </title>
<script type="text/javascript">
function validateForm()
{
var x=document.forms["myForm"]["year"].value;
if (x==null || x=="")
  {
  alert("Поле для ввода года пустое!!!");
  return false;
  }
  if (!((x>-1000)&&(x<3000)))
  {
  alert("Введите корректный  год");
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
                        <td class="menu1"><a class="aMenu" href="contacts.jsp">Контакты</a></td>
                    </tr>
                </table>

            </td>
        </tr>

        <tr>
            <td >
                <table>
                    <tr>
                       <td class="mainContent" >
                          <form action="<c:url value="/main"/>" method="POST" name="myForm" onsubmit="return validateForm()">
            <table>
                <tr>
                    <td>Год:<input type="text" name="year" value="${form.year}"/><br/></td>
                    <td>Список групп:
                        <select name="professionId">
                            <c:forEach var="profession" items="${form.professions}">
                                <c:choose>
                                    <c:when test="${profession.professionId==form.professionId}">
                                        <option value="${profession.professionId}" selected><c:out value="${profession.professionName}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${profession.professionId}"><c:out value="${profession.professionName}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="submit" name="getList" value="Обновить"/></td>
                </tr>
            </table>
                    <hr>
            
            <b>Список студентов для выбранных параметров:<b>
            <br/>
            <table>
                <tr>
                    <th>&nbsp;</th>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Отчество</th>
                </tr>
                <c:forEach var="student" items="${form.students}">
                <tr>
                    <td><input type="radio" name="studentId" value="${student.applicantId}"></td>
                    <td><c:out value="${student.lastName}"/></td>
                    <td><c:out value="${student.firstName}"/></td>
                    <td><c:out value="${student.middleName}"/></td>
                </tr>
                </c:forEach>
            </table>
                
            <table>
                <tr>
                    <td><input type="submit" value="Add" name="Add"/></td>
                    <td><input type="submit" value="Edit" name="Edit"/></td>
                    <td><input type="submit" value="Delete" name="Delete"/></td>
                    <td><input type="submit" value="Marks" name="Marks"/></td>
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
            <td>© checha777 2015</td>
        </tr>

    </table>

</body>
</html>
   