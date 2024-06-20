package ru.gb.seminar2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.seminar2.api.CustomerResponse;
import ru.gb.seminar2.model.Customer;
import ru.gb.seminar2.repository.CustomRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomRepository repository;
    public List<CustomerResponse> getAll(){
     return repository.findAll().stream()
             .map(this::map)
             .collect(Collectors.toList());
    }

    public Optional findById(Long id){
        return repository.findById(id)
                .map(this::map);
    }

    private CustomerResponse map(Customer customer){
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        return response;
    }
}
