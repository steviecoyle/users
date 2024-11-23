package integration;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import utils.IntegrationTestUtils;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UsersTest extends IntegrationTestUtils {

    @Test
    void user_example() throws Exception {
        final MvcResult response = this.mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(response);
    }
}
