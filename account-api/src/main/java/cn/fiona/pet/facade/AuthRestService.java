package cn.fiona.pet.facade;

import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.dto.SignInDTO;
import cn.fiona.pet.entity.User;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 身份授权 服务 rest api
 *
 * @author baiqw
 */
public interface AuthRestService {
    public static final String HEADER_AUTHORIZATION_KEY = "authorization";
    /**
     * 登录
     *
     * @param signInDTO 登录信息
     * @return RestResult 身份认证成功 data 返回用户token
     */
    RestResult<String> login(@ApiParam(value = "登录信息", required = true) SignInDTO signInDTO);


    RestResult<User> get(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token);


    RestResult<List<User>> usersByRoleCode(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("角色编号") @PathParam("code") String code);
}
