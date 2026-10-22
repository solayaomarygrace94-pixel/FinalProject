/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskUtils {
    
    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    public static String validateInput(String description, String deadline) {
        if (description == null || description.trim().isEmpty()) {
            return "Task description cannot be empty!";
        }
        if (deadline == null || deadline.trim().isEmpty()) {
            return "Deadline cannot be empty!";
        }
        return "Valid";
    }
}
/**
 *
 * @author Computer Lab 3
 */


