package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scoyle.users.UsersApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "build/snippets", uriScheme = "https", uriHost = "api.scoyle.com", uriPort = 443)
//@TestPropertySource("classpath:application-test.properties")
@SpringBootTest(classes = {UsersApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class IntegrationTestUtils {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper mapper;
}
