package io.scarletgraph.api.controller;

import com.github.javafaker.Faker;
import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.generator.UserGenerator;
import io.scarletgraph.api.repository.UserRepository;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    private UserGenerator userGenerator;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mvc;

    private Faker faker;

    @MockBean
    private UserCRUDService userCRUDService;

    @MockBean
    private UserRepository userRepository;

    @BeforeAll()
    public void setup() {
        this.userGenerator = new UserGenerator(this.faker);
        mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Test
    @WithMockUser
    public void whenFindByUserNameReturnSuccess() throws Exception {
    }

    @Test
    @WithMockUser
    public void whenFindByUserIdReturnSuccess() throws Exception {

    }


    @Test
    @WithMockUser
    public void whenGivenValidUserNameReturnUser() throws Exception {

    }


    @Test
    @WithMockUser
    public void saveUserAndReturnCreated() throws Exception {
        User user = userGenerator.normalUser();

        mvc.perform(MockMvcRequestBuilders.post( "/user", user)).andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void whenGivenUserIdshouldDeleteUser() {
    }

    @Test
    @WithMockUser
    public void whenGivenWrongIdReturnException() {
        User user = userGenerator.userInvalid();

    }

    @Test
    @WithMockUser
    public void whenGivenUserIdShouldUpdateUserData() {
        User user = userGenerator.normalUser();

    }

    @Test
    @WithMockUser
    public void whenGivenWrongUserIdReturnException() {
        User user = userGenerator.userInvalid();

    }

}
