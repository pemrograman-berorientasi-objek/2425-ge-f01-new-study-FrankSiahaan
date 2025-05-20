package pbo.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "nim", length = 50, nullable = false)
    private String nim;

    @Column(name = "nama_std", length = 50, nullable = false)
    private String nama_std;

    @Column(name = "prodi", length = 50, nullable = false)
    private String prodi;

    @ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinTable(name = "enroll", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "nim"),
    inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "kode"))
    private List<Course> courses;

    public Student() {

    }

    public Student(String nim, String nama_std, String prodi) {
        this.nim = nim;
        this.nama_std = nama_std;
        this.prodi = prodi;
    }

    public Student(String nim, String nama_std, String prodi, List<Course> courses) {
        this.nim = nim;
        this.nama_std = nama_std;
        this.prodi = prodi;
        this.courses = courses;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama_std(String nama_std) {
        this.nama_std = nama_std;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getNim() {
        return nim;
    }

    public String getNama_std() {
        return nama_std;
    }

    public String getProdi() {
        return prodi;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return this.nim + "|" + this.nama_std + "|" + this.prodi;
    }
}
