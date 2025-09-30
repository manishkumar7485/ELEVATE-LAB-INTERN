# Interview Questions & Answers

## Task #6. Java Swing To-Do Appp

### 1. What is Swing?
*** Answer: *** Swing is a GUI widget toolkit for Java that provides lightweight components for building desktop applications.

### 2. AWT vs Swing
*** Answer: ***
* ``AWT:`` Uses native OS components, platform-dependent

* ``Swing:`` Pure Java components, consistent across platforms

### 3. ActionListener
*** Answer: *** 
Interface that handles button clicks and other actions. We implement actionPerformed() method.

### 4. Layout Managers
*** Answer: *** 
* ```BorderLayout:``` Divides container into 5 regions (NORTH, SOUTH, EAST, WEST, CENTER)

* ```FlowLayout:``` Arranges components in a left-to-right flow

### 5. Event Dispatch Thread (EDT)
*** Answer: *** 
Special thread in Swing for handling GUI events. All GUI updates must happen on EDT using SwingUtilities.invokeLater().

### 6. GUI Components Used
*** Answer: ***
* ```JFrame:``` Main window
* ```JPanel:``` Container for organizing components
* ```JTextField:``` Text input
* ```JButton:``` Clickable buttons
* ```JList:``` Display list of items
* ```JScrollPane:``` Adds scrolling capability

###7. Event Handling
*** Answer: ***
We handle multiple events using separate ActionListener implementations for each button.
 
### 8. JPanel vs JFrame
*** Answer: *** 
* ```JFrame:``` Top-level container (window)
* ```JPanel:``` Generic container for grouping components

### 9. Scroll Bar
*** Answer: ***
Added using JScrollPane wrapper around JList.

### 10. MVC Architecture
*** Answer: ***
* ```Model:``` DefaultListModel stores the data
* ```View:``` JList displays the data
* ```Controller:``` ActionListener handles user input