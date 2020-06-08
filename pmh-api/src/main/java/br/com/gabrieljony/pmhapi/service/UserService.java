package br.com.gabrieljony.pmhapi.service;

import br.com.gabrieljony.pmhapi.model.Client;
import br.com.gabrieljony.pmhapi.model.User;
import br.com.gabrieljony.pmhapi.repository.UserRepository;
import br.com.gabrieljony.pmhapi.service.exception.DataIntegrityException;
import br.com.gabrieljony.pmhapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object não " +
                "encontrado! ID: " + id + ", Tipo: " + Client.class.getName()));
    }

    @Transactional
    public User insert(User obj){
        obj.setUser_id(null);
        obj = userRepository.save(obj);
        return obj;
    }

    public User update(User obj){
        User newObj = findById(obj.getUser_id());
        return userRepository.save(newObj);
    }

    public void delete(Integer id){
        findById(id);
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir .");
        }

    }
}
