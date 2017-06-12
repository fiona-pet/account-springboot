package cn.fiona.pet.facade;

import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.dto.SignInDTO;
import cn.fiona.pet.entity.User;
import cn.fiona.pet.service.AccountService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 身份认证
 * <p>
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
@Path("/auth")
@Api(value="auth", description = "身份授权")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service(protocol = "rest")
@Setter
public class AuthRestServiceImpl implements AuthRestService {
    private static final Logger logger = LoggerFactory.getLogger(AuthRestServiceImpl.class);

    @Autowired
    private AccountService accountService;

    @POST
    @Path("login")
    @ApiOperation(value = "登录", notes = "用户登录,登录成功返回token信息",response = RestResult.class)
    @Override
    public RestResult<String> login(@ApiParam(value = "登录信息", required = true) SignInDTO signInDTO) {
        RestResult<String> restResult = RestResult.NOT_FOND();

        try {
            String token = accountService.login(signInDTO);

            restResult = RestResult.OK(token);
        } catch (RuntimeException apiE) {
            restResult = RestResult.REST_RESULT(apiE);
        } catch (Exception e) {
            logger.warn("{}", e);
            restResult = RestResult.ERROR(e.getMessage());
        }

        return restResult;
    }

    @GET
    @Path("")
    @ApiOperation(value = "登录用户信息",
            notes = "登录用户信息"
    )
    @Override
    public RestResult<User> get(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token) {
        RestResult<User> restResult = RestResult.NOT_FOND();

        User user = null;
        try {
            user = accountService.getByToken(token);
            restResult = RestResult.OK(user);
        } catch (RuntimeException e) {
            logger.warn("{}", e);
            restResult = RestResult.ERROR(e.getMessage());
        }
        return restResult;
    }

    @GET
    @Path("/users/byRole/{code}")
    @ApiOperation(value = "根据角色编号获取用户列表",
            notes = "根据角色编号获取用户列表"
    )
    @Override
    public RestResult<List<User>> usersByRoleCode(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("角色编号") String code) {
        return RestResult.OK(accountService.listByRoleCode(code));
    }
}
