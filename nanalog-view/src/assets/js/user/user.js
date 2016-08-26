console.log("user");

const serverUrl = 'http://localhost:8080/';

(function() {

    var userService = function() {
        this.init();
    };



    userService.prototype = {
        init: function() {
            console.log('==============>>> user service Init ...');
            this.loginButtonClickEventHandler();
            this.mypageSaveButtonClickEventHandler();
            ab();
            passwordSearchButtonClickEventHandler();
        },

        loginButtonClickEventHandler: function() {
          alert("Check");
            $('#form-btn').click(function(e) {
                let uid = document.getElementById("login-form-id").value;
                let password = document.getElementById("login-form-password").value;

                console.log('login-form-id : ' + uid + ' login-form-password : ' + password );
            });
        },
        mypageSaveButtonClickEventHandler: function() {
            $('#mypage-Save-btn').click(function(e) {
                let nick = document.getElementById("input-nickname").value;
                let emailId = document.getElementById("email-id").value;
                let emailAddress = document.getElementById("email-address").value;
                let password = document.getElementById('input-pw').value;
                let repassword = document.getElementById('re-input-pw').value;

                console.log($("input[name=radioSelectThema]:checked").value());

                if(password != repassword){
                  window.alert("비밀번호가 일치하지 않습니다.");
                }
                else {
                  console.log('mypage-nick : ' + nick + 'mypage-email-id : ' + emailId + 'mypage-email-address : ' + emailAddress + 'mypage-password : ' + password + 'mypage-repassword : ' + repassword);
                }
            });
        },
        run: function() {}
      };

      function ab(){
        $('#main-template').html(memberLoginTemplate());

        $('#password-search').click(function(e){
          $('#main-template').html(passwordSearchTemplate());
          $('#form-btn').html('찾기');
        });

        $('#member-join').click(function(e){
          $('#main-template').html(memberJoinTemplate());
          $('#form-btn').html('인증');
          joinButtonClickEventHandler();
        });

        $('#login-form-logo').click(function(e){
          $('#main-template').html(memberLoginTemplate());
          $('#form-btn').html('로그인');
        });
      }

      function joinButtonClickEventHandler(){
        $('#form-btn').click(function(e) {
          alert("CHECK");
          let uid = document.getElementById("login-form-id").value;
          let password = document.getElementById("login-form-password").value;
          let nick = document.getElementById('login-form-nick').value;

          $.post(serverUrl + '/v1/user',
          {
              uid : uid,
              name : nick,
              password : password
          },
          function(data) {
            alert(data);
          });
        });
      }

      function passwordSearchButtonClickEventHandler(){
        $('#form-btn').click(function(e) {
          let email = document.getElementById('login-form-email').value;

          console.log('login-form-id : ' + email);
        });
      }


      var componentInit = function() {
          userService = new userService();
      };

      if (!window.componentInit) {
          window.componentInit = componentInit();
      };



    })();





export default 'user';
