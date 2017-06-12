package cn.fiona.pet.facade;

import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.dto.SignInDTO;
import cn.fiona.pet.dto.SignUpDTO;
import cn.fiona.pet.entity.User;
import cn.fiona.pet.security.PermissionEnum;
import cn.fiona.pet.security.credentials.PasswordHelper;
import cn.fiona.pet.service.AccountService;
import cn.fiona.pet.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
@Service(protocol = "rest")
@Path("accounts")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Setter
public class AccountRestServiceImpl implements AccountRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountRestServiceImpl.class);

    @Autowired
    private AccountService accountService;

    @POST
    @Path("sign-up")
    @Override
    public RestResult signUp(SignUpDTO signUp) {
        return null;
    }

    @POST
    @Path("sign-in")
    @ApiOperation(value = "登录",
            notes = "用户登录"
    )
    @Override
    public RestResult signIn(SignInDTO signIn) {
        return null;
    }
}
