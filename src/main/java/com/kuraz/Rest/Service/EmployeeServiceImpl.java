package com.kuraz.Rest.Service;

import com.kuraz.Rest.dao.EmployeeDAO;
import com.kuraz.Rest.dao.EmployeeRepository;
import com.kuraz.Rest.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

     Optional<Employee> result = employeeRepository.findById(theId);
     Employee theEmployee = null;
    if(result.isPresent())
    {
        theEmployee = result.get();
    }
    else {
        throw new RuntimeException("Didn't find and Employee id" + theId);
    }
    return  theEmployee;

                                        }
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
        public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }


//    WITH DAO
    //    private EmployeeDAO employeeDAO;
//
//    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }
//    @Override
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
//
//    @Override
//    public Employee findById(int theId) {
//        return employeeDAO.findById(theId);
//    }
//
//    @Override
//    @Transactional
//    public Employee save(Employee theEmployee) {
//        return employeeDAO.save(theEmployee);
//    }
//
//    @Override
//    @Transactional
//        public void deleteById(int theId) {
//        employeeDAO.deleteById(theId);
//
//    }
}
