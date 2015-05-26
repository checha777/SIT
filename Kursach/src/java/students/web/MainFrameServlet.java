package students.web;

import java.io.IOException;
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
import students.facade.ProfessionFacade;
import students.facade.ApplicantResultFacade;
import students.facade.SubjectFacade;
import students.view.ApplicantView;
import students.view.ProfessionView;
import students.view.ApplicantResultView;
import students.view.SubjectView;

import students.web.forms.MainFrameForm;
import students.web.forms.StudentForm;
import students.web.forms.StudentResultsForm;


public class MainFrameServlet extends HttpServlet
{   public ApplicantFacade applicantFacade;
    public ProfessionFacade professionFacade;
    public SubjectFacade subjectFacade;
    public ApplicantResultFacade applicantResultFaccade;
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
        
        
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(
                new String[]{"src/StudentExample.xml", "src/StudentDatabase.xml"});
        
         professionFacade = (ProfessionFacade)context.getBean("professionFacade");
         applicantFacade = (ApplicantFacade)context.getBean("applicantFacade");
         applicantResultFaccade=(ApplicantResultFacade)context.getBean("applicantResultFacade");
         subjectFacade=(SubjectFacade)context.getBean("subjectFacade");
        
        int answer = 0;
        try {
            answer = checkAction(req);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        if (answer == 1) {
            ApplicantView s = new ApplicantView();
            Long aaa=(long) 0;
            s.setApplicantId(aaa);
            s.setEntranceYear(Calendar.getInstance().get(Calendar.YEAR));
            Collection professions = professionFacade.findProfession();
            StudentForm sForm = new StudentForm();
            sForm.initFromStudent(s);
            sForm.setProfessions(professions);
            req.setAttribute("student", sForm);
            getServletContext().getRequestDispatcher("/StudentFrame.jsp").forward(req, resp);
            return;

        }

        if (answer == 2) {
            if (req.getParameter("studentId") != null) {
                long stId = Integer.parseInt(req.getParameter("studentId"));
                ApplicantView s = applicantFacade.getApplicant(stId);
                Collection professions = professionFacade.findProfession();
                StudentForm sForm = new StudentForm();
                sForm.initFromStudent(s);
                sForm.setProfessions(professions);
                req.setAttribute("student", sForm);
                getServletContext().getRequestDispatcher("/StudentFrame.jsp").forward(req, resp);
                return;
            }
        }
         if (answer == 3) {
            if (req.getParameter("studentId") != null) {
                long stId = Integer.parseInt(req.getParameter("studentId"));
                ApplicantView s = applicantFacade.getApplicant(stId);
                List <ApplicantResultView>results=applicantResultFaccade.findApplicantResult(s);
                List <SubjectView> subjects=subjectFacade.findSubject();
                
                StudentResultsForm rForm = new StudentResultsForm();
                
                rForm.setResultsList(results);
                rForm.setStudentId(stId);
                rForm.setSubjects(subjects);
                        
                req.setAttribute("student", rForm);
                getServletContext().getRequestDispatcher("/StudentResult.jsp").forward(req, resp);
                return;
            }
        }
        String gs = req.getParameter("professionId");
        String ys = req.getParameter("year");

        
        long professionId = -1;
        if (gs != null) {
            professionId = Long.parseLong(gs);
        }
        int year = 2009;
        if (ys != null) {
            year = Integer.parseInt(ys);
        }
        MainFrameForm form = new MainFrameForm();
        List<ProfessionView> professions = professionFacade.findProfession();
        ProfessionView g = new ProfessionView();
        g.setProfessionId(professionId);
        if (professionId == -1) {
            Iterator i = professions.iterator();
            g = (ProfessionView) i.next();
        }
        // вот здесь по идее нужно полуать не список всех студентов
        // а только тех,кт принадлежат опред-ой специальности
        Collection students = applicantFacade.findApplicantByProfessionAndYear( year,g.getProfessionId());
        form.setProfessionId(g.getProfessionId());
        form.setYear(year);
        form.setProfessions(professions);
        form.setStudents(students);
        
        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
    }

// Здесь мы проверям какое действие нам надо сделать – и возвращаем ответ
    private int checkAction(HttpServletRequest req) throws SQLException, UnsupportedEncodingException {
        
        if (req.getParameter("Add") != null) {
            return 1;
        }
        if (req.getParameter("Edit") != null) {
            return 2;
        }
        if (req.getParameter("Marks") != null) {
            return 3;
        }
        if (req.getParameter("Delete") != null) {
            if (req.getParameter("studentId") != null) {
                ApplicantView s = new ApplicantView();
                s.setApplicantId(Long.parseLong(req.getParameter("studentId")));
                applicantFacade.deleteApplicant(s);
            }
            return 0;
        }
        return 0;
    }

    // Переопределим стандартные методы
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        processRequest(req, resp);
    }

}
