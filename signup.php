<?php

    require 'connect.php';

    $email = $_POST['email'];
    $password = $_POST['password'];
    $username = $_POST['username'];
    $usertype = 1;

    $query = "INSERT INTO user (`email`, `password`, `userName`, `userType`)
VALUES ('$email', '$password', '$username', '$usertype')";

    $result = mysqli_query($link, $query);

    if($result){
        $success = '<div class="alert alert-success" 
role="alert"><p><strong>Register succeed!</strong></p><div>';
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
    <link href="newsignup.css" rel="stylesheet">
</head>

<body>

<div class="container">
<form class="form-horizontal" action='' method="POST">
    <fieldset>
        <div id="legend">
            <legend class="">Register</legend>
        </div>
        <div class="control-group">
            <!-- Username -->
            <label class="control-label"  for="username">Username</label>
            <div class="controls">
                <input type="text" id="username" name="username" class="input-xlarge" onkeypress="Validate(this.value)" placeholder="minimal 6 letters">
                <p id="err"></p>
            </div>
        </div>

        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="email">E-mail</label>
            <div class="controls">
                <input type="text" id="email" name="email" onkeypress="email_validate(this.value)" placeholder="" class="input-xlarge">
                <p id="status"></p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="pass1" name="password" placeholder="" class="input-xlarge">
                <p class="help-block"></p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password -->
            <label class="control-label"  for="password_confirm">Confirm Password</label>
            <div class="controls">
                <input type="password" id="pass2" name="password_confirm" placeholder="" class="input-xlarge">
                <p id="confirmMessage"></p>
            </div>
        </div>

        <div id="message"><? echo $success ?></div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success" type="submit">Register</button>
                <button class="btn btn-success" type="button" onclick="window.location.href='index.php'">Finish</button>
            </div>
        </div>
    </fieldset>
</form>

</div>






<!-- Optional JavaScript -->
<script src="newsignup.js"/>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>