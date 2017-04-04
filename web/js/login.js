function logout() {

    var url = "api/invalidate_login_servlet";

    $.post(url, null, function (dataFromServer) {
         console.log("Finished calling logout servlet.");
         console.log(dataFromServer);
         getLoginJava();
    });
}

function getLogin() {
	var url = "api/get_login_servlet";

    $.post(url, null, function (dataFromServer) {
        console.log("Finished calling servlet.");
        console.log(dataFromServer);
        dataFromServer = dataFromServer.trim();
        if (dataFromServer === "null") {
            $("#logoutdiv").hide();
            $('#getSessionResult').html(dataFromServer);
        }
        else {
            $("#logoutdiv").show();
            $('#getSessionResult').html("You are logged in as '" + dataFromServer + "'");
        }


    });
}

function Login() {

    var url = "api/login_servlet";


    var loginID = $("#loginID").val();

    var dataToServer = {loginID : loginID};

    $.post(url, dataToServer, function (dataFromServer) {
        console.log("Finished Logging In.");
        console.log(dataFromServer);
        $("#loginID").val("");
        getLogin();

    });

}
button = $('#getLogin');
button.on("click", getLogin);

button = $('#login');
button.on("click", Login);


button = $('#log_Out');
button.on("click", logout);

getLogin()