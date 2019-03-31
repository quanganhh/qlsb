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
    console.log(username);
    var password = $("#password").val();
    console.log(password);
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
            //console.log(result.accessToken);
            if (typeof (result.accessToken) != 'undefined') {
                localStorage.setItem("myToken", result.accessToken);
                window.location = "index.html";
            }
        },
        error: function (error) {
            console.log("huu: " + error);
            alert("SAi");
        }
    });
}
