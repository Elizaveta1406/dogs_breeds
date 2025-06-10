package ru.omgtu.ivt.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import ru.omgtu.ivt.model.Gender;
import ru.omgtu.ivt.model.dto.DogDTO;
import ru.omgtu.ivt.model.entity.Dog;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DogControllerTest extends BaseIntegrationTest {

    @Test
    void testGetAllDogs() throws Exception {
        mockMvc.perform(get("/api/dogs")
                .header("Authorization", accessToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateDog() throws Exception {
        String dogJson = """
                          {
                            "name": "Лаки",
                            "birthDate": "2018-03-12",
                            "color": "Серый",
                            "weight": 57.8,
                            "gender": "MALE",
                            "breedId": 3,
                            "ownerId": 2
                          }
                """;

        mockMvc.perform(post("/api/dogs")
                .header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .content(dogJson))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteDog() throws Exception {
        mockMvc.perform(delete("/api/dogs/1")
                .header("Authorization", accessToken))
                .andExpect(status().isNoContent());
    }
}
