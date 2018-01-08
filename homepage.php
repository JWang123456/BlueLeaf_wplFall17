<?php
    session_start();

    $logout = '<a href="index.php?action=logout">Log out</a>';
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="homepage.css" rel="stylesheet">
</head>

<body>
<!---->
<!--<div class="container">-->
<!--    <nav class="navbar navbar-toggleable-md navbar-light bg-faded">-->
<!--        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"-->
<!--                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">-->
<!--            <span class="navbar-toggler-icon"></span>-->
<!--        </button>-->
<!--        <a class="navbar-brand" href="#">Blue Leaf</a>-->
<!---->
<!--        <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<!--            <ul class="navbar-nav mr-auto">-->
<!--                <li class="nav-item active">-->
<!--                    <a class="nav-link" href="profile.php">My profile <span class="sr-only">(current)</span></a>-->
<!--                </li>-->
<!--                <li class="nav-item">-->
<!--                    <a class="nav-link" href="registry.php">Create registry</a>-->
<!--                </li>-->
<!--                <li class="nav-item">-->
<!--                    <a class="nav-link disabled" href="#">Link</a>-->
<!--                </li>-->
<!--            </ul>-->
<!--            <form class="form-inline my-2 my-lg-0">-->
<!--                <input class="form-control mr-sm-2" type="text" placeholder="Search">-->
<!--                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
<!--            </form>-->
<!--        </div>-->
<!--    </nav>-->
<!---->
<!--</div>-->

<nav class="navbar navbar-toggleable-md navbar-light bg-faded sticky-top ">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <a class="navbar-brand" href="#" style="font-size:25px"> <img src="blueleaf.png" width="50px" style="border-radius: 50%"> Blue Leaf</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="profile.php">Profile <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="registry.php">Registry</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link2</a>
            </li>

        </ul>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            <button id= "logout" class="btn btn-outline-success my-2 my-sm-0" type="submit"><? echo $logout ?></button>
        </form>
    </div>
</nav>


<div id="jumbotron" class="jumbotron jumbotron-fluid container-fluid">
    <br class="my-5">
    <br class="my-5">


    <h1 class="display-4"><strong> Hi there! <br> IT IS NICE TO MEET YOU!</strong></h1>

    <br class="my-4">

    <p class="lead">
        <a class="btn btn-primary btn-lg" href="registry.php" role="button">Create Registry!</a>
    </p>
    <br class="my-4">
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

