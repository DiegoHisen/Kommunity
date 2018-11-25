
// Event handler for login btn
$('#login').on('click', function () {

    // Create a user object out of given cpr and pwd
    var user = {
        cpr: $('#user').val(),
        password: $('#pass').val(),
    };

    // Call the Web API with ajax 
    $.ajax({
        type: "GET",                      // Changed from POST to GET, Not working currently.
        accepts: "application/json",
        url: "kommunity/home",
        contentType: "application/json",
        data: JSON.stringify(user),
        cache: false,
        success: function (result) {
            // ToDo, replace code here with redirecting the user to the home page
            alert("Welcome " + result.name);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Something went wrong!");
        }
    });

});

// Implement event handler for signup button