package com.nuevocredito.inmocredit.controller;

import com.nuevocredito.inmocredit.dto.datainmobiliariaDTO;
import com.nuevocredito.inmocredit.entities.DataInmobiliaria;
import com.nuevocredito.inmocredit.entities.EntidadFinanciera;
import com.nuevocredito.inmocredit.security.entity.User;
import com.nuevocredito.inmocredit.security.service.UserService;
import com.nuevocredito.inmocredit.service.IDataInmobiliarioService;
import com.nuevocredito.inmocredit.service.IEntidadFinancieraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/data-inmobiliaria")
@Api(tags = "Data Inmobiliaria", value = "Web Service RESTful - Data Inmobiliaria")
public class DataInmobiliariaController {
    private final IDataInmobiliarioService dataInmobiliarioService;
    private final UserService userService;
    private final IEntidadFinancieraService entidadFinancieraService;
    public DataInmobiliariaController(IDataInmobiliarioService dataInmobiliarioService, UserService userService, IEntidadFinancieraService entidadFinancieraService) {
        this.dataInmobiliarioService = dataInmobiliarioService;
        this.userService = userService;
        this.entidadFinancieraService = entidadFinancieraService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all inmobiliaria data", notes = "Method for list all data")
    @ApiResponses({
            @ApiResponse(code = 201, message = "data found"),
            @ApiResponse(code = 404, message = "data not found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<List<DataInmobiliaria>> findAllDataInmobiliaria(){
        try{
            List<DataInmobiliaria> data = dataInmobiliarioService.getAll();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Insert data", notes = "Method for insert new data")
    @ApiResponses({
            @ApiResponse(code = 201, message = "data created"),
            @ApiResponse(code = 404, message = "data not created"),
            @ApiResponse(code = 501, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Unauthorized")
    })
    public ResponseEntity<DataInmobiliaria> insertDataInmobiliaria(@Valid @RequestBody datainmobiliariaDTO dataInmobiliaria){
        try{
            Optional<User> user = userService.findByUserName(dataInmobiliaria.getUsername());
            if(user.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            EntidadFinanciera entidad = new EntidadFinanciera( dataInmobiliaria.getEntidadFinanciera().getNombreEntidad(),
                    dataInmobiliaria.getEntidadFinanciera().getTipoTasa(), dataInmobiliaria.getEntidadFinanciera().getTipoTasaNominal(),
                    dataInmobiliaria.getEntidadFinanciera().getTipoCapitalizacion(),dataInmobiliaria.getEntidadFinanciera().getValorTasa(),
                    dataInmobiliaria.getEntidadFinanciera().getPlazo(),dataInmobiliaria.getEntidadFinanciera().getSegDesgravamen(),
                    dataInmobiliaria.getEntidadFinanciera().getSegInmueble());

            EntidadFinanciera entidadNew = entidadFinancieraService.save(entidad);

            DataInmobiliaria data = new DataInmobiliaria();

            data.setMoneda(dataInmobiliaria.getMoneda());
            data.setCuotaInicial(dataInmobiliaria.getCuotaInicial());
            data.setValorInmueble(dataInmobiliaria.getValorInmueble());
            data.setApoyoHabitacional(dataInmobiliaria.getApoyoHabitacional());
            data.setSostenibilidad(dataInmobiliaria.getSostenibilidad());
            data.setTotalBBP(dataInmobiliaria.getTotalBBP());
            data.setPerParcial(dataInmobiliaria.getPerParcial());
            data.setPerTotal(dataInmobiliaria.getPerTotal());
            data.setEntidadFinanciera(entidadNew);
            data.setUser(user.get());

            DataInmobiliaria dataInmobiliariaNew = dataInmobiliarioService.save(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(dataInmobiliariaNew);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
