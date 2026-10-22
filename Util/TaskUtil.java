/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
 import java.text.SimpleDateFormat;
 import java.util.Date;
/**
 *
 * @author Computer Lab 3
 */
public class TaskUtil {
   public static String getCurrentDate() {
         return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
     }
     public static String getDefaultStatus() {
         return "Pending";
     }
     public static boolean validateInput(String description, String deadline) {
         return !description.trim().isEmpty() && !deadline.trim().isEmpty();
     }
}
