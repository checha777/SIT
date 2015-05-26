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
var x=document.forms["myForm"]["educationYear"].value;
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
                       <form action="<c:url value="/edit"/>" method="POST" name="myForm" onsubmit="return validateForm()">
            <input type="hidden" name="studentId" value="${student.studentId}"/>
            <table>
                <tr>
                    <td>Фамилия:</td><td><input type="text" name="surName" value="${student.surName}"/></td>
                </tr>
                <tr>
                    <td>Имя:</td><td><input type="text" name="firstName" value="${student.firstName}"/></td>
                </tr>
                <tr>
                    <td>Отчество:</td><td><input type="text" name="patronymic" value="${student.patronymic}"/></td>
                </tr>
                
                <tr>
                    <td>Специальность:</td>
                    <td>
                        <select name="professionId">
                        <c:forEach var="profession" items="${student.professions}">
                            <c:choose>
                                <c:when test="${profession.professionId==student.professionId}">
                                    <option value="${profession.professionId}" selected><c:out value="${profession.professionName}"/></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${profession.professionId}"><c:out value="${profession.professionName}"/></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Год поступления:</td><td><input type="text" name="educationYear" value="${student.educationYear}"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><input type="submit" value="OK" name="OK"/></td>
                    <td><input type="submit" value="Cancel" name="Cancel"/></td>
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