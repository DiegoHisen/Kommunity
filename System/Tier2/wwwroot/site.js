
// Event handler for login btn
$('#login').on('click', function () {

    // Create a user object out of given cpr and pwd
    var user = {
        cpr: $('#user').val(),
        password: $('#pass').val(),
    };

    // Call the Web API with ajax 
    $.ajax({
        type: "POST",
        accepts: "application/json",
        url: "kommunity/login",
        contentType: "application/json",
        data: JSON.stringify(user),

        success: function (result) {
            // ToDo, replace code here with redirecting the user to the home page
            alert("Welcome " + result.name);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Something went wrong!");
        }
    });

});