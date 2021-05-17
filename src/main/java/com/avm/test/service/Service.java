package com.avm.test.service;

public class Service {


    private TaskA taskA;

    private TaskB taskB;


    public Service(TaskA taskA, TaskB taskB){
        this.taskA =taskA;
        this.taskB =taskB;
    }





    public boolean isCompleted(){

        if(taskA !=null){

            if(taskB !=null){

                if(taskA.doSomething()==true){

                    if(taskB.doSomethingElse()==true){
                        return true;
                    }
                    return false;
                }else{

                    if(taskB.doSomethingElse()==false){
                        return false;
                    }
                    return false;
                }

            }else{
                return true;
            }

        }else{
            return false;
        }
    }
}
