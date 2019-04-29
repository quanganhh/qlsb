function draw_datepicker(){
	console.log("hello");
    $.fn.datepicker.dates['vi'] = {
    days: ["Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy", "Chủ Nhật"],
    daysShort: ["CN", "T2", "T3", "T4", "T5", "T6", "T7", "CN"],
    daysMin: ["CN", "T2", "T3", "T4", "T5", "T6", "T7", "CN"],
    months: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
    monthsShort: ["Thg 1", "Thg 2", "Thg 3", "Thg 4", "Thg 5", "Thg 6", "Thg 7", "Thg 8", "Thg 9", "Thg 10", "Thg 11", "Thg 12"],
    today: "Hôm Nay"
    };

	var seff = $(".dat-lich-content").datepicker({
    isRTL: false,
    format: 'yyyy-mm-dd',
    autoclose:true,
    language: 'vi'
	});

    // seff.on('changeDate',function(e){
    //     console.log(e);
    // })
}

// get list sân & trả html về select

function get_list_all_scfield(){
    var seff =  $('.selectpicker');
    $.ajax({
        dataType: "json",
        type: "get",
        url: "http://localhost:9999/api/scfield",
        headers: {
            "Authorization": "Bearer "+localStorage.getItem('myToken')
        },
        success: function (result) {
            if(typeof(result.dataList) != 'undefined'){
                var html = '';
                $.each(result.dataList, function(i, item){
                
                    html += '<option value="'+item.id+'">'+item.name+'</option>';
                });
                seff.append(html);
            }
        },
        error: function (error) {
            alert('Lỗi ko get đc sân');
        }
    });
}


function get_scfield_by_id(id_scfield){
    var ajax_url = "http://localhost:9999/api/scfield/"+id_scfield;
    $.ajax({
        dataType: "json",
        type: "get",
        url: ajax_url,
        headers: {
            "Authorization": "Bearer "+localStorage.getItem('myToken')
        },
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            alert('Lỗi ko get đc sân');
        }
    });
}

function get_all_sf_time_duration(){
    var table = $('.list-time-duration tbody');

    $.ajax({
        dataType: "json",
        type: "get",
        url: "http://localhost:9999/api/timedur",
        headers: {
            "Authorization": "Bearer "+localStorage.getItem('myToken')
        },
        success: function (result) {
            var html = '';
             if(typeof(result.dataList) != 'undefined'){
                table.empty();
                $.each(result.dataList, function(i, item){
                html += '<tr><td id="' + item.id + '"><input type="checkbox" disabled value=""></td> <td>' + item.id + '</td> <td>' + item.name + '</td> <td>' + item.price + '</td> <td>' + item.description + '</td> </tr>';
                });
                table.append(html);
                $('.list-time-duration').dataTable();
             }
        },
        error: function (error) {
            alert('Lỗi ko get đc Khung giờ');
        }
    });
}

// check khung giờ hết/ còn dựa theo ngày đặt

function check_time_duration(lst_time_duration){
    $('#btn_xem_khung_gio').on('click',function(event){
        event.preventDefault();
        var id_scfield = $( ".selectpicker" ).val();
        var date_dat_lich = $('#date_dat_lich').val();
        var table = $('.list-time-duration tbody');
        var data = JSON.stringify({
        "sf_id": id_scfield,
        "bookingdate": date_dat_lich,
        });
        $.ajax({
        contentType: "application/json",
        dataType: "json",
        type: "post",
        url: "http://localhost:9999/api/bookingdetail/",
        data: data,
        headers: {
            "Authorization": "Bearer "+localStorage.getItem('myToken')
        },
        success: function (result) {
            table.find('tr td input[type="checkbox"]').attr("disabled",false);
            /* remove attribute disabled to checkbox */
            if(typeof(result.dataList) != 'undefined' && result.dataList.length > 0){
                $.each(result.dataList, function(i, item){
                    table.find('tr td#'+ item.id +' input[type="checkbox"]').attr("disabled",true);
                });
            }
            dat_lich(table);
        },
        error: function (error) {
            alert('Lỗi ko get đc Booking Detail');
        }
    });
    });
}

function dat_lich(table){
    // event click checkbox khung gio
    var cb = table.find('input[type=checkbox]');
    console.log(cb);
    cb.on('click',function(){
        $('#btn_dat_lich').attr("disabled",false);
    })

    $('#btn_dat_lich').on('click',function(event){
        event.preventDefault();
    });
}


$(document).ready(function($) {

    get_list_all_scfield();

    get_all_sf_time_duration();

    check_time_duration();

    //vẽ datepicker booking
    draw_datepicker();
    
});

$(document).on('load',function($){

}) 