CS 541 - Game Development for Mobile Platforms {Spring 2019}

Project 8 - Job Application Tracker


	1. Developed a client-server application using PHP, MySQL, WampServer and Java	
	

Application Details:-


	1. Summer is near. Everyone has stared looking for an internship or fulltime job. 
	2. This is a simple client-server application to keep track of your job applications.
	3. MySql database will store information about applications and their current status.
	4. User can perform add, view operations.


Application Workflow:-
    
	
	1. This application is based on client-server architecture. Application is a client and it sends get/post requests to server.
    2. Backend is developed using PHP and MySQL. Based on get/edit request from client PHP code sends query to MySQL database.
    3. Result of a query is then converted into a JSON format and sent back to a client. 
    4. On client side we parse the JSON response and display it on a user interface. 	
