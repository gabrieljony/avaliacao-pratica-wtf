package br.com.gabrieljony.pmhapi.service;

import br.com.gabrieljony.pmhapi.model.Client;
import br.com.gabrieljony.pmhapi.repository.ClientRepository;
import br.com.gabrieljony.pmhapi.service.exception.DataIntegrityException;
import br.com.gabrieljony.pmhapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object não " +
                "encontrado! ID: " + id + ", Tipo: " + Client.class.getName()));
    }

    @Transactional
    public Client insert(Client obj){
        obj.setClient_id(null);
        obj = clientRepository.save(obj);
        return obj;
    }

    public Client update(Client obj){
        Client newObj = findById(obj.getClient_id());
        return clientRepository.save(newObj);
    }

    public void delete(Integer id){
        findById(id);
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir.");
        }

    }
}
