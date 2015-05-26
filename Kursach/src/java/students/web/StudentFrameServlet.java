package students.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
import students.view.ApplicantView;
import students.view.ProfessionView;

import students.web.forms.MainFrameForm;

public class StudentFrameServlet extends HttpServlet
{
    private ProfessionFacade professionFacade;
    private ApplicantFacade applicantFacade;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
        
        
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(
                new String[]{"src/StudentExample.xml", "src/StudentDatabase.xml"});
        
         professionFacade = (ProfessionFacade)context.getBean("professionFacade");
         applicantFacade = (ApplicantFacade)context.getBean("applicantFacade");
        
        
        String sId = req.getParameter("studentId");
        // Если пользователь нажал кнопку ОК – тогда мы обновляем данные (добавляем нового студента)
        if (sId != null && req.getParameter("OK") != null) {
            try {
                // Если ID студента больше 0, то мы редактируем его данные
                if (Integer.parseInt(sId) > 0) {
                    updateStudent(req);
                } // Иначе это новый студент
                else {
                    insertStudent(req);
                }
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            } catch (ParseException p_e) {
                throw new IOException(p_e.getMessage());
            }
        }
        // А теперь опять получаем данные для отображения на главной форме
        String gs = req.getParameter("groupId");
        String ys = req.getParameter("educationYear");
        long groupId = -1;
        if (gs != null) {
            groupId = Integer.parseInt(gs);
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
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
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void updateStudent(HttpServletRequest req) throws SQLException, ParseException {
        ApplicantView s = prepareStudent(req);
        applicantFacade.updateApplicant(s);
    }

    private void insertStudent(HttpServletRequest req) throws SQLException, ParseException {
        ApplicantView s = prepareStudent(req);
        applicantFacade.addApplicant(s);
    }

    private ApplicantView prepareStudent(HttpServletRequest req) throws ParseException {
        ApplicantView s = new ApplicantView();
        s.setApplicantId(Long.parseLong(req.getParameter("studentId")));
        s.setFirstName(req.getParameter("firstName").trim());
        System.out.println("вот что я реально получил:");
        System.out.println(req.getParameter("firstName").trim());
        s.setLastName(req.getParameter("surName").trim());
        s.setMiddleName(req.getParameter("patronymic").trim());
        s.setProfessionId(Long.parseLong(req.getParameter("professionId").trim()));
        s.setEntranceYear(Integer.parseInt(req.getParameter("educationYear").trim()));
        return s;
    }
}
