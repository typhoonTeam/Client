    $(function () { 
    	let nameReg=/^[a-zA-Z][a-zA-Z0-9_]{3,15}$/;
        let pswReg=/^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)\S{6,}$/;
        let errors=new Map();
        function validate(message) {
            errors.clear();
            if(!nameReg.test(message.name)){errors.set('name','请输入3到15位数字或字母');}
            if(!pswReg.test(message.psw)){errors.set('psw','数字/大写/小写字母,至少两种组成，长度不小于6');}
        }
        function renderError(errors) {
            let nameSpan=$("#error");
            nameSpan.textContent=errors.get('name');
            let pswSpan= $("#error");
            pswSpan.textContent=errors.get('psw');
        }
        $("#loginForm").on("submit",function (e) {
            e.preventDefault();
            let opt =new Object();
            opt.type="POST";
            opt.url="/typhoon_consuemer/login";
            opt.success=function(result){
                if(result!=0){
                	window.location.href="/typhoon_consuemer/html/merchant.html";
                	sessionStorage.setItem('user',$("#userName").val());
                }else{
                    $("#error").text("用户名或密码错误！");
                }
            }
            opt.contentType="application/json";
            opt.data=JSON.stringify({'username':$("#userName").val(),'password':$("#password").val()});
            $.ajax(opt)
        })
        $("#loginForm").on("change",function (e) {
            let name=$("#userName").val();
            let psw=$("#password").val();
            let message={name:name,psw:psw};
            validate(message);
            renderError(errors);
        })
    })
