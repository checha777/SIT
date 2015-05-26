<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="StyleSheet.css"></link>
        <title>Профессии и дисциплины
        </title>

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
                                <form action="<c:url value="/simple"/>" method="POST">
                                    <table>
                                        <tr>
                                            <td style="width: 80%">
                                    <table border=1px>
                                        <tr style="background-color: #ccffcc">

                                            <td>Название профессиии:</td>
                                            <td>id </td>

                                        </tr>

                                        <c:forEach var="profession" items="${form.professions}">

                                            <tr>
                                                <td><c:out value="${profession.professionName}"/></td>
                                                <td><c:out value="${profession.professionId}"/></td>
                                            </tr>  

                                        </c:forEach>

                                    </table>
                                            </td>
                                            <td>
                                    <table border=1px>

                                        <tr style="background-color: #ccffcc">
                                            <td>Название дисциплины  </td>
                                            <td>id </td>
                                        </tr>


                                        <c:forEach var="subject"  items="${form.subjects}">
                                            <tr>
                                                <td>
                                                    <c:out value="${subject.subjectName}"/>

                                                </td>
                                                <td>
                                                    <c:out value="${subject.subjectId}"/>

                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </table>
                                                </td>
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
                                                <%--                         
                         <c:forEach var="subject"  items="${profession.subjectList2}">
                                                                  <c:out value="${subject.subjectName}"/>
                                                                  !
                                                              </c:forEach>
                                                --%>