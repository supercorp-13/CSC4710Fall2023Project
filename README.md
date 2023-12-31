# CSC 4710 Fall 2023 Project: "Tree Cutting Service"
A collaborative project by D Barnes and Nadinne Motta. 

### Table of Contents
+ About the Project
+ How to Run Project
+ Project Parts and Contributors
+ Contact Information

# About the Project
The David Smith Tree Cutting Service page is a web project integrating Eclipse, Apache Tomcat, and mySQL. We used SQL, Java, Javascript, and HTML to build this website. 

# How to run Project
### To run the project, begin by making sure you have:
+ Eclipse for Java and Web Developers: 
You can download this through the official Eclipse website.

+ Apache Tomcat Server: 
You can download this through the Apache Tomcat Website (version 8) and follow the installation instructions provided by the website.

+ JAVA_HOME and CATALINA_HOME Setup:
Finally, set up (in System Environment Variables):
* JAVA_HOME: Point it to Java installation root
* CATALINA_HOME: Point it to your Tomcat installation directory.

### Runnning Project
1. Place project zip file (download in the github directory in the 'Code' by pressing "Download Zip")
2. Add that extracted file to the Eclipse workspace (Windows (:C) -> Users -> your_user -> eclipse-workspace).
3. Open Eclipse and import that folder into the workspace (use Import -> import from existing workspace).
4. Start running your Apache TomCat Server (down in Servers tab) and add the folder to it.
6. From here, you can find the .jsp files and run those, the recommended order is:
 + To register/be a client:
   - login.jsp
   - Then, register as a user, go back to login, and login with the email and password you put down.
   - After this, create a request for a tree cutting and submit it.
   - David Smith will send you a quote, and you will be able to respond to it in a comment.
   - After sending the comment, David Smith will respond, and you will have the option to accept or decline the quote.

 + To view root/database:
   - login.jsp
   - Log in with email: root, password: root1234
   - This will allow you to view all the tables, as well as initialize the database.

 + To be David Smith:
   - login.jsp
   - Log in with email: david@gmail.com, password: david1234
   - This will allow you to view David Smith's dashboard with the list of trees requested, and to write a quote for a tree and send it.
   - This page will also allow David Smith to respond to a client's comment. 

# Project Parts and Contributors
## Part 1: Combined Hours of work: 35
+ D:
  - Created ER Diagram
  - Defined tables for the part 1
  - Assisted with coding for part 1
+ Nadinne:
  - Completed Github setup + integration
  - Assisted with coding for part 1
  - Helped with ER Diagram

## Part 2: Combined Hours of work: 80
+ D:
  - Coded the "quote responses" for the client and David Smith
  - Assisted with coding for part 2
  - Troubleshooted code
+ Nadinne:
  - Completed Github setup + integration
  - Assisted with coding for part 2
  - Troubleshooted code
  - 
## Part 3: Combined Hours of work: 30
+ D:
  - Coded the rootview to show all data
  - Assisted with coding for part 3
  - Troubleshooted code
+ Nadinne:
  - Completed Github setup + integration
  - Assisted with coding for part 3
  - Troubleshooted code
    
# Contact Information
- D Barnes: go7691@wayne.edu, D-Barnes-CS on Github
- Nadinne Motta: hl1179@wayne.edu, supercorp-13 on Github
