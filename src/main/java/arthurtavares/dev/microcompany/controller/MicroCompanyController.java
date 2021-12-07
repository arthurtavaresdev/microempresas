package arthurtavares.dev.microcompany.controller;

import arthurtavares.dev.microcompany.api.MicroCompanyDto;
import arthurtavares.dev.microcompany.domain.entity.MicroCompany;
import arthurtavares.dev.microcompany.service.MicroCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class MicroCompanyController {
    private final MicroCompanyService microCompanyService;

    @GetMapping("/micro-company/{id}")
    public MicroCompanyDto getById(@PathVariable String id){
        var microCompany = microCompanyService.get(id);
        return new MicroCompanyDto(microCompany);
    }

    @GetMapping("/micro-company")
    public List<MicroCompanyDto> getAll(){
        var microCompanies = microCompanyService.getAll();
        var microCompanyDtos = new ArrayList<MicroCompanyDto>();

        for(var microCompany: microCompanies){
            microCompanyDtos.add(new MicroCompanyDto(microCompany));
        }

        return microCompanyDtos;
    }

    @PostMapping("/micro-company")
    public MicroCompanyDto create(@RequestBody MicroCompanyDto microCompanyDto){
        var microCompany = new MicroCompany(microCompanyDto);
        microCompany = microCompanyService.create(microCompany);

        return new MicroCompanyDto(microCompany);
    }

    @PutMapping("/micro-company/{id}")
    public MicroCompanyDto create(@PathVariable String id, @RequestBody MicroCompanyDto microCompanyDto){
        var microCompany = new MicroCompany(microCompanyDto);
        microCompany = microCompanyService.update(id, microCompany);

        return new MicroCompanyDto(microCompany);
    }

    @DeleteMapping("/micro-company/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        microCompanyService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
