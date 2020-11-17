package kr.co.example.user.service;

import kr.co.example.common.CommonException;
import kr.co.example.common.dto.IResultBodyResponse;
import kr.co.example.user.dto.UserCreateRequest;

/**
 * 사용자 서비스 인터페이스
 *
 * @author main
 * @since 2020-11-17
 */
public interface IUserService {

    /**
     * 사용자 추가
     *
     * @return result 사용자 조회 결과
     * @throws CommonException
     */
    void createUser(UserCreateRequest request) throws CommonException;

    /**
     * 사용자 삭제
     *
     * @param id 사용자 아이디
     * @throws CommonException
     */
    void deleteUser(String id) throws CommonException;

    /**
     * 모든 사용자 가져오기
     *
     * @return result 사용자 목록 정보
     * @throws CommonException
     */
    IResultBodyResponse findAllUser() throws CommonException;
}
