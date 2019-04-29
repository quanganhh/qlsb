function loadData(){
    var table = $('.listMember tbody');
    $.ajax({
        dataType: "json",
        type: "get",
        url: "http://localhost:9999/api/user",
        headers: {
            "Authorization": "Bearer "+localStorage.getItem('myToken')
        },
        success: function (result) {
            if(typeof(result.dataList) != 'undefined'){
               table.empty();
                var html = '';
                $.each(result.dataList, function(i, item){
                    var tt = 'Đã kích hoạt';
                    if(item.status == 0) tt = 'Chưa kích hoạt';
                    html += '<tr><td>' 
                    + item.id 
                    + '</td><td>' 
                    + item.email 
                    + '</td><td>' 
                    + item.firstName 
                    + '</td><td>' 
                    + item.lastName 
                    + '</td><td>' 
                    + item.phoneNumber 
                    + '</td><td>' 
                    + tt 
                    + '</td><td>' 
                    + item.role.roleName 
                    + '</td><td><a onclick="getDataById(' + item.id + ')" class="btn btn-info">Cập nhật</a> <a onclick="del(' + item.id + ')" class="btn btn-danger">Xóa</a></td></tr>';
                });
                table.append(html);
                $('.listMember').dataTable();
            }
        },
        error: function (error) {
            alert('Lỗi ko get đc thành viên');
        }
    });
}

function del(id) {
    if (confirm('Bạn có chắc chắn muốn xóa người này?') == true) {
        $.ajax({
            url: 'http://localhost:9999/api/user/' + id,
            type: 'DELETE',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem('myToken')
            },
            success: function () {
                alert('Xóa thành công');
                window.location = 'index.html?view=member-list';
            },
            error: function (error) {
                alert('Lỗi');
            }
        });
    }
}

function getDataById(id) {
    $.ajax({
        url: 'http://localhost:9999/api/user/' + id,
        type: 'GET',
        headers: {
            "Authorization": "Bearer " + localStorage.getItem('myToken')
        },
        success: function (result) {
            if(result.isSuccess == true){
                $('#id').val(result.data.id);
                $('#email').val(result.data.email);
                $('#firstName').val(result.data.firstName);
                $('#lastName').val(result.data.lastName);
                $('#phoneNumber').val(result.data.phoneNumber);
                $('#avatarUrl').val(result.data.avatarUrl);
                $('#update').modal();
            }
        },
        error: function (error) {
            alert('Lỗi');
        }
    });
}
function update() {
    var id = $('#id').val();
    var email = $('#email').val();
    var password = $('#password').val();
    var fname = $('#firstName').val();
    var lname = $('#lastName').val();
    var phone = $('#phoneNumber').val();
    var avt = $('#avatarUrl').val();
    var active = $('#active').val();
    if (!id || !email || !password || !fname || !lname || !phone || !active) {
        alert('Nhập đầy đủ thông tin');
        return false;
    } else {
        var data = {
            id: id,
            firstName: fname,
            lastName: lname,
            roleId: 1,
            phoneNumber: phone,
            email: email,
            password: password,
            active: active,
            avatarUrl: avt
        };
        data = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:9999/api/user',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem('myToken')
            },
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: data,
            success: function (result) {
                if (result.isSuccess == true) {
                    alert('Cập nhật thành công');
                    window.location = 'index.html?view=member-list';
                }
            },
            error: function (error) {
                alert('Lỗi');
            }
        });
    }
}