/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.Course;
import fr.utbm.coursewebapp.entity.Location;
import fr.utbm.coursewebapp.repository.HibernateCourseDAO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="courseService")
@SessionScoped
public class CourseService implements Serializable{
    
    public CourseService(){
        init();
    }
    
    private synchronized void init(){
        setCourse();
    }

    private List<Course> course;
    
    public List<Course> getCourse() {
        return course;
    }

    public void setCourse() {
        this.course = getAllCoursesService();
    }
    
    public List<Course> getAllCoursesService() {
        HibernateCourseDAO hcd = new HibernateCourseDAO();
        return hcd.getAllCoursesHibernate();
    }
}
