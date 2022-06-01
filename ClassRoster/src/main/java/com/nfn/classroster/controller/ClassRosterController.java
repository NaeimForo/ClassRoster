/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nfn.classroster.controller;

import com.nfn.classroster.dao.classRosterDao;
import com.nfn.classroster.dto.Student;
import com.nfn.classroster.ui.ClassRosterView;
import com.nfn.classroster.ui.UserIO;
import com.nfn.classroster.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author naeim
 */
public class ClassRosterController {
    
  
    private UserIO io = new UserIOConsoleImpl();
    
    private ClassRosterView view;
    private classRosterDao dao; 
    public ClassRosterController(classRosterDao dao, ClassRosterView view){
        this.dao = dao;
        this.view= view;
    }
    public void run () {
        boolean keepGoing = true; 
        int menuSelection = 0; 
        while (keepGoing){
            
            menuSelection = getMenuSelection();
          
       
            switch(menuSelection){
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false; 
                    break;
                default:
                    unknownCommand();
                    
            }
            
        }
        exitMessage();
    }
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
    private void createStudent(){
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSucessBanner();
        
    }
    private void listStudents(){
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    private void viewStudent(){
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
        
    }
    private void removeStudent(){
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    
    private void unknownCommand(){
        view.displayUnkownCommandBanner();
    }
    private void exitMessage(){
        view.displayExitBanner();
    }
}
