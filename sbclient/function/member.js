(function(){
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
                    html += '<tr><td>' + item.id + '</td><td>' + item.email + '</td><td>' + item.firstName + '</td><td>' + item.lastName + '</td><td>' + item.phoneNumber + '</td><td>' + tt + '</td><td>' + item.role.roleName + '</td>t<td>1</td></tr>';
                });
                table.append(html);
                $('.listMember').dataTable();
            }
        },
        error: function (error) {
            alert('Lỗi ko get đc thành viên');
        }
    });
})();

