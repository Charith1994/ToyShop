/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function (){

    $(".ed").click(
            function (){
                
               var selectButn = $(this).parent().parent();
        var qty = $(selectButn).find('.Qty').val();
     
        var id=$(selectButn).find('.prodid').val();    
              
         $.post("sescart",{id:id,qty:qty},function(data,status){
                     location.reload();
             alert("done");
             
     
  }
        
               
                
                );
       
            }
                );
         
}
        
            
            );
    
    
    
    
   