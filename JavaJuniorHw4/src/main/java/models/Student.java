package models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "second_name")
    private String last_name;
    @Column(name = "group_id")
    private Long groupId;

    public Student() {
    }

    public Student(Long id, String first_name, String last_name, Long groupId) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
