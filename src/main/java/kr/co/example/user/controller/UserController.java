package kr.co.example.user.controller;

import kr.co.example.common.dto.ResultResponse;
import kr.co.example.user.dto.UserCreateRequest;
import kr.co.example.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 사용자 컨트롤러
 *
 * @author main
 * @since 2020-11-17
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserService userServiceImpl;

    /**
     * 사용자 추가
     *
     * @param request 추가 할 사용자 정보
     * @return result 응답 결과
     */
    @PostMapping
    public ResponseEntity<ResultResponse> createUser(@RequestBody @Valid UserCreateRequest request) {

        userServiceImpl.createUser(request);

        return ResponseEntity.ok(ResultResponse.builder().build());
    }

    /**
     * 사용자 삭제
     *
     * @param userId 삭제 할 사용자 아이디
     * @return result 응답 결과
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<ResultResponse> deleteUser(@PathVariable String userId) {

        userServiceImpl.deleteUser(userId);

        return ResponseEntity.ok(ResultResponse.builder().build());
    }

    /**
     * 모든 사용자 가져오기
     *
     * @return result 응답 결과
     */
    @GetMapping
    public ResponseEntity<ResultResponse> findAllUser() {

        return ResponseEntity.ok(ResultResponse.builder().body(userServiceImpl.findAllUser()).build());
    }
}
