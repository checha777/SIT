package students.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import students.facade.ApplicantFacade;
import students.facade.ProfessionFacade;
import students.facade.SubjectFacade;
import students.view.ApplicantResultView;
import students.view.ApplicantView;
import students.view.ProfessionView;
import students.view.SubjectView;

@ContextConfiguration(locations = {"/StudentExample.xml", "/StudentDatabase.xml"})
@TransactionConfiguration(transactionManager = "txManager")
public class StudentFacadeTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SubjectFacade subjectFacade;
    @Autowired
    private ProfessionFacade professionFacade;
    @Autowired
    private ApplicantFacade applicantFacade;

    @Test
    @Rollback(false)
    public void subjectTest() {
        SubjectView sv = new SubjectView();

        // Установим данные для предмета
        sv.setSubjectName("Супер");
        // Добавим
        Long idSubj = subjectFacade.addSubject(sv);
        // Перечитаем
        SubjectView sg = new SubjectView();
        sg = subjectFacade.getSubject(idSubj);
        // Убедимся, что считывание совпадает с тем, что записывали
        System.out.println("Имя нового предмета:");
        System.out.println(sg.getSubjectName());
        Assert.assertTrue(sg.getSubjectName().equals("Супер"));
        
    }
}