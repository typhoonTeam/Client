(function (global) {
    let cartService={};

    //update cart
    cartService.updateCart = function updateCart(foodTemp) {
        if (!userId) {
            if (!foodsInCart) {
                foodsInCart = [];
                foodTemp.num = 1;
                foodsInCart.push(foodTemp);
                $1.updateCart(param, foodsInCart);
            } else {
                let flag = -1;
                for (let z = 0; z < foodsInCart.length; z++) {
                    if (foodsInCart[z].id == foodTemp.id) {
                        flag = z;
                        break;
                    }
                }
                if (flag != -1) {
                    foodsInCart[flag].num++;
                    $1.updateCart(param, foodsInCart);
                } else {
                    foodTemp.num = 1;
                    foodsInCart.push(foodTemp);
                    $1.updateCart(param, foodsInCart);
                }
            }

        } else {
            if (!foodsInCart) {
                foodsInCart = [];
                foodTemp.num = 1;
                foodsInCart.push(foodTemp);
                $1.updateUserCart(userId, param, foodsInCart);
            } else {
                let flag = -1;
                for (let z = 0; z < foodsInCart.length; z++) {
                    if (foodsInCart[z].id == foodTemp.id) {
                        flag = z;
                        break;
                    }
                }
                if (flag != -1) {
                    foodsInCart[flag].num++;
                    $1.updateUserCart(userId, param, foodsInCart);
                } else {
                    foodTemp.num = 1;
                    foodsInCart.push(foodTemp);
                    $1.updateUserCart(userId, param, foodsInCart);
                }
            }
        }
    }

    global.$cartservice=cartService;
})(window);