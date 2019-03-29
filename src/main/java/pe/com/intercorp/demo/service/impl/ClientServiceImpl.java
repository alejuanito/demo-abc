/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.intercorp.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intercorp.demo.builder.ClientBuilder;
import pe.com.intercorp.demo.dto.Client;
import pe.com.intercorp.demo.dto.KpiClient;
import pe.com.intercorp.demo.entity.ClientEntity;
import pe.com.intercorp.demo.repository.ClientRepository;
import pe.com.intercorp.demo.service.ClientService;
import pe.com.intercorp.demo.util.ClientUtil;
import pe.com.intercorp.demo.util.Constant;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        return ClientBuilder.builderToDto(clientRepository.save(ClientBuilder.builderToModel(client)));
    }

    @Override
    public List<Client> listClient() {
        return ClientBuilder.builderToDto(clientRepository.findAll());
    }

    @Override
    public KpiClient kpisClient() {
        List<ClientEntity> list = clientRepository.findAll();
        if(list == null || list.isEmpty()){
            return KpiClient.builder()
                    .average(0.0)
                    .deviation(0.0)
                    .build();
        }else{
            return KpiClient.builder()
                    .average(ClientUtil.average(list))
                    .deviation(ClientUtil.deviation(list))
                    .build();
        }

    }




}
