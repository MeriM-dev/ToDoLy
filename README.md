# ToDoLy

ToDoly is a todo list application written in Java that uses a text based user interface. (Class Diagram)[docs/ToDoLy-class-diagram.pdf]

### Prerequisites ###
Java version 12+

### Description ###
The project is a simple application that supports listing, creating, editing and removing tasks from the task list. The tasks are saved and loaded from a file on disk.

### User Manual ###
To use the ToDoly, follow the instructions:
Select an option from the main menu:
 >> Choose an option:
 * >> (1) Show 
 * >> (2) Add 
 * >> (3) Edit / Remove Task
 * >> (4) Save and Quit

**Listing tasks**

For listing the tasks, choose option number 1.
A submenu with 3 options are displayed:
 >> Order by: 
 * >> (1) Date 
 * >> (2) Project name
 * >> (3) Return to main menu

**Add tasks**

For creating a new task, choose option number 2. 
In order to create/add a task all the required fields must be entered:
* Enter task title:
* Enter due date (format: YYYY-MM-DD): 
* Enter task project: 

The task status is automatically set to IN PROGRESS, when created.

**Editing tasks**
   
For editing tasks, choose option number 3. 
A list of all tasks is printed in order to choose a task that should be edited. 

When the task is chosen, 
a submenu with 4 options is displayed:

 >> Choose an option:
 * >> (1) Update
 * >> (2) Remove
 * >> (3) Mark as done
 * >> (4) Return to main menu

**Saving and exiting**
   
All the created tasks and all the changes made while the application is running, will be saved when option number 4 is chosen.

### Running the tests ###
TODO

### Author ###
Mary Mihailovski Vanchovska Individual project - part of SDA 6