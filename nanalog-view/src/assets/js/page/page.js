const serverUrl = 'http:\/\/localhost:8080\/';

(function() {

    var pageService = function() {
        this.init();
    };

    var selectedMonth;
    var currentPreview;

    pageService.prototype = {
        init: function() {
            console.log('==============>>> diary service Init ...');
            this.myPageBtnEventHandler();
        },
        myPageBtnEventHandler: function() {
            $('#logo').click(function(e) {

              $('#main-body').html($('#myPage-div').html())
              myPageInit();
            });
        },
        run: function() {}
    };

    var myPageInit = function() {
        $('#mypage-save-btn').click(function(e) {
            let nick = document.getElementById("input-nickname").value;
            let emailId = document.getElementById("input-email").value;
            let emailAddress = document.getElementById("re-input-email").value;
            let password = document.getElementById('input-pw').value;
            let repassword = document.getElementById('re-input-pw').value;

            if(password != repassword){
              window.alert("비밀번호가 일치하지 않습니다.");
              return;
            }

            let userId = emailId + "@" + emailAddress;

            $.ajax({
                url: serverUrl+'v1/user',
                type: 'PUT',
                data: "uid="+userId+"name="+nick+"password"+password,
                success: function(result) {
                    alert(result);
                    // Do something with the result
                }
            });

        });
    };

    var componentInit = function() {
        pageService = new pageService();
    };

    if (!window.componentInit) {
        window.componentInit = componentInit();
    };
})();

export default 'page';
