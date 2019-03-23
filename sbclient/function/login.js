/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
            localStorage.setItem("mytokekeyheheheheeh", result.accessToken);
            if(typeof (result.accessToken) != 'undefined'){
                window.location = "admin/index.html";
            }
        },
        error: function (error) {
            console.log("huu: " + error);
            alert("SAi");
        }
    });
    
  
}


