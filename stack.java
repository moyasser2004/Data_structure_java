///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author Mohamed Yasser
// */



public class stack {
    
 static int size=100;
 
    int top;
    int[] arry ;
    
    public stack(){
       this.top = -1; 
       this.arry = new int [size];
    }
    
   public boolean isEmpety(){
        return top < 0;
   } 
    
  void push(int element){
       if(top > size-1 ){
           System.out.println("Size full");
        }else{
         top ++;
       arry[top]=element;   
      }
   }
  
  void pop(){
      if(isEmpety()){
          System.out.println("the stack is empety");
      }else{
         top--;   
      }
  } 
 
  
  int getTop() {
      if(isEmpety()){  
     System.out.println("the stack is empety");
          return 0;
      }else{
         return arry[top];
        } 
  }
  
  void print(){
      System.out.print("[ ");
      for(int i=size-1; i>=0 ;i--){
          if(arry[i] != 0){
           System.out.print(" "+arry[i] +" ");   
          }
      }
       System.out.print(" ]");
  }
  
  
}
