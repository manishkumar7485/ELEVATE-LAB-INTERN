package task6;

import java.awt.*;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.*;

public class TodoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        //Create main frame
        JFrame frame = new JFrame("To-Do-List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10, 10));
//        frame.setLocation(300, 300);

        //add some padding
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //Create components
        JTextField taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Selected");
        JButton clearAllButton = new JButton("Clear All");
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
//        taskList.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(400, 400));
        
        //create panels for better organization
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearAllButton);
        
        //Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
                
        //Add action listeners for buttons
        addButton.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                addTask(taskInput, listModel, frame);
            }            
        });
        
        deleteButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                deleteSelectedTask(taskList, listModel, frame);
            }
        });
        
        clearAllButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                clearAllTask(listModel, frame);
            }            
        });
        
        //Enter key support
        taskInput.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                 addTask(taskInput,listModel,frame);
            }
        });
        
        //Center and show frame
        frame.setLocationRelativeTo(null);        
        frame.setVisible(true); 
    }
    
    private static void addTask(JTextField taskInput, DefaultListModel<String> listModel, JFrame frame) {
        String task = taskInput.getText().trim();
        if(!task.isEmpty()){
            listModel.addElement(task);
            taskInput.setText("");//clearing
            taskInput.requestFocus();//focus on textfield
        }else{
            JOptionPane.showMessageDialog(frame, "Please enter a task!", "Empty Task", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static void deleteSelectedTask(JList<String> taskList, DefaultListModel<String> listModel, JFrame frame) {
        int selectedIndex = taskList.getSelectedIndex();
        if(selectedIndex != -1){
            listModel.remove(selectedIndex);
        }else{
            JOptionPane.showMessageDialog(frame,"Please select a task to delete!", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static void clearAllTask(DefaultListModel<String> listModel, JFrame frame) {
        if(!listModel.isEmpty()){
            int confirm = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you wat to clear all tasks?",
                    "Clear All Tasks",
                    JOptionPane.YES_NO_OPTION);
            
            if(confirm == JOptionPane.YES_OPTION){
                listModel.clear();
            }
        }else{
            JOptionPane.showMessageDialog(frame, 
                "The task list is already empty!", 
                "Empty List", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
