package wx.web;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;

/**
 *
 * @author wangchunzi
 */
@H("/login")
public class UserLogin {

    @M("/user")//
    @Validate(UserLoginValidate.class)
    public static void selectOne(JWeb jw) {
        //直接取参数
        String account = jw.getString("account");
        String passord = jw.getString("passord");
        System.out.println("我是直接取参:" + account + "//" + passord);

//        //对象式取参
//        UserVO vo = jw.getObject(UserVO.class);
//        System.out.println("我是对象式取参:" + vo.account + "//" + vo.passord);

        jw.forward("/admin/index.jsp");
    }
}
