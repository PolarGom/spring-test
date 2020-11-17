package kr.co.example.user.service;

import kr.co.example.common.CommonException;
import kr.co.example.common.dto.IResultBodyResponse;
import kr.co.example.user.dto.UserCreateRequest;
import kr.co.example.user.entity.User;
import kr.co.example.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 사용자 서비스
 *
 * @author main
 * @see 2020-11-17
 * @see {@link IUserService}
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepositoryImpl;

    @Override
    public void createUser(UserCreateRequest request) throws CommonException {

        try {

            log.info("생성 할 사용자 정보: {}", request.toString());

            userRepositoryImpl.save(User.builder()
                    .id(request.getId())
                    .name(request.getName())
                    .build());
        } catch ( Exception e ) {

            throw new CommonException(e, "사용자 생성 중 오류가 발생하였습니다.");
        }
    }

    @Override
    public void deleteUser(String id) throws CommonException {

        log.info("삭제 할 사용자 아이디: {}", id);

        User user = userRepositoryImpl.findById(id).orElseThrow(() -> {
           String errMsg = "아이디가 존재하지 않습니다.";

           return new CommonException(new NullPointerException(errMsg), errMsg);
        });

        userRepositoryImpl.delete(user);
    }

    @Override
    public IResultBodyResponse findAllUser() throws CommonException {

        try {

        } catch ( Exception e ) {

            throw new CommonException(e, "사용자 목록 조회 중 오류가 발생하였습니다.");
        }
    }
}
