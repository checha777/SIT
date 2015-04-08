/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author checha777
 */
@Entity
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByStudentId", query = "SELECT s FROM Students s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Students.findByFirstName", query = "SELECT s FROM Students s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Students.findBySurName", query = "SELECT s FROM Students s WHERE s.surName = :surName"),
    @NamedQuery(name = "Students.findByPatronymic", query = "SELECT s FROM Students s WHERE s.patronymic = :patronymic"),
    @NamedQuery(name = "Students.findByDateOfBirth", query = "SELECT s FROM Students s WHERE s.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Students.findBySex", query = "SELECT s FROM Students s WHERE s.sex = :sex"),
    @NamedQuery(name = "Students.findByGroupId", query = "SELECT s FROM Students s WHERE s.groupId = :groupId"),
    @NamedQuery(name = "Students.findByEducationYear", query = "SELECT s FROM Students s WHERE s.educationYear = :educationYear")})
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_id")
    private Integer studentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "surName")
    private String surName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "patronymic")
    private String patronymic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "sex")
    private Character sex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private int groupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "educationYear")
    private int educationYear;

    public Students() {
    }

    public Students(Integer studentId) {
        this.studentId = studentId;
    }

    public Students(Integer studentId, String firstName, String surName, String patronymic, Date dateOfBirth, int groupId, int educationYear) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.surName = surName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.groupId = groupId;
        this.educationYear = educationYear;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getEducationYear() {
        return educationYear;
    }

    public void setEducationYear(int educationYear) {
        this.educationYear = educationYear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.entity.Students[ studentId=" + studentId + " ]";
    }
    
}
