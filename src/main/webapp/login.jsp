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
	<h1>  <span style="color:#ffffff">Welcome To E-Laundry</span> <hr></h1>
</header>

<div class="container">
   
</div>

<div class="container">
	
    <section class="tabblue">
		<ul class="tabs blue">
          <li>
            <input type="radio" name="tabs blue" id="tab1" checked />
            <label for="tab1">Register</label>
            <div id="tab-content1" class="tab-content">
             
              <form method="post" name="register" action="#">
              
                <span class="tabaddon"><i class="fa fa-user fa-2x"></i></span>
                <input class="field" name="username" required type="text" placeholder="Username" />
                
                <span class="tabaddon"><i class="fa fa-envelope fa-2x"></i></span>
                <input class="field" name="email" required type="email" placeholder="example@gmail.com"/>
                
                <span class="tabaddon"><i class="fa fa-lock fa-2x"></i></span>
                <input id="pass" class="field" name="password" onkeyup="validate()" required type="password" placeholder="Password"/>
                <div id="Error"></div>
                <span class="tabaddon"><i class="fa fa-lock fa-2x"></i></span>
                <input class="field" name="password-confirm" required type="password" placeholder="Confirm Password"/>
               
                <div class="btn">
                  <input type="submit" value="Register"/>
                </div>
              </form>
            </div>
          </li>
          <!-- Login -->
      	  <li>
            <input type="radio" name="tabs blue" id="tab2" />
            <label for="tab2">Login</label>
            <div id="tab-content2" class="tab-content">
            
              <form method="post" name="register" action="#">
              
                <span class="tabaddon"><i class="fa fa-envelope fa-2x"></i></span>
                <input class="field" name="username" required type="email" placeholder="Username"/>
                
                <span class="tabaddon"><i class="fa fa-lock fa-2x"></i></span>
                <input class="field" name="password" required type="password" placeholder="Password"/>
                
                <div class="btn">
                  <input type="checkbox" name="terms" required>
                  <em>Keep me logged in </em>
                  <input type="submit" value="Login"/>
                </div>
              </form>
            </div>
          </li>
          	
          <li>
            <input type="radio" name="tabs blue" id="tab3" checked />
            <label for="tab3">Reset Password</label>
            <div id="tab-content3" class="tab-content">
              <form method="post" name="register" action="#">
                <span class="tabaddon"><i class="fa fa-user fa-2x"></i></span>
                <input class="field" type="text" placeholder="myusername" />
                <h4>OR</h4>
                <span class="tabaddon"><i class="fa fa-envelope fa-2x"></i></span>
                <input class="field" type="email" placeholder="myusername@gmail.com"/>
                <div class="btn">
                  <input type="submit" value="Get New One !"/>
                </div>
              </form>
            </div>
          </li>
          
          
          
        
	</ul>
	</section>
    
    
    
    
</div>

<footer>
</footer>

<script type="text/javascript">
function validate(){
	var input = document.getElementById("pass").value;
	if(input.length < 7){
		document.getElementById("Error").innerHTML = "Weak Password";
		document.getElementById("Error").style.color = "red"
	}else{
		document.getElementById("Error").innerHTML = "Strong Password";
		document.getElementById("Error").style.color = "white"
	}
}


</script>

</body>

</html>
