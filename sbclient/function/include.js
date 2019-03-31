
/* hàm include file html dạng index.html?path=file-html */
////function loadData() {
//    var path = window.location.search;
//    var file = path.split('=');
//    if (typeof file[1] != 'undefined') {
//        $('#body-data').load(file[1] + '.html');
//    } else {
//        $('#body-data').load('dashboard.html');
//    }
//}

/*  hàm gán link cho thẻ a , include k dùng <a href="link"></a> phải dùng <a onclick="path('đường dẫn file')"></a>*/
function path(str) {
    window.location.href = 'index.html#' + str;
}

/* hàm include file html dạng index.html#file-html */
function loadData() {
    var path = window.location.hash;
    var file = path.split('#');
    if (typeof file[1] != 'undefined') {
        $('#body-data').load(file[1] + '.html');
    } else {
        $('#body-data').load('dashboard.html');
    }
}