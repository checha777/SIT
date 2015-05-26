package students.view;

import students.entity.Subject;

public class SubjectView {

    private Long subjectId;
    public String subjectName;

    public SubjectView() {
    }

    public SubjectView(Subject s) {
        this.subjectId = s.getSubjectId();
        this.subjectName = s.getSubjectName();
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
