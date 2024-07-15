package com.controller;

import com.entity.CabFare;
import com.service.CabFareService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;

public class CabFareControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CabFareService cabFareService;

    @InjectMocks
    private CabFareController cabFareController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cabFareController).build();
    }

    @Test
    public void testCreateCabFare() throws Exception {
        CabFare cabFare = new CabFare();
        cabFare.setCfId(234);
        cabFare.setFromBooking("Moita");
        cabFare.setToBooking("Almada");
        cabFare.setTypeofcab("uber");
        cabFare.setAmount(132);

        // Mock the service call
        Mockito.when(cabFareService.createCabeFare(cabFare)).thenReturn("Cab Fare created");

        
        
     // testing 
     		String result = cabFareController.createCabFare(cabFare);
     		assertEquals("Cab Fare created", result);

     		
     		
        // Perform the POST request and verify the result
//        mockMvc.perform(MockMvcRequestBuilders.post("/cabfare/create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"cfId\":234,\"fromBooking\":\"Moita\",\"toBooking\":\"Almada\",\"typeofcab\":\"uber\",\"amount\":132}"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Cab Fare created"));
    }

    @Test
    @Disabled
    public void testGetCabFare() throws Exception {
        
    }
}
