/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function register(){
    
    var username = $("#txt_email").val();
    console.log($("#txt_email").val());
    var password = $("#txt_password").val();
    console.log($("#txt_password").val());
    var fist_name = $("#txt_first_name").val();
    console.log($("#txt_first_name").val());
    var last_name = $("#txt_last_name").val();
    console.log($("#txt_last_name").val());
    var phoneNumber = $("#phonenumber").val();
    
    var roleName = "user";
    var data = JSON.stringify({
        "email": username,
        "password": password,
        "firstName": fist_name,
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
                alert("Đăng ký thành công");
                window.location = "index.html";
            }
        },
        error: function (error) {
            //console.log("huu: " + error);
            alert("Sai thông tin đăng ký");
        }
    });
}