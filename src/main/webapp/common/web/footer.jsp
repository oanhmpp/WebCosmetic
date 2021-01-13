<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Footer Start -->
<div class="footer">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Get in Touch</h2>
                    <div class="contact-info">
                        <p><i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA</p>
                        <p><i class="fa fa-envelope"></i>EStore@gmail.com</p>
                        <p><i class="fa fa-phone"></i>+123-456-7890</p>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Follow Us</h2>
                    <div class="contact-info">
                        <div class="social">
                            <a href=""><i class="fab fa-twitter"></i></a>
                            <a href=""><i class="fab fa-facebook-f"></i></a>
                            <a href=""><i class="fab fa-linkedin-in"></i></a>
                            <a href=""><i class="fab fa-instagram"></i></a>
                            <a href=""><i class="fab fa-youtube"></i></a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Company Info</h2>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms & Condition</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Purchase Info</h2>
                    <ul>
                        <li><a href="#">Pyament Policy</a></li>
                        <li><a href="#">Shipping Policy</a></li>
                        <li><a href="#">Return Policy</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row payment align-items-center">
            <div class="col-md-6">
                <div class="payment-method">
                    <h2>We Accept:</h2>
                    <img src="<c:url value="/resources/web/img/payment-method.png"/>" alt="Payment Method" />
                </div>
            </div>
            <div class="col-md-6">
                <div class="payment-security">
                    <h2>Secured By:</h2>
                    <img src="<c:url value="/resources/web/img/godaddy.svg"/>" alt="Payment Security" />
                    <img src="<c:url value="/resources/web/img/norton.svg"/>" alt="Payment Security" />
                    <img src="<c:url value="/resources/web/img/ssl.svg"/>" alt="Payment Security" />
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->

<!-- Footer Bottom Start -->
<div class="footer-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-6 copyright">
                <p>Copyright &copy; <a href="https://htmlcodex.com">HTML Codex</a>. All Rights Reserved</p>
            </div>

            <div class="col-md-6 template-by">
                <p>Template By <a href="https://htmlcodex.com">HTML Codex</a></p>
            </div>
        </div>
    </div>
</div>
<!-- Footer Bottom End -->

<!-- Back to Top -->
<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="<c:url value="/resources/web/lib/easing/easing.min.js"/>"></script>
<script src="<c:url value="/resources/web/lib/slick/slick.min.js"/>"></script>

<!-- Template Javascript -->
<script src="<c:url value="/resources/web/js/main.js"/>"></script>

<script>

    // script bên addtocart
    $(function () {
        getSize();
        function getSize() {
            $.ajax({
                url: '/getSize',
                type: 'GET',
                data: {},
                success: function (result) {
                    $('#numberProduct').html(result);
                },
                error: function (error) {
                    alert("Error")
                }
            });
        }
        // add to cart
        $('.btnAddToCart').click(function (e) {
            e.preventDefault(); // k load lai trang
            var idProduct = $(this).find("span").html();
            $.ajax({
                url: '/addToCart',
                type: 'GET',
                data: {
                    idProduct: idProduct,
                },
                success: function (result) {
                    alert(result);
                    getSize();
                },
                error: function (error) {
                    alert("Error")
                }
            });
        });

        // chuc nang mua ngay
        $('.btnBuyNow').click(function (e) {
            e.preventDefault(); // k load lai trang
            var idProduct = $('.idProduct').html();
            alert(idProduct)
            $.ajax({
                url: '/addToCart',
                type: 'GET',
                data: {
                    idProduct: idProduct,
                },
                success: function (result) {
                    if(!result){
                        alert("You need to login")
                    } else {
                        window.location.href = "/cart";
                    }
                },
                error: function (error) {
                    alert("Error")
                }
            });
        });

        // tang san pham
        $('.btn-plus').click(function (e){
            $.ajax({
                url: "/increase",
                method: 'GET',
                data: {
                    id : $(this).find("span").html()
                },
                success: function (result){
                window.location.reload();
                },
                error: function (error){
                    alert("Error")
                }
            })
        });

        //giam san pham
        $('.btn-minus').click(function (e){
            $.ajax({
                url: "/decrease",
                method: 'GET',
                data: {
                    id : $(this).find("span").html()
                },
                success: function (result){
                    window.location.reload();
                },
                error: function (error){
                    alert("Error")
                }
            })
        });

        // nut delete
        $('.btn_delete').click(function (e){
            $.ajax({
                url: "/cart/delete",
                method: 'GET',
                data: {
                    id : $(this).find("span").html()
                },
                success: function (result){
                    window.location.reload();
                },
                error: function (error){
                    alert("Error")
                }
            })
        });

        // chuc nang tim kiem
        $('#textFind').keyup(function (e){
            $("#f").empty();

            var key = $(".key").val()
            $.ajax({
                url: "/search",
                method: 'GET',
                dataType: "json",
                data: {
                    key : key
                },
                success: function (data){
                    $("#f").empty();
                    data.forEach(function(item, i){
                        $("#f").append("<a href='/productDetail?idProduct="+item.idProduct+"' class='list-group-item'>"+ item.nameProduct +"</a>");
                    });
                },
                error: function (error){
                    alert("Error")
                }
            })
        });

        $("#f").on("click","li", function () {
            var text = $(this).text();
            $("#textFind").val(text);
            $("#f").empty();
        })

    });
</script>

