/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Computer Lab 3
 */
public class TaskModel {
   private String description;
     private String dateCreated;
     private String deadline;
     private String status;
     public TaskModel(String description, String dateCreated, String deadline, String status) {
         this.description = description;
         this.dateCreated = dateCreated;
         this.deadline = deadline;
         this.status = status;
     }
     public String getDescription() { return description; }
     public void setDescription(String description) { this.description = description; }
     public String getDateCreated() { return dateCreated; }
     public void setDateCreated(String dateCreated) { this.dateCreated = dateCreated; }
     public String getDeadline() { return deadline; }
     public void setDeadline(String deadline) { this.deadline = deadline; }
     public String getStatus() { return status; }
     public void setStatus(String status) { this.status = status; }
}
