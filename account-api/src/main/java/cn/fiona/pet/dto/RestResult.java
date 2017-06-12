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
    private RestResultEnum resultEnum = RestResultEnum.OK;

    public RestResult() {

    }

    public RestResult(RestResultEnum resultEnum) {
        this.resultEnum = resultEnum;
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
        restResult.setData(data);
        return restResult;
    }

    @ApiModelProperty("数据信息")
    private T data;

    public int getCode() {
        return resultEnum.getCode();
    }

    public String getMessage() {
        return resultEnum.getDesc();
    }

    public void setCode(int code) {
        this.resultEnum.setCode(code);
    }

    public void setMessage(String message) {
        this.resultEnum.setDesc(message);
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
