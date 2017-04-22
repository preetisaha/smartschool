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
          Panel content
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Email Id:</h3>
        </div>
        <div class="panel-body">
          Panel content
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Notification:</h3>
        </div>
        <div class="panel-body">
          Panel content
        </div>
      </div>
    </div>
  <!-- ################### Column 3rd starts #################-->
    <div class="col-md-5">
      <div class="list-group">


      <div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Mid Exam</h3>
					<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
				</div>
        <div class="list-group">
				<div class="panel-body"><a href="#" class="list-group-item open-Modal"><span data-toggle="modal" data-target="#myModal" data-course-id="m1" data-teacher-id= "4">Start Exam</span></a>
        </div>
			  </div>
      </div>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">See Grades</h3>
          <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
        </div>
        <div class="list-group">
        <div class="panel-body"><a href="#" class="list-group-item">Mid</a>
          <a href="#" class="list-group-item">Final</a>
        </div>
        </div>
      </div>
		</div>

    <!-- ################### Column 3rd ends #################-->
    <div class="col-md-2">
    <!-- ################### Right Margin #################-->
    </div>



  </body>
</html>
