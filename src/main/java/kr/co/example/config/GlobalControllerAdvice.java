package kr.co.example.config;

import kr.co.example.common.CommonException;
import kr.co.example.common.dto.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 전역 에러 처리 컨트롤러
 *
 * @author main
 * @see 2020-11-17
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    /**
     * CommonException 으로 에러난 정보를 리턴하는 메소드
     *
     * @param ex CommonException 정보
     * @return result 오류난 정보 반환
     */
    @ExceptionHandler({CommonException.class})
    public ResponseEntity<ResultResponse> edaExceptionHandler(CommonException ex) {

        log.error(ex.getErrMsg(), ex);

        return new ResponseEntity<>(ResultResponse.builder().success(false).errMsg(ex.getErrMsg()).build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception으로  에러난 정보를 리턴하는 메소드
     *
     * @param ex Exception 정보
     * @return result 오류난 정보 반환
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResultResponse> exceptionHandler(Exception ex) {

        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(ResultResponse.builder().success(false).errMsg(String.format("오류가 발생하였습니다.[%s]", ex.getMessage())).build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * requestBody 혹은 requestPart 에 대한 valid 오류 처리 메소드
     *
     * @param ex 익셉션
     * @return result 오류난 정보 반환
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ResultResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {

        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(ResultResponse.builder()
                .success(false)
                .errMsg(ex.getBindingResult().getAllErrors().stream().findFirst().get().getDefaultMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * ModelAttribute 으로 binding 오류 처리 메소드
     *
     * @param ex 익셉션
     * @return result 오류난 정보 반환
     */
    @ExceptionHandler({BindException.class})
    public ResponseEntity<ResultResponse> bindExceptionHandler(BindException ex) {

        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(ResultResponse.builder()
                .success(false)
                .errMsg(ex.getAllErrors().stream().findFirst().get().getDefaultMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}
