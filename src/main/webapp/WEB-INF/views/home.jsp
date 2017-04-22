<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

  <head>
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script>
      //TODO: JSP ############################### please set auth error in jsp when required ##############################
      
      <c:choose>
    	<c:when test="${not empty error}">
    		var authError = ${error};
    	</c:when>
    	<c:otherwise>
    		var authError = false;
      	</c:otherwise>
	  </c:choose>
      
      
      function onLoadFunction(){
        if (authError) {
          var errorDiv = document.getElementById("errorDiv");
          errorDiv.style= "";
        }
        var formValidationObj = {
          framework: 'bootstrap',
          icon: {
           valid: 'glyphicon glyphicon-ok',
           invalid: 'glyphicon glyphicon-remove',
           validating: 'glyphicon glyphicon-refresh'
          },
          fields: {
            usertype: {
              validators: {
                notEmpty: {
                  message: 'Please select a user type'
                }
              }
            },
            password: {
              validators: {
                notEmpty: {
                  message: 'Please provide your password'
                },
                password: {
                  message: 'Please provide a valid password'
                },
                stringLength: {
                  min: 6,
                  max: 12,
                  message: 'Please provide a minimum 6 character password'
                }
              }
            },
            email: {
              validators: {
                notEmpty: {
                  message: 'Please provide your email'
                },
                emailAddress: {
                  message: 'Please provide a valid email'
                }
              }
            }
          }
        }

        $('#reg_form').bootstrapValidator(formValidationObj);
      }
    </script>
    <style>
      .alert {
       width:36%;
      }
    </style>
  </head>
  <body  onload="onLoadFunction()" style="background-color:#e9ebee" >
    <!-- ################### Header Starts ################################-->

    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <a class="navbar-brand" href="#"><img alt="Brand" style="max-width:80px; margin-top: -22px;" src="images/logo5.png"></a>
        </div>

      </div><!-- /.container-fluid -->
    </nav>

    <!-- ################### Header Ends ################################-->


    <div id ="errorDiv" class="row" style="display: none;">
      <div class="col-lg-4"></div>
      <div class="alert alert-danger col-lg-4" role="alert">
        <div style="text-align:center;border:1px">Please Enter correct email id or password!</div>
      </div>
    </div>

    <!--TODO: JSP ############################### set the form action ##############################-->
    <form role="form" action="/login" class="form-horizontal" id="reg_form" data-toggle="validator" method="post">
      <fieldset>
        <!-- User type input-->
        <div class="form-group">
          <label name="loginAs" class="col-md-4 control-label" for="usertype">Login As</label>
          <div class="col-md-4">
            <select id="usertype" name="usertype" class="form-control input-md" required="">
              <option value=""></option>
              <option value="1">Admin</option>
              <option value="2">Teacher</option>
              <option value="3">Student</option>
            </select>
          </div>
        </div><br>

    <!-- Email input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="email">Username</label>
            <div class="col-md-4">
              <input id="email" name="email" type="email" placeholder="Username" class="form-control input-md" required="">
            </div>
          </div><br>

    <!-- Password input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="passwordinput">Password</label>
            <div class="col-md-4">
              <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
            </div>
          </div><br>

    <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="formSubmitButton"></label>
          <div class="col-md-4">
            <button type="submit" id="formSubmitButton" name="formSubmitButton" class="btn btn-primary">submit</button>
          </div>
        </div>
      </fieldset>
    </form>
  </body>
</html>
