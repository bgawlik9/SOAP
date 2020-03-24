package com.kodilla.soap.repository;

import com.kodilla.courses.soap.Course;
import com.kodilla.courses.soap.Technology;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

@Component
public class CoursesRepository {
  private static final Map<String, Course> courses = new HashMap<>();

  @PostConstruct
  public void initData() {
    Course javaJdp = new Course();
    javaJdp.setName("Java Developer Plus");
    javaJdp.setTechnology(Technology.JAVA);
    javaJdp.setLength(9);

    courses.put(javaJdp.getName(), javaJdp);

    Course java = new Course();
    java.setName("Java Developer");
    java.setTechnology(Technology.JAVA);
    java.setLength(6);

    courses.put(java.getName(), java);

    Course webWdp = new Course();
    webWdp.setName("Web Developer Plus");
    webWdp.setTechnology(Technology.JAVASCRIPT);
    webWdp.setLength(9);

    courses.put(webWdp.getName(), webWdp);
  }

  public Course findCourse(String name) {
    Assert.notNull(name, "You have to specify the course's name");
    return courses.get(name);
  }
}
