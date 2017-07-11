<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="tabs.css"/>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>

</head>

<body>

<header>
    <h1><span style="color:#ffffff">Desk~X </span>
        <hr>
    </h1>
</header>

<div class="container">

</div>

<%--<div class="container">--%>

<%--<section class="tabblue">--%>
<%--<!-- Login -->--%>
<%--<div class="tab-content">--%>
<%--<label>Login</label>--%>
<%--<form method="post" name="register" action="${pageContext.request.contextPath}/main">--%>
<%--&lt;%&ndash;- &ndash;%&gt;--%>
<%--&lt;%&ndash;<input class="field" id="username" value="" name="username" required type="text"&ndash;%&gt;--%>
<%--&lt;%&ndash;placeholder="Username"/>&ndash;%&gt;--%>

<%--<div class="form-group">--%>
<%--<label for="username">Name:</label>--%>
<%--<input class="form-control" id="username" name="username" required type="text"--%>
<%--placeholder="Username">--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label for="password">Password:</label>--%>
<%--<input type="password" name="password" required class="form-control" id="password" placeholder="Password">--%>
<%--</div>--%>

<%--<div  class="form-group">--%>
<%--<label for="usertype">User Type :</label>--%>
<%--<select class="form-control"  name="usertype" id="usertype">--%>
<%--<option value="admin">Administrator</option>--%>
<%--<option value="tech">Technician</option>--%>
<%--<option value="client">Staff</option>--%>
<%--</select>--%>
<%--</div>--%>

<%--<div class="btn">--%>
<%--<!-- <input class="field" id="usertype" value=""  name="usertype" required type="text" placeholder="Usertype"/>  -->--%>
<%--<input type="submit" onclick="" value="Login"/>--%>

<%--</div>--%>
<%--</form>--%>
<%--</div>--%>
<%--</section>--%>
<%--</div>--%>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="#" class="active" id="login-form-link">Login</a>
                        </div>
                        <div class="col-xs-6">
                            <a href="#" id="register-form-link">Register</a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="https://phpoll.com/login/process" method="post" role="form"
                                  style="display: block;">
                                <div class="form-group">
                                    <input type="text" name="username" id="username" tabindex="1" class="form-control"
                                           placeholder="Username" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group text-center">
                                    <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                    <label for="remember"> Remember Me</label>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                                                   class="form-control btn btn-login" value="Log In">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="text-center">
                                                <a href="https://phpoll.com/recover" tabindex="5"
                                                   class="forgot-password">Forgot Password?</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <form id="register-form" action="https://phpoll.com/register/process" method="post"
                                  role="form" style="display: none;">
                                <div class="form-group">
                                    <input type="text" name="username" id="username" tabindex="1" class="form-control"
                                           placeholder="Username" value="">
                                </div>
                                <div class="form-group">
                                    <input type="email" name="email" id="email" tabindex="1" class="form-control"
                                           placeholder="Email Address" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="confirm-password" id="confirm-password" tabindex="2"
                                           class="form-control" placeholder="Confirm Password">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="register-submit" id="register-submit"
                                                   tabindex="4" class="form-control btn btn-register"
                                                   value="Register Now">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
