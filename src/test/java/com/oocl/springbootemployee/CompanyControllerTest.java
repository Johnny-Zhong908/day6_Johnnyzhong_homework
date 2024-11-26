package com.oocl.springbootemployee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.springbootemployee.model.Company;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.hasSize;
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class CompanyControllerTest {

    @Autowired
    private MockMvc client;

    @Test
    void shouldGetAllCompanies() throws Exception {
        client.perform(MockMvcRequestBuilders.get("/companies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }

    @Test
    void shouldGetCompanyById() throws Exception {
        client.perform(MockMvcRequestBuilders.get("/companies/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("OOCL1"));
    }

    @Test
    void shouldGetEmployeesByCompanyId() throws Exception {
        client.perform(MockMvcRequestBuilders.get("/companies/1/employees"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldGetCompaniesByPage() throws Exception {
        client.perform(MockMvcRequestBuilders.get("/companies/page?page=1&size=2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    void shouldAddCompany() throws Exception {
        Company company = new Company(4, "OOCL4");
        client.perform(MockMvcRequestBuilders.post("/companies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(company)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldDeleteCompany() throws Exception {
        client.perform(MockMvcRequestBuilders.delete("/companies/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
