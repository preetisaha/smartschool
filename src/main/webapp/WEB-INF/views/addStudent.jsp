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

    <script>
    function onLoadFunction(){
      var formValidationObj = {
        framework: 'bootstrap',
        icon: {
         valid: 'glyphicon glyphicon-ok',
         invalid: 'glyphicon glyphicon-remove',
         validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
          studentName: {
            validators: {
              notEmpty: {
                message: 'Please provide a name'
              }
            }
          },studentEmail: {
            validators: {
              notEmpty: {
                message: 'Please provide an email'
              },
              studentEmail: {
                message: 'Please provide a valid email'
              }
            }
          }
        }
      }
      $('#myForm').bootstrapValidator(formValidationObj);
    }


</script>

    <style>
    .header-dropdown-menu {
      width: 130px !important;
      min-width: 100px !important;
    }

    </style>
  </head>
  <body onload="onLoadFunction()"style="background-color:#e9ebee">
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
<!-- ################################## Body Column Starts #################################-->
  <div class="row">
    <div class="col-md-2"></div>

    <div class="col-md-8">
      <form id="myForm">
        <div class="form-group">
          <label for="studentName">Student Name</label>
          <input type="text" class="form-control" id="studentName" name="studentName" aria-describedby="emailHelp" placeholder="Enter Name">
        </div>

        <div class="form-group">
          <label for="studentEmail">Email address</label>
          <input type="email" class="form-control" name="studentEmail" id="studentEmail" aria-describedby="emailHelp" placeholder="Enter email">
        </div>

        <div><button type="Save" class="btn btn-primary">Save</button></div><br>
        </div>
      </div><br>

    </form>
  </div>
  <div class="col-md-2"></div>
  </div>




  </body>
</html>
