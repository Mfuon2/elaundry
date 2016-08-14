<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <link rel="stylesheet" type="text/css" href="tabs.css" />
    
</head>

<body>

<header>
	<h1>  <span style="color:#ffffff">Desk~X </span> <hr></h1>
</header>

<div class="container">
   
</div>

<div  class="container">
	
    <section class="tabblue">
		<ul  class="tabs blue">
		 
          <!-- registration -->
          <li>
            <input type="radio" name="tabs blue" id="tab1" checked />
            <label for="tab1">Register </label>
            <div id="tab-content1" class="tab-content">
             
              <form id="register-form" method="post" name="register" action="">
              
                <span class="tabaddon"><i class="fa fa-user fa-2x"></i></span>
                <input class="field" id="fullname" value="" name="fullname" required type="text" placeholder="Full Name" />
                
                <span class="tabaddon"><i class="fa fa-user fa-2x"></i></span>
                <input class="field" id="username" value="" name="username" required type="text" placeholder="Username" />
                
                <span class="tabaddon"><i class="fa fa-envelope fa-2x"></i></span>
                <input class="field" id="email" value="" name="email" required type="email" placeholder="example@gmail.com"/>
                
                <span class="tabaddon"><i class="fa fa-lock fa-2x"></i></span>
                <input class="field" id="password" name="password" onkeyup="validate()" type="password" placeholder="Password"/>
                <div id="Error"></div>
                
                 <span class="tabaddon"><i class="fa fa-lock fa-2x"></i></span>
                <input class="field" id="confirmpassword" value="" name="confirmpassword" onkeyup="validate()" required type="password" placeholder="Confirm Password"/>
                <div id="Error"></div>
                
                <span style="color: orange;" id="register-ajax-content"></span>                
                <span style="color:green;" id="register-success"></span>
				<div class="btn">
						<input type="submit" onclick="user.save()"  value="Register" />
						
						<div id="register-ajax-content" class="well col-sm-6 col-sm-offset-3"style="background-color: #FFF; border: 0px"></div>
				</div>
		</form>
            </div>
          </li>
          
          <!-- Login -->
      	  <li>
            <input type="radio" name="tabs blue" id="tab2" />
            <label for="tab2">Login</label>
            <div id="tab-content2" class="tab-content">
            
              <form method="post" name="register" action="${pageContext.request.contextPath}/main">
              <%--- --%>
              
                <span class="tabaddon"><i class="fa fa-envelope fa-2x"></i></span>
                <input class="field" id="username" value="" name="username" required type="text" placeholder="Username"/>
                
                <span class="tabaddon"><i class="fa fa-lock fa-2x"></i></span>
                <input class="field" id="password" value=""  name="password" required type="password" placeholder="Password"/>
                <select name="usertype" id="usertype">
					<option value="">--Select User Type--</option>
					<option value="support">Customer Support</option>
					<option value="tech">Technician</option>
					<option value="client">Client</option>
				</select> 
                <div class="btn">
                <!-- <input class="field" id="usertype" value=""  name="usertype" required type="text" placeholder="Usertype"/>  -->
                				
								<input type="submit" onclick="" value="Login"/>
                  
                </div>
              </form>
            </div>
          </li>
          
         
	</ul>
	</section>
</div>

 <script src="js/app/user.js"></script>
 <script src="dist/sweetalert.min.js"></script>
    
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
    <script src="js/login.js"></script>

</body>

</html>
