package pe.com.intercorp.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.com.intercorp.demo.entity.ClientEntity;
import pe.com.intercorp.demo.service.ClientService;
import pe.com.intercorp.demo.util.ClientUtil;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KpiTest {

    List<ClientEntity> list = new ArrayList<>();
    ClientEntity client = new ClientEntity();
    @Before
    public void before(){
        list.add(ClientEntity.builder()
                .age(2).build());
        list.add(ClientEntity.builder()
                .age(4).build());
        list.add(ClientEntity.builder()
                .age(4).build());
        list.add(ClientEntity.builder()
                .age(4).build());
        list.add(ClientEntity.builder()
                .age(5).build());
        list.add(ClientEntity.builder()
                .age(5).build());
        list.add(ClientEntity.builder()
                .age(7).build());
        list.add(ClientEntity.builder()
                .age(9).build());

        client.setAge(34);
        client.setBirthday(ClientUtil.parseToDate("01/09/1984"));
    }

    @Test
    public void average(){
        Assert.assertEquals(ClientUtil.average(list), 5, 0);
    }

    @Test
    public void deviation(){
        Assert.assertEquals(ClientUtil.deviation(list), 2, 0);
    }

    @Test
    public void deathDate(){
        Assert.assertEquals(ClientUtil.deathDate(client),ClientUtil.parseToDate("01/09/2064"));
    }
}
