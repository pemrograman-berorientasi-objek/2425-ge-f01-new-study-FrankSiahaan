package pbo.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "kode", length = 20, nullable = false)
    private String kode;

    @Column(name = "nama_crs", length = 50, nullable = false)
    private String nama_crs;

    @Column(name = "semester", length = 5, nullable = false)
    private String semester;

    @Column(name = "kredit", length = 5, nullable = false)
    private String kredit;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {

    }

    public Course(String kode, String nama_crs, String semester, String kredit) {
        this.kode = kode;
        this.nama_crs = nama_crs;
        this.semester = semester;
        this.kredit = kredit;
    }

    public Course(String kode, String nama_crs, String semester, String kredit, List<Student> students) {
        this.kode = kode;
        this.nama_crs = nama_crs;
        this.semester = semester;
        this.kredit = kredit;
        this.students = students;
    }

    public String getKode() {
        return kode;
    }

    public String getNama_crs() {
        return nama_crs;
    }

    public String getSemester() {
        return semester;
    }

    public String getKredit() {
        return kredit;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama_crs(String nama_crs) {
        this.nama_crs = nama_crs;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setKredit(String kredit) {
        this.kredit = kredit;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return kode + "|" + nama_crs + "|" + semester + "|" + kredit;
    }

}
