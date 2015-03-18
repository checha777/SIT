import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ShowParameters extends HttpServlet 
{
public void doGet(HttpServletRequest request,
                  HttpServletResponse response)
                    throws ServletException, IOException 
   {
     response.setContentType("text/html;charset=UTF-8");
     
     PrintWriter out = response.getWriter();
     String title = "Reading All Request Parameters";
     out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0"+
                 " Transitional//Eng\">\n" +
                 "<HTML>\n" +
                 "<HEAD><TITLE>List of parameters"+ 
                 "</TITLE></HEAD>\n" +
                 "<BODY <BGCOLO></BGCOLO>R=\"#FDF5E6\">\n" +
                 "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                 "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                 "<TR BGCOLOR=\"#FFAD00\">\n" +
                 "<TH>Parameter Name<TH>Parameter Value(s)");
     // создаем объект-перечисление и заполняем его
     // именами параметров формы 
     Enumeration paramNames = request.getParameterNames();
     // запускаем цикл перебора элементов перечисления
     while(paramNames.hasMoreElements()) 
     {
          // получаем следующий элемент перечисления
          String paramName = (String)paramNames.nextElement();
          out.print("<TR><TD>" + paramName + "\n<TD>");
          // создаем массив строк и записываем в него
          // переданные из формы значения параметра, 
          // имя которого хранится в переменной paramName
          String[] paramValues =
                request.getParameterValues(paramName); 
          if (paramValues.length == 1) {
                // параметр имеет одно значение
                String paramValue = paramValues[0];
                // проверка на пустоту значения параметра
                if (paramValue.length() == 0)
                       out.println("<I>No Value</I>");
                else
                       out.println(paramValue);
          } else {
                    // параметр имеет много значений (например,
                    // список со множественным выбором)
                    out.println("<UL>");
                    for(int i=0; i<paramValues.length; i++) {
                         out.println("<LI>" + paramValues[i]);
                    }
                    out.println("</UL>");
                 }
     }
     out.println("</TABLE>\n</BODY></HTML>");
   }

public void doPost(HttpServletRequest request,
                   HttpServletResponse response)
                 throws ServletException, IOException 
   {
       doGet(request, response);
   }
}
