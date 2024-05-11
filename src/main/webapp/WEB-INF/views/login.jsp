<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FGPA Calculator - Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	

<style>
body {
    background-color: #f8f9fa;
}

.card {
    border: 1px solid #dee2e6;
}

.alert-danger {
    background-color: #f8d7da;
    color: #721c24;
    border-color: #f5c6cb;
    padding: 10px;
    margin-bottom: 20px;
}

.alert-success {
    background-color: #d4edda;
    color: #155724;
    border-color: #c3e6cb;
    padding: 10px;
    margin-bottom: 20px;
}

@media (max-width: 767.98px) {
    .card {
        border: none;
    }
}

/* Alert */

.alert{
  background: #ffdb9b;
  padding: 20px 40px;
  min-width: 420px;
  position: absolute;
  right: 0;
  top: 10px;
  border-radius: 4px;
  border-left: 8px solid #ffa502;
  overflow: hidden;
  opacity: 0;
  pointer-events: none;
}
.alert.showAlert{
  opacity: 1;
  pointer-events: auto;
}
.alert.show{
  animation: show_slide 1s ease forwards;
}
@keyframes show_slide {
  0%{
    transform: translateX(100%);
  }
  40%{
    transform: translateX(-10%);
  }
  80%{
    transform: translateX(0%);
  }
  100%{
    transform: translateX(-10px);
  }
}
.alert.hide{
  animation: hide_slide 1s ease forwards;
}
@keyframes hide_slide {
  0%{
    transform: translateX(-10px);
  }
  40%{
    transform: translateX(0%);
  }
  80%{
    transform: translateX(-10%);
  }
  100%{
    transform: translateX(100%);
  }
}
.alert .fa-exclamation-circle{
  position: absolute;
  left: 20px;
  top: 50%;
  transform: translateY(-50%);
  color: #ce8500;
  font-size: 30px;
}
.alert .msg{
  padding: 0 20px;
  font-size: 18px;
  color: #ce8500;
}
.alert .close-btn{
  position: absolute;
  right: 0px;
  top: 50%;
  transform: translateY(-50%);
  background: #ffd080;
  padding: 20px 18px;
  cursor: pointer;
}
.alert .close-btn:hover{
  background: #ffc766;
}
.alert .close-btn .fas{
  color: #ce8500;
  font-size: 22px;
  line-height: 40px;
}
</style>

</head>

<body>

     <%
    if (request.getAttribute("error") != null) {
    %>
    <div class="alert hide">
         <span class="fas fa-exclamation-circle"></span>
         <span class="msg"><%=request.getAttribute("error")%></span>
         <div class="close-btn">
            <span class="fas fa-times"></span>
         </div>
      </div>  
    <%
    }
    %> 
     <%
    if (request.getAttribute("success") != null) {
    %>
     <div class="alert hide">
         <span class="fas fa-exclamation-circle"></span>
         <span class="msg"><%=request.getAttribute("success")%></span>
         <div class="close-btn">
            <span class="fas fa-times"></span>
         </div>
      </div>  
    <%
    }
    %> 

    <div class="container-fluid">
        <div class="row min-vh-100 justify-content-center align-items-center">
            <div class="col-md-8 col-lg-6 col-xl-4">
                <div class="card">
                    <div class="card-body">
                        <a class="text-nowrap logo-img text-center d-block py-3">
                            <img src="https://logopond.com/logos/3cb45fba6d98dab35e993dcf3708831a.png" width="180" alt="Logo">
                        </a>
                        <p class="text-center">FGPA Calculator Application help you get A+</p>
                        <form action="login" method="post" onsubmit="return validateForm()">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required>
                            </div>
                            <div class="mb-4">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <div class="form-check">
                                    <input class="form-check-input primary" type="checkbox" value="" id="flexCheckChecked" checked>
                                    <label class="form-check-label text-dark" for="flexCheckChecked">
                                        Remember this Device
                                    </label>
                                </div>
                                <a class="text-primary fw-bold" href="./index.html">Forgot Password?</a>
                            </div>
                            <input class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2" type="submit" value="Login">
                            <div class="d-flex align-items-center justify-content-center">
                                <p class="fs-4 mb-0 fw-bold">New to Student?</p>
                                <a class="text-primary fw-bold ms-2" href="register">Create an account</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script>
    <%
    if (request.getAttribute("error") != null) {
    %>
    $('input').click(function(){
        $('.alert').addClass("show");
        $('.alert').removeClass("hide");
        $('.alert').addClass("showAlert");
        setTimeout(function(){
          $('.alert').removeClass("show");
          $('.alert').addClass("hide");
        },5000);
      });
      $('.close-btn').click(function(){
        $('.alert').removeClass("show");
        $('.alert').addClass("hide");
      });
    <%
    }
    %> 
    
      /*  */
	function validateForm() {
			const emailInput = document.getElementById('<%= session.getAttribute("user.email") %>');
			const passwordInput = document.getElementById('password');
			const email = emailInput.value.trim();
			const password = passwordInput.value.trim();

			if (!email) {
				showAlert('Email is required', 'danger');
				emailInput.focus();
				return false;
			}

			if (!isValidEmail(email)) {
				showAlert('This is not valid email format', 'danger');
				emailInput.focus();
				return false;
			}

			if (!password) {
				showAlert('Password is required', 'danger');
				passwordInput.focus();
				return false;
			}

			if (password.length < 8) {
				showAlert('Password is too short (Minimum 8 characters)',
						'danger');
				passwordInput.focus();
				return false;
			}

			// Kiểm tra email và mật khẩu với server
			// Nếu đúng, hiển thị thông báo thành công
			// showAlert('Login successful', 'success');

			return true;
		}

		function isValidEmail(email) {
			const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
			return emailRegex.test(email);
		}

		function showAlert(message, type) {
			const alertContainer = document.getElementById(`${type}-alert`);
			if (alertContainer) {
				alertContainer.textContent = message;
				alertContainer.style.display = 'block';
			}
		}
	</script>
</body>
</html>