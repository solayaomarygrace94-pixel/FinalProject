/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;
import Model.TaskModel;
import Util.TaskUtil;
import javax.swing.*;
 import javax.swing.table.DefaultTableModel;
 
/**
 *
 * @author Computer Lab 3
 */

 public final class TaskController {
     private final DefaultTableModel tableModel;
     public TaskController(DefaultTableModel tableModel, MainForm view) {
         this.tableModel = tableModel;
         loadSampleTasks();
     }
     public void loadSampleTasks() {
         Object[][] sampleData = {
             {"Sample description", "2025-10-14", "2025-11-10", "Pending"},
             {"sample", "2026-09-24", "2026-11-05", "Pending"},
             {"Programming activity", "2025-10-14", "2025-11-09", "Pending"},
             {"Final Examination", "2025-10-17", "2025-10-24", "Pending"}
         };
         for (Object[] row : sampleData) {
             tableModel.addRow(row);
         }
     }
     public void saveTask(String desc, String date, String dead, String status) {
         if (!TaskUtil.validateInput(desc, dead)) {
             JOptionPane.showMessageDialog(null, 
                 "Description and Deadline are required!", 
                 "Warning", 
                 JOptionPane.WARNING_MESSAGE);
             return;
         }
         if (date == null || date.trim().isEmpty()) {
             date = TaskUtil.getCurrentDate();
         }
         if (status == null || status.trim().isEmpty()) {
             status = TaskUtil.getDefaultStatus();
         }
         TaskModel task = new TaskModel(desc, date, dead, status);
         tableModel.addRow(new Object[]{
             task.getDescription(),
             task.getDateCreated(),
             task.getDeadline(),
             task.getStatus()
         });
         JOptionPane.showMessageDialog(null, "Task saved successfully! ✅");
     }
     public void editTask(int selectedRow, String desc, String date, String dead, String status) {
         if (selectedRow == -1) {
             JOptionPane.showMessageDialog(null, 
                 "Select a task to edit!", 
                 "Warning", 
                 JOptionPane.WARNING_MESSAGE);
             return;
         }
         if (!TaskUtil.validateInput(desc, dead)) {
             JOptionPane.showMessageDialog(null, 
                 "Description and Deadline are required!", 
                 "Warning", 
                 JOptionPane.WARNING_MESSAGE);
             return;
         }
         tableModel.setValueAt(desc, selectedRow, 0);
         tableModel.setValueAt(date, selectedRow, 1);
         tableModel.setValueAt(dead, selectedRow, 2);
         tableModel.setValueAt(status, selectedRow, 3);
         JOptionPane.showMessageDialog(null, "Task updated! ✅");
     }
     public void deleteTask(int selectedRow) {
         if (selectedRow == -1) {
             JOptionPane.showMessageDialog(null, 
                 "Select a task to delete!", 
                 "Warning", 
                 JOptionPane.WARNING_MESSAGE);
             return;
         }
         int confirm = JOptionPane.showConfirmDialog(null, 
             "Delete this task?", 
             "Confirm", 
             JOptionPane.YES_NO_OPTION);
         if (confirm == JOptionPane.YES_OPTION) {
             tableModel.removeRow(selectedRow);
             JOptionPane.showMessageDialog(null, "Task deleted! ✅");
         }
}
}