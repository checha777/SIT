<%-- 
    Document   : index
    Created on : 08.05.2015, 18:10:39
    Author     : checha777
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="StyleSheet.css"></link>
    <title>Студенческий отдел кадров
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
                    <tr >
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
                           <p style=" font-size: 45px; font-family: sans-serif; text-align: center; ">Здравствуйте! </p>
                           Вас приветствует студенческий отдел кадров! Здесь вы можете узнать информацию о студентах. 
                          Их личных данных. Также вы можете просмотреть и изменить их успеваемость. 
                          Данный сайт также располагает информацией специальностях и предметах данной кафедры.
                           
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="${pageContext.request.contextPath}/simple">Переход на страницу профессий</a>
        <hr>
        <a href="${pageContext.request.contextPath}/main">Переход на главную страницу</a>
    </body>
</html>
--%>