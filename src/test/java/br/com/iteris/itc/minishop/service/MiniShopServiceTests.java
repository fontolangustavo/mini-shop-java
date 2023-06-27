package br.com.iteris.itc.minishop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
