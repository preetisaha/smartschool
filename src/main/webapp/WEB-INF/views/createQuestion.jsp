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

        var optionCount = 1;

        function onQuestionTypeSelect(){
          var questionType = $("#chooseOption").val();
          var addSign = $("#addSign");
          if(questionType == "1"){
            addSign.removeAttr('style');
          }
        }
		
        $(document).ready(onQuestionTypeSelect);
        
        function openTextOption(){
          var newDiv = $("#optionText");
          var textArea = $(
        		'<div class="form-group">'+
                  '<div class="input-group">'+
                    '<input name="optionText" type="text" class="form-control">'+
                    '<span class="input-group-btn">'+
                      '<select id="optionSelect" name="optionSelect" class="btn" required="">'+
                        '<option value="0">Incorrect</option>'+
                        '<option value="1">Correct</option>'+
                      '</select>'+
                    '</span>'+
                  '</div>'+
                '</div>'	  
          );
          newDiv.append(textArea);
          optionCount = optionCount + 1;
        }

    </script>
    <style>
      .alert {
       width:36%;
      }
    </style>
  </head>
  <body style="background-color:#e9ebee" >
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

<!--   ################ Body #############################-->
<div class="row">
  <div class="col-md-2"></div>
  <!-- Left Panel -->

  <div class="col-md-8">
    <!-- Body Panel -->
    <form role="form" action="./saveQuestion" class="form-horizontal" id="examType" data-toggle="validator" method="post">
      <fieldset>

	  <input id="teacherId" name="teacherId" type="hidden" class="form-control" value="${teacherId}" required="">
	  <input id="examId" name="examId" type="hidden" class="form-control" value="${examId}" required="">

	  <!--	
      <div class="form-group">
        <label name="examType"  class="control-label form-group" for="chooseOption"></label>
        <select id="chooseOption" placeholder="Select a type" name="chooseOption" class="form-control input-md" required="" onchange="onQuestionTypeSelect()">
          <option value="0">Essay</option>
          <option value="1">Multiple Choice</option>
        </select>
      </div>
      -->

	  <!-- For now we are going only for multiple answers -->	
	  <input id="chooseOption" name="chooseOption" type="hidden" class="form-control" value="1" required="">

      <div class="form-group">
        <label class="control-label form-group" for="questionTextArea"></label>
        <textarea name="question" placeholder="Write your question here..." class="form-control" rows="5" cols="30" id="questionTextArea"></textarea>
      </div>

      <div class="form-group">
        <label class="control-label form-group" for="marks"></label>
        <input id="marks" name="marks" type="number" class="form-control" title='Only Number' min="1" step="1" required="" placeholder="Provide marks here..">
      </div>

      <div id="addSign" style="display:none" class="form-group">
        <a href="#"><span style="text-align:center; display:block" class="glyphicon glyphicon-plus" aria-hidden="true" onclick="openTextOption()"></span></a>
      </div>

      <div id="optionText">
        <!-- Add dynamic option elements here -->
      </div>

      <!--   ################ Save Button #############################-->
      <div class="form-group">
        <button style="text-align:center; display:block" type="submit" id="formSubmitButton" name="formSubmitButton" class="btn btn-primary">Save</button>
      </div><br>

      </fieldset>
    </form>
  </div>

  <div class="col-md-2"></div>

</div>
  </body>
</html>
