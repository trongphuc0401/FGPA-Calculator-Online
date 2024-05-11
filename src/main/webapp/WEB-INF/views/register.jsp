<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FGPA Calculator - SignUp</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href ="../css/style.css">

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
</style>
</head>
<body>
<div class="container-fluid">
    <div class="row min-vh-100 justify-content-center align-items-center">
        <div class="col-md-8 col-lg-6 col-xl-4">
            <div class="card">
                <div class="card-body">
                    <a class="text-nowrap logo-img text-center d-block py-3">
                        <img src="https://logopond.com/logos/3cb45fba6d98dab35e993dcf3708831a.png" width="180" alt="">
                    </a>
                    <p class="text-center">Create your account and make 3.6+ on university</p>
                    <form action="register" method="post">
                        <div class="mb-3">
                            <label for="first_name" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="first_name" name="first_name" required>
                        </div>
                        <div class="mb-3">
                            <label for="last_name" class="form-label">Last Name</label>
                            <input type="text" class="form-control" id="last_name" name="last_name" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email Address</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="mb-3">
                            <label for="gender" class="form-label">Gender</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" id="male" value="true" checked>
                                <label class="form-check-label" for="male">Male</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" id="female" value="false">
                                <label class="form-check-label" for="female">Female</label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="status" class="form-label">Status</label>
                            <select class="form-select" id="status" name="status" required>
                                <option value="studying">Studying</option>
                                <option value="graduated">Graduated</option>
                                <option value="suspend">Suspend</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="image" class="form-label">Profile Image (3x4)</label>
                            <input class="form-control" type="file" id="image" name="image" accept="image/*" onchange="previewImage(event)">
                            <div id="image-preview" style="max-width: 300px; max-height: 400px; margin-top: 10px;"></div>
                            <small class="text-danger" id="image-error" style="display: none;">Image size should be 3x4 ratio.</small>
                        </div>
                        <input class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2" type="submit" value="Register">
                        <div class="d-flex align-items-center justify-content-center">
                            <p class="fs-4 mb-0 fw-bold">Already have an Account?</p>
                            <a class="text-primary fw-bold ms-2" href="login">Sign In</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function previewImage(event) {
        const file = event.target.files[0];
        const imagePreview = document.getElementById('image-preview');
        const imageError = document.getElementById('image-error');

        if (file) {
            const reader = new FileReader();
            reader.onload = function() {
                const img = new Image();
                img.onload = function() {
                    const width = img.width;
                    const height = img.height;
                    const ratio = width / height;

                    if (ratio >= 0.75 && ratio <= 0.8) { // 3x4 ratio is between 0.75 and 0.8
                        imagePreview.innerHTML = `<img src="${reader.result}" style="max-width: 100%; max-height: 100%;">`;
                        imageError.style.display = 'none';
                    } else {
                        imagePreview.innerHTML = '';
                        imageError.style.display = 'block';
                    }
                };
                img.src = reader.result;
            };
            reader.readAsDataURL(file);
        } else {
            imagePreview.innerHTML = '';
            imageError.style.display = 'none';
        }
    }
</script>
</body>
</html>