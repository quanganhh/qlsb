function loadHTML() {
    var path = window.location.search;
    var file = path.split('=');
    if (typeof file[1] != 'undefined') {
        var view = file[1].replace('-', '/');
        $('#body-data').load(view + '.html');
    } else {
        $('#body-data').load('dashboard.html');
    }
}

function path(str){
    window.location.href = 'index.html?view='+str;
}