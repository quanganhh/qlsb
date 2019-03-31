/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* chưa có token  thì vào ra đăng nhập */
if(localStorage.getItem('myToken') == null){
    window.location = 'login.html';
}