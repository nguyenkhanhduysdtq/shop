<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="APIurl" value="/NewAPI"/>
<c:url var="wedURL"  value="/ManagerAccountControll" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit Account</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Account</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form id="formbuttonUpdate">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add Account</h4>
                                <button  type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${model.id}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Username</label>
                                    <input value="${model.username}"  name="username" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>password</label>
                                    <input value="${model.password}"  name="password" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>isSell</label>
                                    <input  value="${model.isSell}" name="isSell" type="text" class="form-control" required>
                                </div>
                          
                                <div class="form-group">
                                    <label>isAdmin</label>
                                    <input value="${model.isAdmin}" name="isAdmin" type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" id="buttonUpdateAccount" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
         
       <script>
       $('#buttonUpdateAccount').click(function(e){
    	   e.preventDefault();
    	   var data={};
           var fromdata= $('#formbuttonUpdate').serializeArray();
           $.each(fromdata,function(i,v){
            data[""+v.name+""]=v.value;
           })

           updateAccount(data);

    	 });

         function updateAccount(data){
          $.ajax({
             url:'${APIurl}',
             contentType:'application/json',
             type:'PUT',
             data:JSON.stringify(data),
             dataType:'json',
             success : function (result){
                window.location.href = "${wedURL}?message=success";
		},

       error : function(error){
        window.location.href = "${wedURL}?message=false";
	   },

             

          })

         }
       
       </script>
       
       
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>