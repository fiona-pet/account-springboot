package cn.fiona.pet.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO to customize the returned message
 *
 * @author lishen
 */
@Getter
@Setter
/**
 * rest result
 *
 * @author baiqw
 */
@XmlRootElement
@ApiModel("返回结果")
public class RestResult<T> implements Serializable {
    @ApiModelProperty("错误码:0 无错误信息;404 未找到资源; 500 服务器错误;")
    private int code;
    private String message;

    public RestResult() {

    }

    public RestResult(RestResultEnum resultEnum) {
        this.setErrorMessage(resultEnum.getDesc());
        this.setErrorCode(resultEnum.getCode());
        this.setCode(resultEnum.getCode());
        this.setMessage(resultEnum.getDesc());
    }

    public static <T> RestResult<T> REST_RESULT(RestResultEnum resultEnum, T data){
        RestResult restResult = new RestResult(resultEnum);
        restResult.setData(data);
        return restResult;
    }

    public static <T> RestResult<T> NOT_FOND(){
        RestResult<T> restResult = new RestResult<T>(RestResultEnum.NOT_FONT);
        return restResult;
    }

    public static <T> RestResult<T> OK(T data){
        RestResult restResult = new RestResult(RestResultEnum.OK);

        restResult.setErrorMessage(RestResultEnum.OK.getDesc());
        restResult.setErrorCode(RestResultEnum.OK.getCode());
        restResult.setCode(RestResultEnum.OK.getCode());
        restResult.setMessage(RestResultEnum.OK.getDesc());
        restResult.setData(data);
        return restResult;
    }

    @ApiModelProperty("数据信息")
    private T data;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int code) {
        this.code = code;

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> RestResult<T> ERROR(String message) {
        RestResult restResult = new RestResult(RestResultEnum.SERVER_ERROR);
        restResult.setData(message);
        return restResult;
    }

    public static RestResult<String> REST_RESULT(Exception e) {
        RestResult restResult = new RestResult(RestResultEnum.SERVER_ERROR);
        restResult.setData(e.getMessage());
        return restResult;
    }

    public void setErrorCode(int errorCode) {
        this.setCode(errorCode);
    }

    public void setErrorMessage(String errorMessage) {
        this.setMessage(errorMessage);
    }

    public int getErrorCode() {
        return this.getCode();
    }
}
