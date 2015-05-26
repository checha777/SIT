package students.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import students.facade.ApplicantFacade;

import students.view.ProfessionView;
import students.facade.ProfessionFacade;
import students.facade.SubjectFacade;
import students.view.ApplicantView;
import students.view.SubjectView;
import students.web.forms.MainFrameForm;
import students.web.forms.ProfessionsForm;
import students.web.forms.StudentForm;


public class SimpleList extends HttpServlet
{
    public ProfessionFacade professionFacade;
    public SubjectFacade subjectFacade;
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(
                new String[]{"src/StudentExample.xml", "src/StudentDatabase.xml"});
        
         professionFacade = (ProfessionFacade)context.getBean("professionFacade");
         subjectFacade = (SubjectFacade) context.getBean("subjectFacade");
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
  
        ProfessionsForm form = new ProfessionsForm();
        List<ProfessionView> professions = professionFacade.findProfession();
        List<SubjectView> subjects=subjectFacade.findSubject();
        System.err.println("Вот этот список предметов я отправлю ща на jsp");
        for(SubjectView a:subjects){
            System.err.println(a.getSubjectName());
        }
       form.setProfessions(professions);
       form.setSubjects(subjects);
        
        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/professions.jsp").forward(req, resp);
    }

  

    // Переопределим стандартные методы
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        processRequest(req, resp);
    }

}