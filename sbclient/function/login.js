/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* có token rồi thì vào trang chủ */
if (localStorage.getItem('myToken') != null) {
    window.location = 'index.html';
}

function login() {
    var username = $('#username').val();
    var password = $("#password").val();
    if(!username || !password){
        alert('Nhập đầy đủ thông tin');
        return false;
    }
    $('#btn-login').addClass('btn btn-info').html('<i class="fa fa-spinner fa-spin"></i> Đăng nhập');
    var data = JSON.stringify({
        "username": username,
        "password": password,
    });
    $.ajax({
        contentType: "application/json",
        dataType: "json",
        type: "post",
        url: "http://localhost:9999/api/authentication/login",
        data: data,
        success: function (result) {
            if (typeof (result.accessToken) != 'undefined') {
                localStorage.setItem("myToken", result.accessToken);
                localStorage.setItem("userName", result.userName);
                localStorage.setItem("userId", result.userId);
                localStorage.setItem("roleId", result.roleId);
                alert('Đăng nhập thành công!');
                window.location = "index.html";
            }else{
                $('#btn-login').removeClass('btn btn-info').addClass('btn btn-primary').html('Đăng nhập');
            }
        },
        error: function (error) {
            $('#btn-login').removeClass('btn btn-info').addClass('btn btn-primary').html('Đăng nhập');
            console.log(error);
            alert("Sai");
        }
    });
}
