<script>
    
    function addstock(pid){
       
        var qty=document.getElementById("newqty").value;
         $.post("Add_new_stock_batch", {pid:pid,newqty:qty},function(data){
//              alert("tadaa");
        location.reload();
        
        
    });
    }
</script>
<!-- Add stock -->

<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">
<!--        <form action="Add_new_stock_batch">-->
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add New Stock</h4>
                </div>
                <div class="modal-body">
                    <p>Enter here new quantity you wants to add</p>
                    <p><input class="form-control" type="number" min="0"  id="newqty"></p>
                </div>
                <p>
                   
                   
                <div class="modal-footer">
                    <button type="submit" data-dismiss="modal" class="btn btn-primary" onclick="addstock(<%=p.getIdproduct()%>)">Add</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
<!--        </form>-->
    </div>
</div>

<!--Description-->
<form action="update_details">
<div id="DescriptionModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">
        
            <!-- Modal content-->
             
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Description</h4>
                </div>
                <div class="modal-body">
                    <p>Enter here new quantity you wants to add</p>
                    <p><input class="form-control  " type="text" name="newDis"></p>
                </div>
                <p><input type="hidden" name="pid" value="<%=p.getIdproduct()%>">

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
        <!--</form>-->
    </div>
</div>




<!--Selling Price-->

<div id="PriceModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">
        <!--<form action="update_details">-->
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Price</h4>
                   
                </div>
                <div class="modal-body">
                    <p>Enter here new prices you wants to add</p>
                    <p><input class="form-control  " type="text" name="newPrice"></p>
                </div>
                <p><input type="hidden" name="pid" value="<%=p.getIdproduct()%>">

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
<!--  </form>-->
    </div>
</div>

                <!--Buying Price-->

<div id="BPriceModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">
        <!--<form action="update_details">-->
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Buying Price</h4>
                   
                </div>
                <div class="modal-body">
                    <p>Enter here new prices you wants to add</p>
                    <p><input class="form-control  " type="text" name="newbprice"></p>
                </div>
                <p><input type="hidden" name="pid" value="<%=p.getIdproduct()%>">

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
               
            </div>
<!--         </form>-->
    </div>
</div>

<!--weight-->

<div id="weight" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">
        <!--<form action="update_details">-->
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Weight</h4>
                     
                </div>
                <div class="modal-body">
                    <p>Enter weight</p>
                    <p><input class="form-control  " type="text" name="newWeight"></p>
                </div>
                <p><input type="hidden" name="pid" value="<%=p.getIdproduct()%>">

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
<!--  </form>-->
    </div>
</div>
                
                
                
                <!--warrenty-->

<div id="warrent" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">
        <!--<form action="update_details">-->
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Warrenty</h4>
                    
                </div>
                <div class="modal-body">
                    <p>Enter here new warrenty date you wants to add</p>
                    <p><input class="form-control  " type="text" name="newarr"></p>
                </div>
                <p><input type="hidden" name="pid" value="<%=p.getIdproduct()%>">

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
<!--  </form>-->
    </div>
</div>
                
                
                <!--report problem-->
                
                <div id="report" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">
        <!--<form action="update_details">-->
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Report </h4>
                    
                </div>
                <div class="modal-body">
                    <p>Reason</p>
                    <p><input class="form-control  " type="text" name="reason"></p>
                    <p>Description</p>
                    <p><textarea class="form-control  "  name="Description"></textarea></p>
                </div>
                

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Report</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
  <!--</form>-->
    </div>
</div>
</form>