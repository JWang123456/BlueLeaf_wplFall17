<?php
session_start();
if(isset($_POST['submit'])){

    require 'connect.php';
    $email = $_POST['email'];
    $password = $_POST['password'];

    $result = mysqli_query($link, 'SELECT * FROM user WHERE email="'.$email.'" and password="'.$password.'"');
    $username = mysqli_query($link, 'SELECT userName FROM user WHERE email="'.$email.'"');

    if(mysqli_num_rows($result) == 1){
        $_SESSION['email'] = $email;
        header('Location: homepage.php');
    }else{
        echo "Email or password not correct.";
    }

}
    if(isset($_GET['logout'])){
        session_unset('email');
    }


?>




<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>BlueLeaf</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta charset="UTF-8"/> 
	<meta name = "keywords" content = "homework1, HTML, CSS, Gaojie"/>
	<meta name = "author" content="Gaojie Wang"/>
      <link rel="icon" href="blueleaf.png">
      <!-- Bootstrap core CSS -->
      <link href="https://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

      <!-- Custom styles for this template -->
      <link href="newlogin.css" rel="stylesheet">
  </head>

  <body>

  <div class="container">

      <form method="post" class="form-signin">
          <h2 class="form-signin-heading">Please sign in</h2>
          <label for="inputEmail" class="sr-only">Email address</label>
          <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
          <div class="checkbox">
                  <label>
                  <input type="checkbox" value="remember-me"/> Remember me
                  </label>
              <small><a href="changepass.html"> forget password?</a></small>
              <p>New here? <a href="signup.php"> Sign up</a></p>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit">Log in</button>
      </form>


  </div>




		<footer>
			<p>&copy All right reserved</p>
		</footer>
		
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  </body>
</html>


	