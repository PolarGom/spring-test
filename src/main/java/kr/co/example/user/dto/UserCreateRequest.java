package kr.co.example.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 사용자 생성 요청
 *
 * @author main
 * @since 2020-11-17
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserCreateRequest {

    @NotBlank(message = "아이디를 입력해 주세요.")
    @Size(min = 1, max = 50, message = "아이디는 1~50자리 입니다.")
    private String id;

    @NotBlank(message = "이름을 입력해 주세요.")
    @Size(min = 1, max = 50, message = "이름은 1~50자리 입니다.")
    private String name;
}
