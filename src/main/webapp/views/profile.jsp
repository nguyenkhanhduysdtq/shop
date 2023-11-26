<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link href="http://localhost:8080/shop/css/style.css" rel="stylesheet" />
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>

<style type="text/css">

body{
    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
}
.emp-profile{
    padding: 3%;
    margin-top: 3%;
    margin-bottom: 3%;
    background: #fff;
     border-radius: 0.5rem;
     
     width: 2200px;
     
}
.profile-img{
    text-align: center;
}
.profile-img img{
    width: 60%;
    height: 100%;
}
.profile-img .file {
    position: relative;
    overflow: hidden;
    margin-top: -20%;
    width: 70%;
    border: none;
    border-radius: 0;
    font-size: 15px;
    background: #212529b8;
}
.profile-img .file input {
    position: absolute;
    opacity: 0;
    right: 0;
    top: 0;
}
.profile-head h5{
    color: #333;
}
.profile-head h6{
    color: #0062cc;
}
.profile-edit-btn{
    border: none;
    border-radius: 1.5rem;
    width: 70%;
    padding: 2%;
    font-weight: 600;
    color: #6c757d;
    cursor: pointer;
}
.proile-rating{
    font-size: 12px;
    color: #818182;
    margin-top: 5%;
}
.proile-rating span{
    color: #495057;
    font-size: 15px;
    font-weight: 600;
}
.profile-head .nav-tabs{
    margin-bottom:5%;
}
.profile-head .nav-tabs .nav-link{
    font-weight:600;
    border: none;
}
.profile-head .nav-tabs .nav-link.active{
    border: none;
    border-bottom:2px solid #0062cc;
}
.profile-work{
    padding: 14%;
    margin-top: -15%;
}
.profile-work p{
    font-size: 12px;
    color: #818182;
    font-weight: 600;
    margin-top: 10%;
}
.profile-work a{
    text-decoration: none;
    color: #495057;
    font-weight: 600;
    font-size: 14px;
}
.profile-work ul{
    list-style: none;
}
.profile-tab label{
    font-weight: 600;
}
.profile-tab p{
    font-weight: 600;
    color: #0062cc;
}

</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="container emp-profile">

            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="https://tse3.mm.bing.net/th?id=OIP.dIF3iIIIuK5HeBCq_aoxZwAAAA&pid=Api&P=0&h=180" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                Change Photo
                                <input type="file" name="file"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                       ${sessionScope.acc.username}
                                    </h5>
                                    <h6>
                                        sex:nam
                                    </h6>
                                    <p class="proile-rating">RANKINGS : <span>8/10</span></p>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-work">
                            <p>WORK LINK</p>
                           <img style="width: 30px;height: 30px"  alt="" src="https://tse2.mm.bing.net/th?id=OIP.1D5fBcpgk_Ao3q-sCCxo1wHaHa&pid=Api&P=0&h=180"> <a href="">Hồ sơ</a><br/>
                           <img style="width: 30px;height: 30px" alt="" src="https://tse3.mm.bing.net/th?id=OIP.EK-C8IPmUdpSBYcQ0TRNkQHaE3&pid=Api&P=0&h=180"> <a href="">Ngân hàng</a><br/>
                            <img style="width: 30px;height: 30px" alt="" src="https://tse1.mm.bing.net/th?id=OIP.qk7iXespf9iosHsgmgbavgHaJI&pid=Api&P=0&h=180"> <a href="">Địa chỉ</a>
                            <img style="display:block  ;width: 30px;height: 30px" alt="" src="https://tse4.mm.bing.net/th?id=OIP.s1PwgBuxQPEAEYeRug1O7QHaFK&pid=Api&P=0&h=180"> <a  style="display: inline;" href="">Đơn hàng</a>
                             <p>Setting</p>
                             <img style="width: 30px;height: 30px" alt="" src="https://tse2.mm.bing.net/th?id=OIP.Vw7QDNjWGn4vWJAfak0NEwAAAA&pid=Api&P=0&h=180"><a href="">Đổi mật khẩu</a><br/>
                            <img style="width: 30px;height: 30px" alt="" src="https://tse1.mm.bing.net/th?id=OIP.USqPLI2np3nbvH-uDw3ZMwHaFj&pid=Api&P=0&h=180"> <a href="">Kiểm tra tài khoản</a><br/>
                             <img style="width: 30px;height: 30px" alt="" src="https://tse3.mm.bing.net/th?id=OIP.DkBaqViOOa3qLBTWlhRj_gAAAA&pid=Api&P=0&h=180"><a href="">Thông báo</a><br/>
                            <img style="width: 30px;height: 30px" alt="" src="https://tse2.mm.bing.net/th?id=OIP.JVwi15FNi4DdHxY1beOImQHaFt&pid=Api&P=0&h=180"> <a href="">Kho Voucher</a><br/>
                             <img style="width: 30px;height: 30px" alt="" src="https://i.pinimg.com/originals/a4/7a/26/a47a26448e9425349065ca87217972d7.jpg"><a href="">Shop xu</a><br/>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>User Id</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${sessionScope.acc.username}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Nguyễn Khánh Duy</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>nguyenkhanhduy11103@gmail.com</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>0867994730</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Profession</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Manager Account</p>
                                            </div>
                                        </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Experience</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Hourly Rate</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>10$/hr</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Total Projects</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>230</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>English Level</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Availability</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>6 months</p>
                                            </div>
                                        </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Your Bio</label><br/>
                                        <p>Your detail description</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
        
        <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>