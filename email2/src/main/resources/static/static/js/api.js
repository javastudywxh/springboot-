function askVerifyCode() {
    get('http://192.168.116.129:8080/api/auth/verify-code',{
        email:$("#email").val()
    },function (data) {
        alert(data.reason)
    })
}
function register() {
    post('http://192.168.116.129:8080/api/auth/register',{
        verify:$("#verify").val(),
        username:$("#username").val(),
        password:$("#password").val(),
        email: $("#email").val(),
    },function (data) {
        if (data.code===200){
            window.location="http://192.168.116.129:8080/login.html"
        }else {
            alert(data.reason)
        }
    })
}
function askNotNullVerifyCode() {
    get('http://192.168.116.129:8080/api/auth/verifyNotNullCode',{
        email:$("#email").val(),
        username:$("#username").val()
    },function (data) {
        alert(data.reason)
    })
}
function forgot() {
    post('http://192.168.116.129:8080/api/auth/forgot',{
        verify:$("#verify").val(),
        username:$("#username").val(),
        password:$("#password").val(),
        email: $("#email").val(),
    },function (data) {
        if (data.code===200){
            window.location="http://192.168.116.129:8080/login.html"
        }else {
            alert(data.reason)
        }
    })
}
function login() {
    post('http://192.168.116.129:8080/api/auth/login',{
        username:$("#username").val(),
        password:$("#password").val()
    },function (data) {
        if (data.code===200){
            window.location="http://192.168.116.129:8080/index.html"
        }else {
            alert(data.reason)
        }
        })
}
function initUserInfo() {
    get('http://192.168.116.129:8080/api/user/info',{},function (data) {
        if (data.code===200){
            $("#profile-name").text(data.data.username)
        }else {
            alert(data.reason)
            window.location="http://192.168.116.129:8080/login.html"
        }
    })
}
function logout() {
    get('http://192.168.116.129:8080/api/auth/logout',{},function (data) {
        if (data.code===200){
            window.location="http://192.168.116.129:8080/login.html"
        }
    })
}
function get(url, data,success){
    $.ajax({
        type: "get",
        url: url,
        data:data,
        async: true,
        dataType: 'json',
        xhrFields: {
            withCredentials: true
        },
        success: success
    });
}

function post(url, data, success){
    $.ajax({
        type: "post",
        url: url,
        async: true,
        data: data,
        dataType: 'json',
        xhrFields: {
            withCredentials: true
        },
        success: success
    });
}