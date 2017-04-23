<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import = "com.smartschool.dto.AuthTeacher" %>
<%@ page import = "com.smartschool.domain.Course" %>

<!Doctype html>
<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   
    <style>
    .header-dropdown-menu {
      width: 130px !important;
      min-width: 100px !important;
    }

    </style>
  </head>
  <body style="background-color:#e9ebee">
  <!-- ################### Header Starts ################################-->

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <a class="navbar-brand" href="#"><img alt="Brand" style="max-width:80px; margin-top: -22px;" src="images/logo5.png"></a>
      </div>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">

          <!--  #######################  TODO: Provide user name ######################################-->
          <a href="#" class="dropdown-toggle header-dropdown-menu" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Name <span class="caret"></span></a>
          <ul class="dropdown-menu header-dropdown-menu">

            <!--  #######################  TODO: Add logout and home url ######################################-->
            <li ><a href="#">Home <span class="glyphicon glyphicon-home"></span></a></li>
            <li ><a href="#">Logout <span class="glyphicon glyphicon-log-out"></span></a></li>

          </ul>
        </li>
      </ul>
    </div><!-- /.container-fluid -->
  </nav>
  <!-- ################### Header Ends ################################-->

  <div class="row">
    
    <div class="col-md-2">
      <!-- ################### Left Margin ##############-->
    </div>
    
    <div id="teacherInfo" class="col-md-3">
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Name:</h3>
        </div>
        <!-- ################### TODO: Add 3 panel content here #################-->
        <div class="panel-body">
          ${authTeacher.getTeacherName()}
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Designation:</h3>
        </div>
        <div class="panel-body">
          ${authTeacher.getDesignation()}
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Email Id:</h3>
        </div>
        <div class="panel-body">
          ${authTeacher.getEmail()}
        </div>
      </div>
    </div>
    
  	<!-- ################### Column 3rd starts #################-->
    <div class="col-md-5">
      <div class="list-group">
        <a href="#" class="list-group-item active">Course List:</a>
        <!-- ################### TODO: Remove the items below and add courses in jsp #################-->
        
        <c:forEach items="${authTeacher.getCourse()}" var="eachCourse">
        	<a href="/teacherAction?teacherId=${authTeacher.getTeacherId()}&courseId=${eachCourse.getCourseId()}" class="list-group-item"><c:out value="${eachCourse.getCourseName()}"/></a>
        </c:forEach>
   
      </div>
    </div>

    <!-- ################### Column 3rd ends #################-->
    <div class="col-md-2">
    <!-- ################### Right Margin #################-->
    </div>
    
  </div>
   
  </body>
</html>
