/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;
  import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author Computer Lab 3
 */
public class TaskUI extends JFrame{
   private JTable taskTable;
     private JTextField txtDescription, txtDateCreated, txtDeadline, txtStatus;
     private DefaultTableModel tableModel;
     private final TaskController controller;
     public TaskUI() {
         setTitle("My School Planner");
         setSize(750, 500);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(null);
         // Title
         JLabel title = new JLabel("My School Planner");
         title.setBounds(300, 15, 200, 30);
         title.setFont(new Font("Arial", Font.BOLD, 18));
         add(title);
         // Left: Table
         JLabel listLabel = new JLabel("List of Tasks");
         listLabel.setBounds(40, 55, 150, 25);
         listLabel.setFont(new Font("Arial", Font.BOLD, 12));
         add(listLabel);
         String[] columns = {"Description", "Date Created", "Deadline", "Status"};
         tableModel = new DefaultTableModel(columns, 0);
         taskTable = new JTable(tableModel);
         JScrollPane scrollPane = new JScrollPane(taskTable);
         scrollPane.setBounds(40, 85, 420, 370);
         add(scrollPane);
         // Right: Task Info
         JLabel infoLabel = new JLabel("Task Info");
         infoLabel.setBounds(500, 55, 150, 25);
         infoLabel.setFont(new Font("Arial", Font.BOLD, 12));
         add(infoLabel);
         JLabel lblDesc = new JLabel("Description:");
         lblDesc.setBounds(500, 85, 100, 25);
         add(lblDesc);
         txtDescription = new JTextField();
         txtDescription.setBounds(500, 110, 200, 30);
         add(txtDescription);
         JLabel lblDate = new JLabel("Date Created:");
         lblDate.setBounds(500, 150, 100, 25);
         add(lblDate);
         txtDateCreated = new JTextField();
         txtDateCreated.setBounds(500, 175, 200, 30);
         add(txtDateCreated);
         JLabel lblDead = new JLabel("Deadline:");
         lblDead.setBounds(500, 215, 100, 25);
         add(lblDead);
         txtDeadline = new JTextField();
         txtDeadline.setBounds(500, 240, 200, 30);
         add(txtDeadline);
         JLabel lblStatus = new JLabel("Status:");
         lblStatus.setBounds(500, 280, 100, 25);
         add(lblStatus);
         txtStatus = new JTextField();
         txtStatus.setBounds(500, 305, 200, 30);
         add(txtStatus);
         // Buttons
         JButton btnSave = new JButton("Save");
         btnSave.setBounds(500, 360, 95, 35);
         add(btnSave);
         JButton btnEdit = new JButton("Edit");
         btnEdit.setBounds(605, 360, 95, 35);
         add(btnEdit);
         JButton btnDelete = new JButton("Delete");
         btnDelete.setBounds(500, 410, 200, 35);
         add(btnDelete);
         // Initialize Controller
         controller = new TaskController(tableModel, null);
         // Button Actions
         btnSave.addActionListener(e -> saveTask());
         btnEdit.addActionListener(e -> editTask());
         btnDelete.addActionListener(e -> deleteTask());
         // Fill fields when row is clicked
         taskTable.getSelectionModel().addListSelectionListener(e -> {
             int selectedRow = taskTable.getSelectedRow();
             if (selectedRow != -1) {
                 txtDescription.setText(tableModel.getValueAt(selectedRow, 0).toString());
                 txtDateCreated.setText(tableModel.getValueAt(selectedRow, 1).toString());
                 txtDeadline.setText(tableModel.getValueAt(selectedRow, 2).toString());
                 txtStatus.setText(tableModel.getValueAt(selectedRow, 3).toString());
             }
         });
     }
     private void saveTask() {
         controller.saveTask(
             txtDescription.getText(),
             txtDateCreated.getText(),
             txtDeadline.getText(),
             txtStatus.getText()
         );
         clearFields();
     }
     private void editTask() {
         controller.editTask(
             taskTable.getSelectedRow(),
             txtDescription.getText(),
             txtDateCreated.getText(),
             txtDeadline.getText(),
             txtStatus.getText()
         );
         clearFields();
     }
     private void deleteTask() {
         controller.deleteTask(taskTable.getSelectedRow());
         clearFields();
     }
     private void clearFields() {
         txtDescription.setText("");
         txtDateCreated.setText("");
         txtDeadline.setText("");
         txtStatus.setText("");
     }
     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> new TaskUI().setVisible(true));
     } 
}
