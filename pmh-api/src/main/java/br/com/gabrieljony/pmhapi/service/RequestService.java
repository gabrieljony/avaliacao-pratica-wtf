package br.com.gabrieljony.pmhapi.service;

import br.com.gabrieljony.pmhapi.model.Client;
import br.com.gabrieljony.pmhapi.model.Request;
import br.com.gabrieljony.pmhapi.repository.RequestRepository;
import br.com.gabrieljony.pmhapi.service.exception.DataIntegrityException;
import br.com.gabrieljony.pmhapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    public Request findById(Integer id){
        Optional<Request> obj = requestRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object não " +
                "encontrado! ID: " + id + ", Tipo: " + Client.class.getName()));
    }

    @Transactional
    public Request insert(Request obj){
        obj.setRequest_id(null);
        obj = requestRepository.save(obj);
        return obj;
    }

    public Request update(Request obj){
        Request newObj = findById(obj.getRequest_id());
        return requestRepository.save(newObj);
    }

    public void delete(Integer id){
        findById(id);
        try {
            requestRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir.");
        }

    }
}
