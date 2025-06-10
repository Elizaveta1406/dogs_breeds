
package ru.omgtu.ivt.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends BaseIntegrationTest {

    @Test
    void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/users")
                .header("Authorization", accessToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testRegisterUser() throws Exception {
        String userJson = """
{
  "username": "ivanova",
  "password": "x2N3ZuKoEGHw6SZu"
}
                """;

        mockMvc.perform(post("/api/auth/register")
                        .header("Authorization", accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/4")
                        .header("Authorization", accessToken))
                .andExpect(status().isNoContent());
    }
}
