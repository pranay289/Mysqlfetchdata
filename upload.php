<!DOCTYPE html>
<html>
<body>

<form action="upload.php" method="POST" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="title"/>
    <input type="text" name="price" placeholder="price"/>
    Select image to upload:
    <input type="file" name="image" id="fileToUpload">
    <input type="submit" value="Upload Image" name="submit">
</form>

</body>
</html>

<?php

 require "connection.php";
// you have to make connection.php and add connection after you have to add in anywere where you want to put data in to database


 
move_uploaded_file($_FILES["image"]["tmp_name"],"uploads/" . $_FILES["image"]["name"]);			
$location=$_FILES["image"]["name"];
$fname=$_POST['first_name'];
$lname=$_POST['last_name'];
$title=$_POST['title'];
$price=$_POST['price'];

$loc="https://www.webrooper.com/androiddb/uploads/".$location; 

$sql ="INSERT INTO `mylist` (`id`, `imgurl`,`title`,`price`) VALUES (NULL,'$loc','$title','$price')";
$qury=mysqli_query($conn,$sql);
if($qury)
{
echo "Success";
}


