<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import = "com.smartschool.dto.StudentGrade" %>



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

    .row{
      margin-top:20px;
      padding: 0 5px;
    }

    .clickable{
      cursor: pointer;
    }

    .panel-heading span {
	    margin-top: -5px;
	    font-size: 15px;
    }
    .row {
      margin-top: 30px;
      margin-bottom: 30px
    }

    </style>

    <script>
      function modalOpenFunction(eventObj) {
    	var tId = $(eventObj.currentTarget).data('teacher-id');
         $("#teacherId").val(tId);  
        var stdId = $(eventObj.currentTarget).data('student-id');
         $("#studentId").val(stdId);
        var exmId = $(eventObj.currentTarget).data('exam-id');
          $("#examId").val(exmId);
        var courseId = $(eventObj.currentTarget).data('course-id');
          $("#courseId").val(courseId);
      }

      $(document).on("click", ".open-Modal", modalOpenFunction);

      function formSubmit(){
        if($("#grade").val() >= 0){
          $("#modal_form").submit();
        } else {
          $("#failure-alert").fadeTo(2000, 500).slideUp(500, function(){
            $("#failure-alert").slideUp(500);
          });
        }
      }

      function onReadyFunction(){
        $("#failure-alert").hide();
        $("#failure-alert").removeAttr("style");
      }

      //$(document).ready(onReadyFunction);

    </script>

  </head>
  <body style="background-color:#e9ebee">
  <!-- ################### Header Starts ################################-->

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <a class="navbar-brand" href="#"><img alt="Brand" style="max-width:80px; margin-top: -22px;" src="logo5.png"></a>
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
    <div class="col-md-2"></div>
      <div class="col-md-8">

        <div class="alert alert-danger" role="alert" id="failure-alert" style="display: none;">
          <button type="button" class="close" data-dismiss="alert">x</button>
          <strong>Failure! </strong>
          Please provide a value greater or equal to Zero.
        </div>

        <div class="panel panel-default panel-body" style="background-color:#337ab7;color:white;">
          <!-- Exam Name -->
        </div>

        <table class="table table-hover">
          <thead>
            <tr>
              <th>Exam Name</th>
              <th>Grade</th>
            </tr>
          </thead>
          <tbody>
            
           <c:forEach items="${gradeList}" var="eachGrade">
            <tr>
              <td>${eachGrade.getExamName()}</td>
              <td>${eachGrade.getGrade()}</td>
            </tr>
          </c:forEach>
            
          </tbody>
        </table>
      </div>
    <div class="col-md-2"></div>
  </div>
  <!-- Pop - up Modal for change in marks -->
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Grade</h4>
        </div>

        <form action="./updateGrade" role="form" id="modal_form">
          <fieldset>
            <div class="modal-body">
              <div class="form-group">
                <input type="hidden" name="teacherId" id="teacherId" class="form-control input-md" required="">
              </div>	
              <div class="form-group">
                <input type="hidden" name="studentId" id="studentId" class="form-control input-md" required="">
              </div>
              <div class="form-group">
                <input type="hidden" name="examId" id="examId" class="form-control input-md" required="">
              </div>
              <div class="form-group">
                <input type="hidden" name="courseId" id="courseId" class="form-control input-md" required="">
              </div>
              <div class="form-group">
                <input type="number" min="1" name="grade" id="grade" class="form-control input-md" required="">
              </div>
            </div>
            <div class="modal-footer form-group">
              <button onclick="formSubmit()" class= "btn btn-primary" id="modalSubmitButton" name="modalSubmitButton" type="button" data-dismiss="modal">Submit</button>
            </div>
          </fieldset>
        </form>

      </div>
    </div>
  </div>

  </body>
</html>
