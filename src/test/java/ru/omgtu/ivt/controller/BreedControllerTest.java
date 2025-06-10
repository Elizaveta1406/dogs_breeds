
package ru.omgtu.ivt.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BreedControllerTest extends BaseIntegrationTest {

    @Test
    void testGetAllBreeds() throws Exception {
        mockMvc.perform(get("/api/breeds")
                .header("Authorization", accessToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateBreed() throws Exception {
        String breedJson = """
                           {
                             "name": "Тестовая порода, которой нет в базе",
                             "originCountry": "США",
                             "description": "Сильная и умная порода с короткой шерстью",
                             "avgLifespan": 13,
                             "size": "MEDIUM",
                             "temperament": "Энергичный, умный, уверенный",
                             "imageUrl": "https://example.com/images/pitbull.jpg"
                           }
                """;

        mockMvc.perform(post("/api/breeds")
                        .header("Authorization", accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(breedJson))
                .andExpect(status().isOk());
    }


    @Test
    void testDeleteBreed() throws Exception {
        mockMvc.perform(delete("/api/breeds/1")
                        .header("Authorization", accessToken))
                .andExpect(status().isNoContent());
    }
}
