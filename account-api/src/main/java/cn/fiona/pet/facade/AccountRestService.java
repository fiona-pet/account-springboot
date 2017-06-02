package cn.fiona.pet.facade;

import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.dto.SignInDTO;
import cn.fiona.pet.dto.SignUpDTO;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 账号
 *
 * @author tom
 */
public interface AccountRestService {
    /**
     /**
     * 注册
     * @param signUp
     * @return
     */
    @POST
    @Path("sign-up")
    @ApiOperation(value = "注册",
            notes = "用户注册"
    )
    RestResult signUp(SignUpDTO signUp);

    /**
     * 登录
     * @param signIn
     * @return
     */
    @POST
    @Path("sign-in")
    @ApiOperation(value = "登录",
            notes = "用户登录"
    )
    RestResult signIn(SignInDTO signIn);

}
