<?php

    $link = mysqli_connect('shareddb1e.hosting.stackcp.net',
        'blueleaf-323357c1', 'root@123', 'blueleaf-323357c1');

    if(!$link){
        die("Error happen during connecting database");
    }

?>