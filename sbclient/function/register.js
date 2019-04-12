/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* có token rồi thì vào trang chủ */

if(localStorage.getItem('myToken') !== null){
    window.location = 'index.html';
}
function register(){
    
    var username = $("#txt_email").val();
    var password = $("#txt_password").val();
    var first_name = $("#txt_first_name").val();
    var last_name = $("#txt_last_name").val();
    var phoneNumber = $("#phonenumber").val();
    var pass2 = $('#txt_password_confirm').val();
    if(!username || !password || !first_name || !last_name || !phoneNumber){
        alert('Nhập đầy đủ thông tin');
        return false;
    }
    if(password != pass2){
        alert('2 mật khẩu không khớp');
        return false;
    }
    $('#btn-reg').addClass('btn btn-info').html('<i class="fa fa-spinner fa-spin"></i> Đăng kí');
    var roleName = "user";
    var data = JSON.stringify({
        "email": username,
        "password": password,
        "firstName": first_name,
        "lastName" : last_name,
        "roleName": roleName,
        "phoneNumber": phoneNumber,
    });
    $.ajax({
        contentType: "application/json",
        dataType: "json",
        type: "post",
        url: "http://localhost:9999/api/authentication/signup",
        data: data,
        success: function (result) {
            if(result.isSuccess == true){
                $('#btn-reg').removeClass('btn btn-info').addClass('btn btn-primary').html('Đăng kí');
                alert("Đăng ký thành công");
                window.location = "login.html";
            }
        },
        error: function (error) {
            $('#btn-reg').removeClass('btn btn-info').addClass('btn btn-primary').html('Đăng kí');
            console.log(error);
            alert("Lỗi");
        }
    });
}