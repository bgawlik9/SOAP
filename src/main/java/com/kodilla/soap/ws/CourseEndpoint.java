package com.kodilla.soap.ws;

import com.kodilla.courses.soap.GetCourseRequest;
import com.kodilla.courses.soap.GetCourseResponse;
import com.kodilla.soap.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseEndpoint {
  private static final String NAMESPACE_URI = "http://kodilla.com/courses/soap";

  private final CoursesRepository coursesRepository;

  @Autowired
  public CourseEndpoint(CoursesRepository coursesRepository) {
    this.coursesRepository = coursesRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCourseRequest")
  @ResponsePayload
  public GetCourseResponse getCourse(@RequestPayload GetCourseRequest request) {
    GetCourseResponse response = new GetCourseResponse();
    response.setCourse(coursesRepository.findCourse(request.getName()));

    return response;
  }
}
