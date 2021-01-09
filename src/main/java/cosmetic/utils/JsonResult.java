package cosmetic.utils;

public class JsonResult <T>{
    private Integer code; //0:success | 1: fail
    private String msg; //message
    private T data; //return object

    public JsonResult(){ }

    public JsonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public JsonResult<T> fail(){return  new JsonResult<>(1,"Lỗi hệ thống",null);}
    public JsonResult<T> fail(String msg){return  new JsonResult<>(1,msg,null);}
    public JsonResult<T> ok(){return new JsonResult<>(0,"Thành công",null);}
    public JsonResult<T>ok(T data){return new JsonResult<>(0,"Thành công",null);}
    public JsonResult<T> ok(String msg,T data){return  new JsonResult<>(0,msg,data);}
}
