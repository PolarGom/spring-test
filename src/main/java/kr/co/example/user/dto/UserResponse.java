package kr.co.example.user.dto;

import kr.co.example.user.entity.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자 응답
 *
 * @author main
 * @since 2020-11-18
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserResponse {

    @NonNull
    private String id;
    
    @NonNull
    private String name;

    public static UserResponse from(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    public static List<UserResponse> listFrom(List<User> userList) {

        return userList.stream()
                .map(UserResponse::from)
                .collect(Collectors.toList());
    }
}
