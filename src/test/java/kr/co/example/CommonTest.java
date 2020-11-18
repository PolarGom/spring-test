package kr.co.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

/**
 * 공통 테스트
 *
 * <pre>
 *     description: @Transaction 어노테이션을 붙이면 DB 가 Rollback 됨
 * </pre>
 *
 * @author main
 * @since 2020-11-18
 */
@SpringBootTest
//@Transactional
public class CommonTest {

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                })
                .build();
    }

    protected Map<String, Object> getResponseMap(String response) throws JsonProcessingException {

        return objectMapper.readValue(response, Map.class);
    }
}
