(function(){
    var table = $('.listPitch tbody');
    $.ajax({
        dataType: "json",
        type: "get",
        url: "http://localhost:9999/api/scfield",
        headers: {
            "Authorization": "Bearer "+localStorage.getItem('myToken')
        },
        success: function (result) {
            if(typeof(result.dataList) != 'undefined'){
               table.empty();
                var html = '';
                $.each(result.dataList, function(i, item){
                    var tt = 'Chưa được đặt';
                    if(item.status == 1) tt = 'Đã được đặt';
                    html += '<tr><td>' + item.id + '</td><td>' + item.address + '</td><td>' + item.description + '</td><td>' + item.name + '</td><td>' + item.price + '</td><td>' + tt + '</td><td><a onclick="update_sc_field" fieldid="' + item.id + '" href="#">Cập nhật</a></td></tr>';
                });
                table.append(html);
                $('.listPitch').dataTable();
            }
        },
        error: function (error) {
            alert('Lỗi ko get đc sân');
        }
    });
})();