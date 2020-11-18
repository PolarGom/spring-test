package kr.co.example.common.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 결과 목록 응답
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
public class ResultListResponse implements IResultBodyResponse {

    private List<?> list = new ArrayList<>();
}
