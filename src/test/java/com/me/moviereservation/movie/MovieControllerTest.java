package com.me.moviereservation.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.me.moviereservation.movie.model.CreateMovieRequest;
import com.me.moviereservation.movie.model.GetMoviesDetailsResponse;
import com.me.moviereservation.roomnumber.RoomNumber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    private static final String MOVIE_NAME = "Rambo";
    private static final RoomNumber ROOM_NUMBER = RoomNumber.R1;
    private static final LocalDateTime START_DATE = LocalDateTime.of(2019, 10, 10, 10, 10, 10);
    private static final LocalDateTime END_DATE = LocalDateTime.of(2019, 10, 10, 12, 10, 10);

    @Before
    public void beforeEachTestMethod() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    public void shouldReturnStatusIsCreatedWhenMovieIsAdded() throws Exception {
        CreateMovieRequest request = new CreateMovieRequest(MOVIE_NAME, ROOM_NUMBER,
                START_DATE,
                END_DATE);

        mockMvc.perform(post("/movies")
                .contentType(APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnStatusIsOkWhenMoviesDetailsIsReturned() throws Exception {
        CreateMovieRequest request = new CreateMovieRequest(MOVIE_NAME, ROOM_NUMBER,
                START_DATE,
                END_DATE);

        mockMvc.perform(post("/movies")
                .contentType(APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/movies")
                .param("startDate", START_DATE.toString())
                .param("endDate", END_DATE.toString()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].uuid").exists())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].startDate").exists())
                .andExpect(jsonPath("$[0].endDate").exists())
                .andExpect(jsonPath("$[0].durationMinutes").exists());
    }

    @Test
    public void shouldReturnStatusIsOkWhenMovieRoomDetailsIsReturned() throws Exception {
        CreateMovieRequest request = new CreateMovieRequest(MOVIE_NAME, ROOM_NUMBER,
                START_DATE,
                END_DATE);

        mockMvc.perform(post("/movies")
                .contentType(APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(request)));

        String jsonString = mockMvc.perform(get("/movies")
                .param("startDate", START_DATE.toString())
                .param("endDate", END_DATE.toString()))
                .andReturn().getResponse().getContentAsString();

        GetMoviesDetailsResponse[] asArray = mapper.readValue(jsonString, GetMoviesDetailsResponse[].class);

        mockMvc.perform(get("/movies/" + asArray[asArray.length - 1].getUuid()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roomNumber").exists())
                .andExpect(jsonPath("$.places").exists());
    }
}
