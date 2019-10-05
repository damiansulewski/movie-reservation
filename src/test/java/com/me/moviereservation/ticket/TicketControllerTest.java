package com.me.moviereservation.ticket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.ImmutableList;
import com.me.moviereservation.movie.model.CreateMovieRequest;
import com.me.moviereservation.movie.model.GetMoviesDetailsResponse;
import com.me.moviereservation.placenumber.PlaceNumber;
import com.me.moviereservation.roomnumber.RoomNumber;
import com.me.moviereservation.ticket.model.BookPlace;
import com.me.moviereservation.ticket.model.ReserveTicketRequest;
import com.me.moviereservation.tickettype.TicketType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    private static final String MOVIE_NAME = "Rambo";
    private static final RoomNumber ROOM_NUMBER = RoomNumber.R1;
    private static final LocalDateTime START_DATE = LocalDateTime.of(2019, 10, 10, 10, 10, 10);
    private static final LocalDateTime END_DATE = LocalDateTime.of(2019, 10, 10, 12, 10, 10);
    private static final String USER_EMAIL = "email@email.pl";
    private static final String USER_NAME = "Jan";
    private static final String USER_SURNAME = "Nowak";
    private static final TicketType TICKET_TYPE = TicketType.CHILD;
    private static final PlaceNumber PLACE_NUMBER = PlaceNumber.A1;

    @Before
    public void beforeEachTestMethod() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    public void shouldReturnStatusIsCreatedWhenReserveTicketsIsAdded() throws Exception {
        CreateMovieRequest createMovieRequest = new CreateMovieRequest(MOVIE_NAME, ROOM_NUMBER,
                START_DATE,
                END_DATE);

        mockMvc.perform(post("/movies")
                .contentType(APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(createMovieRequest)));

        String jsonString = mockMvc.perform(get("/movies")
                .param("startDate", START_DATE.toString())
                .param("endDate", END_DATE.toString()))
                .andReturn().getResponse().getContentAsString();

        GetMoviesDetailsResponse[] asArray = mapper.readValue(jsonString, GetMoviesDetailsResponse[].class);

        ReserveTicketRequest reserveTicketRequest = new ReserveTicketRequest(asArray[asArray.length - 1].getUuid(),
                USER_EMAIL,
                ImmutableList.of(new BookPlace(USER_NAME, USER_SURNAME, TICKET_TYPE, PLACE_NUMBER)));

        mockMvc.perform(post("/tickets")
                .contentType(APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(reserveTicketRequest)))
                .andExpect(status().isCreated());
    }
}
