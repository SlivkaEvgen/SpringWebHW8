package com.homework.springwebhw8.controller;

//
//@Controller
//public class WelcomeController {
//
//    @GetMapping("/")
//    public String welcome() {//Map<String,Object> model //        model.put("time", new Date());
////        return "_homeView.html";                         //        model.put("message", "hello world");
////        return "userListView.html";                         //        model.put("message", "hello world");
//    }
//}




//
//package org.homework.SpringWithDima.controller;
//
//import io.swagger.annotations.ApiParam;
//import io.swagger.v3.oas.annotations.Operation;
//import org.homework.SpringWithDima.model.Company;
//import org.homework.SpringWithDima.repository.CrudRepositoryJDBC;
//import org.springframework.web.bind.annotation.*;
//
//// SPel - Spring expression language
//// Controller & RestController-(контроллер респонсБоди!) делают из контроллера Bean
//// то есть RestController == Controller + ResponseBody.
////@Controller
////@ResponseBody
////@RequiredArgsConstructor
//@RestController
//@RequestMapping(value = "company")
//public class CompanyController {
//
//    private final CrudRepositoryJDBC<Company,Long> companyRepository;
//
//    public CompanyController(CrudRepositoryJDBC<Company, Long> companyRepository) {
//        this.companyRepository = companyRepository;
//    }
////    private final Map<String,IAdapter> mapOfAllControllers;
////    private final ApplicationContext applicationContext; //== центральный интерфейс всего СПРИНГА
////
////    private final CompanyRepository companyRepository;
//
////    @Autowired
////    private  JpaRepository<Company,Long> repository;
//
//    //   @GetMapping//(value = "all")
////    public List<Company> findAll() {
////     return companyRepository.findAll();
////    public ResponseEntity<List<Company>> findAll() {
////        return ResponseEntity.ok(companyRepository.findAll());
//
//    @GetMapping
//    public List<Company> findAll() {
////        IAdapter iAdapter = applicationContext.getBean("name Controller - ex table1 or table2; trello or jira");
////        CompanyRepository bean = applicationContext.getBean(CompanyRepository.class);
////        JpaRepository bean = applicationContext.getBean("companyRepository",JpaRepository.class);
////        CompanyRepository bean = applicationContext.getBean("companyRepository", CompanyRepository.class);
//       return companyRepository.findAll();
////        return bean.findAll();
//
//    }
//
//    // https://localhost:8080/company/id/1
//    // https://localhost:8080/company?id=1&name=newname
////    @GetMapping("/id/{id}")//== https://localhost:8080/company/id/1
////    @GetMapping("/id/{id}/name/{name}")//== https://localhost:8080/company/1
//    @GetMapping({"/{id}", "/"})
//    public Optional<Company> findById(@PathVariable(required = false, name = "id") Optional<Long> id) {
//        if (id.isPresent()) {
//            return companyRepository.findById(id.get());
//        } else return companyRepository.findById(2L);
//    }
//
////    @GetMapping("/name/{name}")
////    public List<Company> findByName(@PathVariable(name = "name") String name){
////        return companyRepository.findByName(name);
////    }
//
//
//    @Operation(
//            description = "...")
////    @ApiResponses(value)
//    @PostMapping
//    public Company save(@RequestBody Company company) {
//        return companyRepository.save(company);
//    }
//
//    @PutMapping("name")
//    public Company changeName(@RequestParam(name = "id", required = false, defaultValue = "2") Long id,
//                              @ApiParam(required = true,name = "Name of Company", defaultValue = "Go-IT")
//                              @RequestParam(name = "name") String name) {
//        return companyRepository.findById(id)
//                .map(company -> {
//                    company.setName(name);
//                    return companyRepository.save(company);
//                })
//                .orElse(null);
//    }
////    @Transactional - дорого в производительности
//    @PutMapping("city")
//    public Company changeCity(
//            @RequestParam(name = "id", required = false, defaultValue = "2") Long id,
//            @RequestParam(name = "city") String city) {
//        return companyRepository.findById(id)
//                .map(company -> {
//                    company.setCity(city);
////                    return company;
//                    return companyRepository.save(company);
//                })
//                .orElse(null);
//    }
//
//    @DeleteMapping("{id}")
//    public void deleteById(@PathVariable(name = "id") Long id) {
//        companyRepository.deleteById(id);
//    }
////    =====================================
////                передача хедера
//
////    @PutMapping("city")
////    public Company changeCity(
////            @RequestHeader("token") String token,
////            @RequestParam(name = "id",required = false,defaultValue = "2") Long id,
////            @RequestParam(name = "city")String city) {
////        return companyRepository.findById(id)
////                .map(company ->{
////                    company.setCity(city);
////                    return companyRepository.save(company);
////                })
////                .orElse(null);
////    }
//    //===============================================
//
//
//}
//
//
//////@RequiredArgsConstructor
////@RestController
////@RequestMapping(value = "company")
////public class CompanyController {
////
//////    @Value("${test.value:default test value}")
//////    private final String test;
////    private final CompanyRepository companyRepository;
////
////    public CompanyController(CompanyRepository companyRepository) {
////        this.companyRepository = companyRepository;
////
////    }
//////    public CompanyController(CompanyRepository companyRepository,@Value("${test.value:default test value}")String test) {
//////        this.companyRepository = companyRepository;
//////        this.test = test;
//////    }
////
////    @GetMapping//(value = "all")
////    public List<Company> findAll() {
//////        System.out.println(test);
////        return companyRepository.findAll();
////    }
////
//////    @GetMapping
//////    public Company findById(Long id){
//////
//////    }
////}