function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    $.ajax({
        type: "POST",
        contentType: 'application/json',
        url: "/comment",
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 2002
        }),
        success: function (response) {
            if (response.code == 200) {
                $("#comment_section").hide();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=39b225767a8f2f1e4362&redirect_uri=http://localhost:8888/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
            console.log(response);
        },
        dataType: "json"
    });
}