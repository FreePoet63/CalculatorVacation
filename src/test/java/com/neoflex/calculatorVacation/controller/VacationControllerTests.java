package com.neoflex.calculatorVacation.controller;

import com.neoflex.calculatorVacation.service.VacationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.neoflex.calculatorVacation.util.DataResultController.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VacationControllerTests {
    @Autowired
    private WebApplicationContext context;

    @MockBean
    private VacationService service;

    private MockMvc mockMvc;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testCalculateVacationPay_shouldReturnCalculatedValue() throws Exception {
        String salary = getSalary();
        String vacationDays = getVacationDays();
        double expectedVacationPay = Double.parseDouble(getExpectedVacationPay());

        when(service.calculateVacationPay(salary, vacationDays)).thenReturn(expectedVacationPay);

        mockMvc.perform(MockMvcRequestBuilders.get("/calculacte")
                        .param("salary", salary)
                        .param("vacationDays", vacationDays)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedVacationPay)));

        verify(service, times(1)).calculateVacationPay(salary, vacationDays);
    }

    @Test
    public void testCalculateVacationPayWithHolidays_shouldReturnCalculatedValue() throws Exception {
        String salary = getSalary();
        String vacationDays = getVacationDays();
        String startVacation = getStartVacation();
        String endVacation = getEndVacation();
        double expectedVacationPay = Double.parseDouble(getExpectedVacationPay());

        when(service.calculateVacationPayWithHolidays(salary, vacationDays, startVacation, endVacation)).thenReturn(expectedVacationPay);

        mockMvc.perform(MockMvcRequestBuilders.get("/calculacte")
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

