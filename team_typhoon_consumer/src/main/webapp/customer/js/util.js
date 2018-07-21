(function (global) {
    let harper={};

    //ajax异步请求
    harper.ajax=function (method,url,data,headers,callback) {
        let request = new XMLHttpRequest();
        request.open(method,url);
        headers.forEach((header)=>{
            request.setRequestHeader(header.key,header.value);
        })
        request.send(JSON.stringify(data));
        request.onreadystatechange=function(){
            if(request.readyState==4){
                if(request.status==200||request.status==201||request.status==304){
                    callback(request.responseText);
                }
            }
        }
    }

    //某用户添加某店铺的菜品到购物车
    harper.updateUserCart=function (userId,shopId,foods) {
        let id=userId+shopId;
        localStorage.setItem(id,JSON.stringify(foods));
    }

    //查询某用户在某店铺里的购物车
    harper.queryUserCart =function (userId,shopId) {
        let id=userId+shopId;
        return JSON.parse(localStorage.getItem(id));
    }

    //清空某用户在某店铺的购物车
    harper.clearUserCart =function (userId,shopId) {
        let id=userId+shopId;
        localStorage.setItem(id,"");
    }

    //游客添加某店铺的菜品到购物车
    harper.updateCart =function (shopId,foods) {
        sessionStorage.setItem(shopId,JSON.stringify(foods));
    }

    //查询游客在某店铺里的购物车
    harper.queryCart =function (shopId) {
        return JSON.parse(sessionStorage.getItem(shopId));
    }

    global.$=harper;
})(window);