package com.avm.test.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {


    @Mock
    TaskA taskA;

    @Mock
    TaskB taskB;

    @InjectMocks
    Service service;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void should_Return_False_TaskA_And_TaskB_Is_Null(){
        //Given
        service = new Service(null,null);
        //When / Then
        Assertions.assertEquals(false,service.isCompleted());
    }

    @Test
    public void should_Return_False_TaskA_Is_Null(){
        //Given
        service = new Service(null,taskB);
        //When / Then
        Assertions.assertEquals(false,service.isCompleted());
    }

    @Test
    public void should_Return_True_TaskB_Is_Null(){
        //Given
        service = new Service(taskA,null);
        //When / Then
        Assertions.assertEquals(true,service.isCompleted());
    }


    @Test
    public void should_Return_True_TaskA_doSomthing_Return_TrueAndTaskB_doSomthingElse_Return_True(){
        //Given
        Mockito.when(taskA.doSomething()).thenReturn(true);
        Mockito.when(taskB.doSomethingElse()).thenReturn(true);
        //When / Then
        Assertions.assertEquals(true,service.isCompleted());
        Mockito.verify(taskA,Mockito.atLeastOnce()).doSomething();
        Mockito.verify(taskB,Mockito.atLeastOnce()).doSomethingElse();

    }
    
    
    @Test
    public void should_Return_Fale_TaskA_doSomthing_Return_FalseAndTaskB_doSomthingElse_Return_True(){
        //Given
        Mockito.when(taskA.doSomething()).thenReturn(false);
        Mockito.when(taskB.doSomethingElse()).thenReturn(true);
        //When / Then
        Assertions.assertEquals(false,service.isCompleted());
        Mockito.verify(taskA,Mockito.atLeastOnce()).doSomething();
        Mockito.verify(taskB,Mockito.atLeastOnce()).doSomethingElse();

    }
    
    
    @Test
    public void should_Return_Fale_TaskA_doSomthing_Return_TrueAndTaskB_doSomthingElse_Return_False(){
        //Given
        Mockito.when(taskA.doSomething()).thenReturn(true);
        Mockito.when(taskB.doSomethingElse()).thenReturn(false);
        //When / Then
        Assertions.assertEquals(false,service.isCompleted());
        Mockito.verify(taskA,Mockito.atLeastOnce()).doSomething();
        Mockito.verify(taskB,Mockito.atLeastOnce()).doSomethingElse();

    }


}
