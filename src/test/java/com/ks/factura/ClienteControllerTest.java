package com.ks.factura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ks.factura.controller.ClienteController;
import com.ks.factura.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void testListClientes() throws Exception {


        String url="http://localhost:9192/cliente";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getClientesByIdAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .get("http://localhost:9192/cliente/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

        @Test
        public void getClientesSucursalesByIdAPI() throws Exception
        {
            mockMvc.perform( MockMvcRequestBuilders
                            .get("http://localhost:9192/cliente/sucursal/{clienteid}", 1)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());

        }



}
