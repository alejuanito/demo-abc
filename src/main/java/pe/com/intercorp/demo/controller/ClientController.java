package pe.com.intercorp.demo.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.intercorp.demo.dto.Client;
import pe.com.intercorp.demo.service.ClientService;

import javax.validation.Valid;


@RestController
//@RequestMapping("/api/client")
@Api(value = "Invoices Operations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/creacliente")
    @ResponseBody
    @ApiOperation(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "Creacion de clientes", notes = "Creación de clientes de Intercorp.", code = 200)
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request, datos incompletos"),
            @ApiResponse(code = 200, message = "Creación exitosa")})
    public ResponseEntity<?> create(@RequestBody @Valid Client client) {
        return ResponseEntity.ok().body(clientService.create(client));
    }


    @GetMapping("/listclientes")
    @ResponseBody
    @ApiOperation(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,
            value = "Lista de clientes", notes = "Lista de clientes.",
            responseContainer = "Array", response = Client.class, code = 200)
    public ResponseEntity<?> getListItems() {
        return ResponseEntity.ok().body(clientService.listClient());


    }

    @GetMapping("/kpideclientes")
    @ResponseBody
    @ApiOperation(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,
            value = "Datos KPIs", notes = "KPIs.",
            responseContainer = "Array", response = Client.class, code = 200)
    public ResponseEntity<?> getKpis() {
        return ResponseEntity.ok().body(clientService.kpisClient());


    }
}
