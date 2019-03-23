/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    check_token();
});

function check_token(){
    var token = localStorage.getItem("mytokekeyheheheheeh");
    if(token == null){
        window.location = "../index.html";
    }
}