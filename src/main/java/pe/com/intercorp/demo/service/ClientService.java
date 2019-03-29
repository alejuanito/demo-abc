package pe.com.intercorp.demo.service;

import pe.com.intercorp.demo.dto.Client;
import pe.com.intercorp.demo.dto.KpiClient;

import java.util.List;

public interface ClientService {
    Client create(Client client);
    List<Client> listClient();
    KpiClient kpisClient();
}
