SshCrud
=======

a struts2 spring hibernate integration project

This is a maven project, using springframework 3.2.8, struts 2.3, hibernate 4.3.5, and other facilities as you may find out in pom.xml.
This project implements CRUD operations over JDBC and Hibernate, however Hibernate version needs to be updated when deployed with Spring for transcation issue.
Not all functionalities are implemented for each kind of operations here, Struts 2 take over the MVC part, 
and Springframework provides IoC/DI and Trasactional management, and Jdbc/Hibernate realized the DAO layer.
For data source, a sample MySql table is used here, with configuration info in applicationContext.xml and Jdbc part of code as well.
All .jsp pages are only responsible for basic function (displaying results), more effort in css, html, and Jquery are needed in the future. 
