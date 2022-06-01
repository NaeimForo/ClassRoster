/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nfn.classroster;

import com.nfn.classroster.controller.ClassRosterController;
import com.nfn.classroster.dao.ClassRosterDaoFileImpl;
import com.nfn.classroster.dao.classRosterDao;
import com.nfn.classroster.ui.ClassRosterView;
import com.nfn.classroster.ui.UserIO;
import com.nfn.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author naeim
 */
public class App {
    
    public static void main (String[] args){
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        classRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller =
                new ClassRosterController(myDao, myView);
        controller.run(); 
        
    }
    
}
