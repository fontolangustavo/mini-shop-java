package br.com.iteris.itc.minishop.serviceTest;

import br.com.iteris.itc.minishop.service.MiniShopService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MiniShopServiceTests {

    @InjectMocks
    private MiniShopService service;

    @Test
    public void foo(){
        assertEquals ("Api minishop" , service.foo());
    }

}