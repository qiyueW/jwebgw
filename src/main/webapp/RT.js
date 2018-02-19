function showStatusCodeMessage(code, sucess,error) {
    switch (code) {
        case 0:
            return "登陆超时，请重新登陆!";
        case 1:
            sucess("添加成功!");
            return;
        case 11:
            return "添加出错!请通知管理员维护系统，或稍后再试";
        case 2:
            sucess();
            return "删除成功!";
        case 22:
            return "删除出错!请通知管理员维护系统，或稍后再试";
        case 3:
            sucess();
            return "修改成功!";
        case 33:
            return "修改出错!请通知管理员维护系统，或稍后再试";
        case 4:
            sucess();
            return "校验成功!";
        case 44:
            return "校验未通过!操作失败!";
    }
}