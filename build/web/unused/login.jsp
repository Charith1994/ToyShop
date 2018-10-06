<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Sign In</h4>
            </div>
            <form action="UserLogin" method="POST">
            <div class="modal-body">
                <div class="form-group">
                    <label for="exampleInputEmail1">User Name or Email</label>

                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
                        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter User Name or Email" name="unameoremail">
                    </div>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>

                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-star"></span></span>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="upass">
                    </div>
                </div>
                <p class="text-right"><a href="#">Forgot password?</a></p>
            </div>
            <div class="modal-footer">
                <a href="#" data-dismiss="modal" class="btn">Close</a>
                <a href="register.jsp"  class="btn">Not Member</a>
                <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-lock"></span>Login</button>
            </div>
            </form>
        </div>
    </div>
</div>

