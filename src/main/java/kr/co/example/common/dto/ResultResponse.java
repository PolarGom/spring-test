package kr.co.example.common.dto;

import lombok.*;

/**
 * 결과 응답
 *
 * @author main
 * @since 2020-11-17
 */
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResultResponse<T extends IResultBodyResponse> {

    @NonNull
    @Builder.Default
    private boolean success = true;

    @NonNull
    @Builder.Default
    private String errMsg = "";

    private T body;
}
