package com.neoflex.calculatorVacation.controller;

import com.neoflex.calculatorVacation.service.impl.VacationServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VacationControllerTests {
    @Autowired
    private WebApplicationContext context;

    @MockBean
    private VacationServiceImpl service;

    private MockMvc mockMvc;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testCalculateVacationPay_shouldReturnCalculatedValue() throws Exception {
        String salary = "1000";
        String vacationDays = "10";
        double expectedVacationPay = 200;

        when(service.calculateVacationPay(salary, vacationDays)).thenReturn(expectedVacationPay);

        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                        .param("salary", salary)
                        .param("vacationDays", vacationDays)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedVacationPay)));

        verify(service, times(1)).calculateVacationPay(salary, vacationDays);
    }

    @Test
    public void testCalculateVacationPayWithHolidays_shouldReturnCalculatedValue() throws Exception {
        String salary = "1000";
        String vacationDays = "10";
        String startVacation = "2023-08-01";
        String endVacation = "2023-08-10";
        double expectedVacationPay = 200;

        when(service.calculateVacationPayWithHolidays(salary, vacationDays, startVacation, endVacation)).thenReturn(expectedVacationPay);

        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                        .param("salary", salary)
                        .param("vacationDays", vacationDays)
                        .param("startVacation", startVacation)
                        .param("endVacation", endVacation)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedVacationPay)));

        verify(service, times(1)).calculateVacationPayWithHolidays(salary, vacationDays, startVacation, endVacation);
    }
}

