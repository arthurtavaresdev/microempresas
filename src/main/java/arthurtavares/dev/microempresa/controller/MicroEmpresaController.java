package arthurtavares.dev.microempresa.controller;

import arthurtavares.dev.microempresa.api.MicroEmpresaDto;
import arthurtavares.dev.microempresa.domain.entity.MicroEmpresa;
import arthurtavares.dev.microempresa.service.MicroEmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class MicroEmpresaController {
    private final MicroEmpresaService microEmpresaService;

    @GetMapping("/micro-empresa/{id}")
    public MicroEmpresaDto getById(@PathVariable String id){
        var microEmpresa = microEmpresaService.get(id);
        return new MicroEmpresaDto(microEmpresa);
    }

    @GetMapping("/micro-empresa")
    public List<MicroEmpresaDto> getAll(){
        var microempresa = microEmpresaService.getAll();
        var microEmpresaDtos = new ArrayList<MicroEmpresaDto>();

        for(var microEmpresa: microempresa){
            microEmpresaDtos.add(new MicroEmpresaDto(microEmpresa));
        }

        return microEmpresaDtos;
    }

    @PostMapping("/micro-empresa")
    public MicroEmpresaDto create(@RequestBody  MicroEmpresaDto microEmpresaDto){
        var microEmpresa = new MicroEmpresa(microEmpresaDto);
        microEmpresa = microEmpresaService.create(microEmpresa);

        return new MicroEmpresaDto(microEmpresa);
    }

    @PutMapping("/micro-empresa/{id}")
    public MicroEmpresaDto create(@PathVariable String id, @RequestBody MicroEmpresaDto microEmpresaDto){
        var microEmpresa = new MicroEmpresa(microEmpresaDto);
        microEmpresa = microEmpresaService.update(id, microEmpresa);

        return new MicroEmpresaDto(microEmpresa);
    }

    @DeleteMapping("/micro-empresa/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        microEmpresaService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
