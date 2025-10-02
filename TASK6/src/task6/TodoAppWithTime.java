package task6;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Calendar;

public class TodoAppWithTime {
    
    private static DefaultListModel<String> listModel;
    private static JList<String> taskList;
    private static JSpinner hourSpinner;
    private static JSpinner minuteSpinner;
    private static JComboBox<String> amPmComboBox;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        // Create main frame
        JFrame frame = new JFrame("To-Do List with Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        
        // Initialize components
        initializeComponents(frame);
        
        // Center and show frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static void initializeComponents(JFrame frame) {
        // Create models
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        // Create and add components
        mainPanel.add(createInputPanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(createTimePanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(createTaskListPanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(createButtonPanel(frame));
        
        frame.add(mainPanel, BorderLayout.CENTER);
    }
    
    private static JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        JTextField taskInput = new JTextField();
        taskInput.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JButton addButton = new JButton("Add Task");
        styleButton(addButton, new Color(34, 139, 34)); // Green color
        
        inputPanel.add(new JLabel("Task: "), BorderLayout.WEST);
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        
        // Add event listener
        addButton.addActionListener(e -> addTask(taskInput));
        taskInput.addActionListener(e -> addTask(taskInput));
        
        return inputPanel;
    }
    
    private static JPanel createTimePanel() {
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        timePanel.setBorder(BorderFactory.createTitledBorder("Select Time"));
        
        // Time spinner for hours (1-12)
        SpinnerNumberModel hourModel = new SpinnerNumberModel(12, 1, 12, 1);
        hourSpinner = new JSpinner(hourModel);
        JSpinner.NumberEditor hourEditor = new JSpinner.NumberEditor(hourSpinner, "00");
        hourSpinner.setEditor(hourEditor);
        hourSpinner.setPreferredSize(new Dimension(60, 30));
        
        // Time spinner for minutes (0-59)
        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
        minuteSpinner = new JSpinner(minuteModel);
        JSpinner.NumberEditor minuteEditor = new JSpinner.NumberEditor(minuteSpinner, "00");
        minuteSpinner.setEditor(minuteEditor);
        minuteSpinner.setPreferredSize(new Dimension(60, 30));
        
        // AM/PM selector
        String[] amPm = {"AM", "PM"};
        amPmComboBox = new JComboBox<>(amPm);
        amPmComboBox.setPreferredSize(new Dimension(60, 30));
        
        // Quick time buttons
        JButton nowButton = new JButton("Now");
        JButton clearTimeButton = new JButton("No Time");
        
        timePanel.add(new JLabel("Time:"));
        timePanel.add(hourSpinner);
        timePanel.add(new JLabel(":"));
        timePanel.add(minuteSpinner);
        timePanel.add(amPmComboBox);
        timePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        timePanel.add(nowButton);
        timePanel.add(clearTimeButton);
        
        // Set current time as default
        nowButton.addActionListener(e -> setCurrentTime());
        
        // Clear time selection
        clearTimeButton.addActionListener(e -> {
            hourSpinner.setValue(12);
            minuteSpinner.setValue(0);
            amPmComboBox.setSelectedItem("AM");
        });
        
        return timePanel;
    }
    
    private static JPanel createTaskListPanel() {
        JPanel taskListPanel = new JPanel(new BorderLayout());
        taskListPanel.setBorder(BorderFactory.createTitledBorder("Tasks"));
        
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(400, 250));
        
        taskListPanel.add(scrollPane, BorderLayout.CENTER);
        
        return taskListPanel;
    }
    
    private static JPanel createButtonPanel(JFrame frame) {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        JButton deleteButton = new JButton("Delete Selected");
        JButton clearAllButton = new JButton("Clear All");
        
        styleButton(deleteButton, Color.ORANGE);
        styleButton(clearAllButton, Color.RED);
        
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearAllButton);
        
        // Add event listeners
        deleteButton.addActionListener(e -> deleteSelectedTask(frame));
        clearAllButton.addActionListener(e -> clearAllTasks(frame));
        
        // Double-click to delete
        taskList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    deleteSelectedTask(frame);
                }
            }
        });
        
        return buttonPanel;
    }
    
    private static void setCurrentTime() {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        String amPmValue = now.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        
        hourSpinner.setValue(hour == 0 ? 12 : hour);
        minuteSpinner.setValue(minute);
        amPmComboBox.setSelectedItem(amPmValue);
    }
    
    private static void addTask(JTextField taskInput) {
        String task = taskInput.getText().trim();
        
        if (!task.isEmpty()) {
            try {
                // Get time values
                int hour = (int) hourSpinner.getValue();
                int minute = (int) minuteSpinner.getValue();
                String amPm = (String) amPmComboBox.getSelectedItem();
                
                // Format time string
                String timeString = String.format("%02d:%02d %s", hour, minute, amPm);
                String taskWithTime = String.format("[%s] %s", timeString, task);
                
                // Add to list
                listModel.addElement(taskWithTime);
                
                // Clear input and focus
                taskInput.setText("");
                taskInput.requestFocus();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, 
                    "Error processing time: " + ex.getMessage(), 
                    "Time Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "Please enter a task!", 
                "Empty Task", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static void deleteSelectedTask(JFrame frame) {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            String task = listModel.getElementAt(selectedIndex);
            int confirm = JOptionPane.showConfirmDialog(frame, 
                "Delete task: " + task + "?", 
                "Confirm Delete", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                listModel.remove(selectedIndex);
            }
        } else {
            JOptionPane.showMessageDialog(frame, 
                "Please select a task to delete!", 
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static void clearAllTasks(JFrame frame) {
        if (!listModel.isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(frame, 
                "Are you sure you want to clear all tasks?", 
                "Clear All Tasks", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                listModel.clear();
            }
        } else {
            JOptionPane.showMessageDialog(frame, 
                "The task list is already empty!", 
                "Empty List", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private static void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.darker());
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });
    }
}