package br.com.gabrieljony.pmhapi.controller;

import br.com.gabrieljony.pmhapi.model.Request;
import br.com.gabrieljony.pmhapi.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Request>> findAll() {
        List<Request> list = requestService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Request> find(@PathVariable Integer id) {
        Request obj = requestService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Request obj) {
        obj = requestService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(("/{id}"))
                .buildAndExpand(obj.getRequest_id())
                .toUri();

        return  ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Request obj) {
        obj.setRequest_id(id);
        obj = requestService.update(obj);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        requestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
