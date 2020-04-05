 <?php
 
 require "connection.php";
 // you have to first create your connetion

   $sql="SELECT * FROM  mylist";
    
    $res=mysqli_query($conn,$sql);
    $result=[];
   
   while($row=mysqli_fetch_assoc($res))
   {
      
      $result[]=['imgurl'=>$row['imgurl'],'title'=>$row['title'],'price'=>$row['price']];
       
   }
  echo json_encode($result);

?>
