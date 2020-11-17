package kr.co.example.common;

/**
 * 커스텀 Exception 클래스
 *
 * @author main
 * @since 2020-11-17
 */
public class CommonException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String errMsg = "";

    public CommonException() {
        super();
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(Throwable cause, String errMsg) {
        super(errMsg, cause);

        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}