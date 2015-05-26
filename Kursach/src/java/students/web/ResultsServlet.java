package students.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import students.facade.ApplicantFacade;
import students.facade.ApplicantResultFacade;
import students.facade.ProfessionFacade;
import students.view.ApplicantView;
import students.view.ProfessionView;
import students.view.ApplicantResultView;

import students.web.forms.MainFrameForm;

public class ResultsServlet extends HttpServlet
{
    private ProfessionFacade professionFacade;
    private ApplicantFacade applicantFacade;
    private ApplicantResultFacade applicantResultFacade;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException, ParseException {
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(
                new String[]{"src/StudentExample.xml", "src/StudentDatabase.xml"});
        
         professionFacade = (ProfessionFacade)context.getBean("professionFacade");
         applicantFacade = (ApplicantFacade)context.getBean("applicantFacade");
         applicantResultFacade=(ApplicantResultFacade)context.getBean("applicantResultFacade");
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
        String sId = req.getParameter("studentId");
        // Если пользователь нажал кнопку ОК – тогда мы обновляем данные 
        if ( req.getParameter("OK") != null) {
            try {
                // Если ID студента больше 0, то мы редактируем его данные
                if (Integer.parseInt(sId) > 0) {
                    insertResult(req);
                } // Иначе это новый студент
                else {
                    
                    //updateResult(req);
                }
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            } catch (ParseException p_e) {
                throw new IOException(p_e.getMessage());
            }
        }
        if ( req.getParameter("Cancel") != null) {
           deleteResult(req); 
            
        }
            
        // А теперь опять получаем данные для отображения на главной форме
        String gs = req.getParameter("groupId");
        String ys = req.getParameter("educationYear");
        long groupId = -1;
        if (gs != null) {
            groupId = Integer.parseInt(gs);
        }
        int year = 2009;
        if (ys != null) {
            year = Integer.parseInt(ys);
        }
        MainFrameForm form = new MainFrameForm();
        List professions = professionFacade.findProfession();
        ProfessionView g = new ProfessionView();
        g.setProfessionId(groupId);
        if (groupId == -1) {
            Iterator i = professions.iterator();
            g = (ProfessionView) i.next();
        }
        Collection applicants = applicantFacade.findApplicant();
        form.setProfessionId(g.getProfessionId());
        form.setYear(year);
        form.setProfessions(professions);
        form.setStudents(applicants);
        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(ResultsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ResultsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(ResultsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ResultsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateResult(HttpServletRequest req) throws SQLException, ParseException {
        ApplicantResultView s = prepareResult(req);
        applicantResultFacade.updateApplicantResult(s);
    }

    private void insertResult(HttpServletRequest req) throws SQLException, ParseException {
        ApplicantResultView s = prepareResult(req);
        applicantResultFacade.addApplicantResult(s);
    }
private void deleteResult(HttpServletRequest req) throws SQLException, ParseException {
        ApplicantResultView s = prepareResult(req);
        applicantResultFacade.deleteApplicant(s);
    }
    private ApplicantResultView prepareResult(HttpServletRequest req) throws ParseException {
        ApplicantResultView s = new ApplicantResultView();
        s.setApplicantId(Long.parseLong(req.getParameter("studentId")));
        s.setSubjectId(Long.parseLong(req.getParameter("subjectId")));
        s.setApplicantResultId(Long.parseLong(req.getParameter("ResultId")));
        s.setMark(Integer.parseInt(req.getParameter("Mark").trim()));
    
        return s;
    }
}
