package test;

import java.util.List;

public class Faculty {
    private String name;

    private String post;

    private String course;

    private String department;

    private List<String> presents;

    private List<String> absents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getPresents() {
        return presents;
    }

    public void setPresents(List<String> presents) {
        this.presents = presents;
    }

    public List<String> getAbsents() {
        return absents;
    }

    public void setAbsents(List<String> absents) {
        this.absents = absents;
    }
}
