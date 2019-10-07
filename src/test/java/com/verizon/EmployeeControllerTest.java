package com.verizon;

import com.google.gson.Gson;
import com.verizon.controller.EmployeeController;
import com.verizon.entities.Employee;
import com.verizon.repositories.EmployeeDao;
import com.verizon.services.EmployeeService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import com.verizon.app.Application;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class,secure = false)
@ContextConfiguration(classes=Application.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private EmployeeDao employeeDao;

    Employee mockEmployee = new Employee("2633375","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
    String exampleEmployeeJson = "{\"employeeId\":\"2633375\",\"firstName\":\"Bezawada\".\"lastName\":\"Vikram\",\"email\":\"kitesen98@gmail.com\",\"phone\":\"9876543210\",\"designation\":\"MTS-1\"}";

//    @Test
//    public void addEmployee() throws Exception
//    {
//        System.out.println("Starting Tests");
//        String str="Employee Added Successfully";
//        Employee mockEmployee = new Employee("2633375","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
//        Mockito.when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(str);
//        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/employees/")
//                                                                 .accept(MediaType.TEXT_PLAIN_VALUE).
//                        content(exampleEmployeeJson).
//                        contentType(MediaType.APPLICATION_JSON);
//        MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
//        System.out.println(mvcResult);
//        MockHttpServletResponse response = mvcResult.getResponse();
//        System.out.println("This is the response"+response);
//        assertEquals(str, response);
//
//    }
//    @Before
//    @Test
//    public  void getAllEmployees() throws  Exception
//    {
//        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/employees/").accept(MediaType.ALL)).andReturn();
//        int contentLength=0;
//        assertEquals(contentLength,mvcResult.getResponse().getContentLength());
//    }

    @Test
    public void addEmployee() throws Exception
    {
        Employee mockEmployee = new Employee("2633375","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
        Gson gson=new Gson();
        String json = gson.toJson(mockEmployee);
          String j=gson.toJson(mockEmployee);
          String json1="{\"employeeId\":\"2633375\",\"firstName\":\"Bezawada\",\"lastName\":\"Vikram\",\"email\":\"kitesen98@gmail.com\",\"phone\":\"9876543210\",\"designation\":\"MTS-1\"}";

//getAsJsonObject("accounts").remove("email");
        System.out.println(json1);
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/employees/").
                accept(MediaType.TEXT_PLAIN)
                .content(json1)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentType());
        MvcResult mvcResult2=mockMvc.perform(MockMvcRequestBuilders.get("/employees/1").
                accept(MediaType.ALL))
                .andReturn();
        System.out.println(mvcResult2.getResponse().getContentAsString());


    }

}