package cn.fiona.pet.service;

import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.dto.SignInDTO;
import cn.fiona.pet.entity.User;
import cn.fiona.pet.facade.AuthRestService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.HeaderParam;
import java.util.List;

/**
 * 身份认证
 * <p>
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
public class AuthRestServiceImpl implements AuthRestService {

    private static final Logger logger = LoggerFactory.getLogger(AuthRestServiceImpl.class);

    @Autowired
    private AccountService accountService;

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

    @Override
    public RestResult<List<User>> usersByRoleCode(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("角色编号") String code) {
        return RestResult.OK(accountService.listByRoleCode(code));
    }
}
