package pe.com.intercorp.demo.builder;

import pe.com.intercorp.demo.dto.Client;
import pe.com.intercorp.demo.entity.ClientEntity;
import pe.com.intercorp.demo.util.ClientUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientBuilder {

    public static ClientEntity builderToModel(Client dto){
        return ClientEntity.builder()
                .age(dto.getAge())
                .birthday(ClientUtil.parseToDate(dto.getBirthday()))
                .id(dto.getId())
                .lastName(dto.getLastName())
                .name(dto.getName())
                .build();
    }

    public static List<ClientEntity> builderToModel(List<Client> dtos){
        List<ClientEntity> list = new ArrayList<>();
        if(dtos != null){
            dtos.forEach(dto -> {
                list.add(builderToModel(dto));
            });
        }else {
            return null;
        }
        return list;
    }

    public static Client builderToDto(ClientEntity dto){
        return Client.builder()
                .age(dto.getAge())
                .birthday(ClientUtil.formatToDate(dto.getBirthday()))
                .id(dto.getId())
                .lastName(dto.getLastName())
                .name(dto.getName())
                .deathDate(ClientUtil.formatToDate(ClientUtil.deathDate(dto)))
                .build();
    }

    public static List<Client> builderToDto(List<ClientEntity> dtos){
        List<Client> list = new ArrayList<>();
        if(dtos != null){
            dtos.forEach(dto -> {
                list.add(builderToDto(dto));
            });
        }else {
            return null;
        }
        return list;
    }
}
