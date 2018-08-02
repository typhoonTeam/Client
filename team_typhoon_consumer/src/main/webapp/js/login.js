$(function () {
    $("#loginForm").on("submit",function (e) {
        e.preventDefault();
        let opt =new Object();
        opt.type="POST";
        opt.url="/typhoon_consuemer/login";
        opt.success=function(result){
            if(result!=0){
            	//判断游客里面是否有购物车，有购物车则sessionStorage倒入localStorage
                sessionStorage.setItem('user',$("#userName").val());
                let userId = $("#userName").val();
                let shopId = sessionStorage.getItem("shopId");   
                let foodCarts=$1.queryCart(shopId);
                $1.updateUserCart(userId,shopId,foodCarts);
                window.location.href="/typhoon_consuemer/html/merchant.html";
            }else{
                $("#error").text("用户名或密码错误！");
            }
        }
        opt.contentType="application/json";
        opt.data=JSON.stringify({'username':$("#userName").val(),'password':$("#password").val()});
        $.ajax(opt)
    })
})
