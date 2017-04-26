<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import = "com.smartschool.dto.LoginAndTeacher" %>
<%@ page import = "com.smartschool.domain.Course" %>
<%@ page import = "com.smartschool.dto.AuthTeacher" %>
<%@ page import = "com.smartschool.service.ExamService" %>


<!Doctype html>
<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />

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

    .publish-button {
      line-height: 1 !important;
    }
    
    .allignInnerPanel{
    	margin-bottom: -6px !important;
    }

    </style>

    <script>
    $(document).on('click', '.panel-heading span.clickable', function(e){
        var $this = $(this);
	      if(!$this.hasClass('panel-collapsed')) {
		        $this.parents('.panel').find('.panel-body').slideUp();
		        $this.addClass('panel-collapsed');
		        $this.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');

	      } else {
		        $this.parents('.panel').find('.panel-body').slideDown();
		        $this.removeClass('panel-collapsed');
		        $this.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
	      }
    })

    function updateExamName(){
      $("#examName_form").submit();
    }
    
    function publishExam(){
      $("#publishExam_form").submit();
    }

    $( document ).ready(
      function() {

        // Set New Exam Modal Values on Modal click event
        $('#newExamModal').on('show.bs.modal', function(eventObj) {
          var teacherId = $(eventObj.relatedTarget).data('teacher-id');
            $("#teacherId").val(teacherId);
          var courseId = $(eventObj.relatedTarget).data('course-id');
            $("#courseId").val(courseId);
        });

        // Set Publish Exam Modal values
        $('#publishExamModal').on('show.bs.modal', function(eventObj) {
			var teacherId = $(eventObj.relatedTarget).data('teacher-id');
            	$("#pem_teacherId").val(teacherId);
          	var courseId = $(eventObj.relatedTarget).data('course-id');
            	$("#pem_courseId").val(courseId);
           	var examId = $(eventObj.relatedTarget).data('exam-id');
            	$("#pem_examId").val(examId);
        });

      }
    );

    </script>

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
          ${loginAndTeacher.getTeacherName()}
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Designation:</h3>
        </div>
        <div class="panel-body">
          ${loginAndTeacher.getDesignation()}
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Email Id:</h3>
        </div>
        <div class="panel-body">
          ${loginAndTeacher.getEmail()}
        </div>
      </div>
    </div>
  <!-- ################### Column 3rd starts #################-->
    <div class="col-md-5">
      <div class="list-group">

        <div class="panel panel-primary">
  				<div class="panel-heading">
  					<h3 class="panel-title">Edit Student Grades</h3>
  					<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
  				</div>
          <div class="list-group">
  			<div class="panel-body">
  				 <c:forEach items="${examStatus.getEditGrade()}" var="eachExamEditGrade">
 					<a href="/editFinalGrades?teacherId=${teacherId}&examId=${eachExamEditGrade.getExamId()}&courseId=${courseId}" class="list-group-item"><c:out value="${eachExamEditGrade.getExamName()}"/></a>
           		</c:forEach>
           	</div>
  		</div>
  	</div>

      <div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Generate Exam</h3>
			<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
		</div>
        <div class="list-group row">
  		  <div class="panel-body">
            <a href="#" class="list-group-item open-Modal"><span data-toggle="modal" data-target="#newExamModal" data-course-id="${courseId}" data-teacher-id= "${teacherId}">New Exam</span></a>
           
            <c:forEach items="${examStatus.getNotPublish()}" var="eachExam">
           		<a href="/createQuestion?teacherId=${teacherId}&examId=${eachExam.getExamId()}" class="list-group-item col-sm-10 allignInnerPanel"><c:out value="${eachExam.getExamName()}"/></a><div class="list-group-item col-sm-2 allignInnerPanel"><button data-toggle="modal" data-target="#publishExamModal" type="button" class="btn btn-success btn-sm pull-right publish-button" data-course-id="${courseId}" data-teacher-id="${teacherId}" data-exam-id="${eachExam.getExamId()}">Publish</button></div>
          	</c:forEach>
         
          </div>
		</div>
      </div>

	<!-- Only considering multiple choice questions -->
	<!--  
    <div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Grade Exam</h3>
			<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
		</div>
        <div class="list-group">
			<div class="panel-body">
				<c:forEach items="${examStatus.getGradeExam()}" var="eachGradeExam">
					<a href="/gradeExam?teacherId=${teacherId}&examId=${eachGradeExam.getExamId()}" class="list-group-item"><c:out value="${eachGradeExam.getExamName()}"/></a>
				</c:forEach>
		  	</div>
		</div>
	</div>
	-->
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Upcoming Exam</h3>
			<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
		</div>
	    <div class="list-group">
			<div class="panel-body">
				<c:forEach items="${examStatus.getUpcomingExam()}" var="eachUpcomingExam">
					<p class="list-group-item"><c:out value="${eachUpcomingExam.getExamName()}"/></p>
				</c:forEach>
	       	</div>
	  	</div>
	</div>
	
  	</div>
    	<!-- ################### Column 3rd ends #################-->
    <div class="col-md-2">
    	<!-- ################### Right Margin #################-->
    </div>
  </div>

    <!-- New Exam Modal -->
    <div class="modal fade" id="newExamModal" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Please enter exam name:</h4>
          </div>

          <form action="/createExam" role="form" id="examName_form">
            <fieldset>
              <div class="modal-body">
                <div class="form-group">
                  <input type="hidden" name="teacherId" id="teacherId" class="form-control input-md" required="">
                </div>

                <div class="form-group">
                  <input type="hidden" name="courseId" id="courseId" class="form-control input-md" required="">
                </div>
                <div class="form-group">
                  <input type="text" name="examName" id="examName" class="form-control input-md" required="">
                </div>

              </div>

              <div class="modal-footer form-group">
                <button onclick="updateExamName()" class= "btn btn-primary" id="modalSubmitButton" type="button" data-dismiss="modal">Submit</button>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>

    <!-- Publish Exam Modal -->
    <div class="modal fade" id="publishExamModal" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <form action="./publishExam" role="form" id="publishExam_form">
            <fieldset>
              <div class="modal-body">
                <div class="form-group">
                  <input type="hidden" name="teacherId" id="pem_teacherId" class="form-control input-md" required="">
                </div>

                <div class="form-group">
                  <input type="hidden" name="courseId" id="pem_courseId" class="form-control input-md" required="">
                </div>

                <div class="form-group">
                  <input type="hidden" name="examId" id="pem_examId" class="form-control input-md" required="">
                </div>

                <h4 class="modal-title">Enter exam start date:</h4>

                <div class="form-group">
                  <input type="text" placeholder="yyyy-mm-dd" name="startDate" id="startDate" class="form-control input-md" required="">
                </div>

                <h4 class="modal-title">Enter exam end date:</h4>

                <div class="form-group">
                  <input type="text" placeholder="yyyy-mm-dd" name="endDate" id="endDate" class="form-control input-md" required="">
                </div>
              </div>

              <div class="modal-footer form-group">
                <button onclick="publishExam()" class= "btn btn-primary" id="modalSubmitButton" type="button" data-dismiss="modal">Submit</button>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>

  </body>


</html>
