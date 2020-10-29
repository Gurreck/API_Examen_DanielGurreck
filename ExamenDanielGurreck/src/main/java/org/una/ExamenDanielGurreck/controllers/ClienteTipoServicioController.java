package org.una.ExamenDanielGurreck.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.ExamenDanielGurreck.dto.ClienteTipoServicioDTO;
import org.una.ExamenDanielGurreck.services.IClienteTipoServicioService;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/clientesTiposServicios")
@Api(tags = {"Clientes Tipos Servicios"})
public class ClienteTipoServicioController {

    @Autowired
    private IClienteTipoServicioService clienteTipoServicioService;

    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/findAll")
    @ApiOperation(value = "Obtiene una lista de todos los clientes con el tipo de servicio que tienen de membrecia o tuvieron", response = ClienteTipoServicioDTO.class, responseContainer = "List", tags = "Clientes Tipos Servicios")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(clienteTipoServicioService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Obtiene un cliente con el tipo de servicio por su Id", response = ClienteTipoServicioDTO.class, tags = "Clientes Tipos Servicios")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(clienteTipoServicioService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @ApiOperation(value = "Permite crear un cliente con el tipo de servicio ", response = ClienteTipoServicioDTO.class, tags = "Clientes Tipos Servicios")
    public ResponseEntity<?> create(@Valid @RequestBody ClienteTipoServicioDTO clienteTipoServicioDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(clienteTipoServicioService.create(clienteTipoServicioDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Permite modificar un cliente con el tipo de servicio a partir de su Id", response = ClienteTipoServicioDTO.class, tags = "Clientes Tipos Servicios")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody ClienteTipoServicioDTO clienteTipoServicioDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<ClienteTipoServicioDTO> clienteTipoServicioUpdated = clienteTipoServicioService.update(clienteTipoServicioDTO, id);
                if (clienteTipoServicioUpdated.isPresent()) {
                    return new ResponseEntity(clienteTipoServicioUpdated, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
}