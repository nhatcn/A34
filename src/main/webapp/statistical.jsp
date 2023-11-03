<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zxx">
    <head>
        <!-- Meta Tag -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name='copyright' content=''>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Title Tag  -->
        <title>Eshop - eCommerce HTML5 Template.</title>
        <!-- Favicon -->
        <link rel="icon" type="image/png" href="images/favicon.png">
        <!-- Web Font -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

        <!-- StyleSheet -->

        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Magnific Popup -->


        <!-- Eshop StyleSheet -->

        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    </head>

    <body class="js">

        <!-- Preloader -->
        <div class="preloader">
            <div class="preloader-inner">
                <div class="preloader-icon">
                    <span></span>
                    <span></span>
                </div>
            </div>
        </div>
        <!-- End Preloader -->

        <!-- Header -->
        <header class="header shop">
            <!-- Topbar -->

            <!-- Header Inner -->
            <div class="header-inner">
                <div class="container">
                    <div class="cat-nav-head">
                        <div class="row">
                            <div class="col-12">
                                <div class="menu-area">
                                    <!-- Main Menu -->
                                    <nav class="navbar navbar-expand-lg">
                                        <div class="navbar-collapse">	
                                            <div class="nav-inner">	
                                                <ul class="nav main-menu menu navbar-nav">
                                                    <li class="active"><a href="home">Home</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                    </nav>
                                    <!--/ End Main Menu -->	
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/ End Header Inner -->
        </header>
        <c:if test="${requestScope.name == c}">
            <form action="statistical">
                <input type="text" name="year" placeholder="year.." id="year" value="${requestScope.ipyear}"/>
                <button type="submit" class="btn-dark" >View</button>
            </form>
        </c:if>
        <c:if test="${requestScope.name != c}">
            <form action="statistical" method="post">
                <input type="text" name="year" placeholder="year.." id="year" value="${requestScope.ipyear}"/>
                <button type="submit" class="btn-dark" >View</button>
            </form>
        </c:if>
        <form action="statistical" >
            <button class="btn-dark" type="submit">Statistical by Amount</button>
        </form>
        <form action="statistical" method="post">
            <button class="btn-dark" type="submit">Statistical by Quantity</button>
        </form>

        <!--/ End Header -->
        <canvas id="orderChart" width="400" height="200"></canvas>

        <script>
            var labels = [];
            var data = [];
            <c:set var="c" value="Total Amount"/>
            <c:if test="${requestScope.name == c}">
                <c:forEach items="${monthlyTotals}" var="monthlyTotal">
            labels.push("${monthlyTotal.orderDate}");
            data.push(${monthlyTotal.total});
                </c:forEach>
            </c:if>
            //--------------------------------  
            <c:set var="e" value="Quantity Amount"/>
            <c:if test="${requestScope.name == e}">
                <c:forEach items="${monthlyTotals}" var="monthlyTotal">
            labels.push("${monthlyTotal.orderDate}");
            data.push(${monthlyTotal.quantity});
                </c:forEach>
            </c:if>
           
            <c:if test="${not empty monthlyTotals}">
            var ctx = document.getElementById('orderChart').getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: [{
                            label: "${requestScope.name}",
                            data: data,
                            borderColor: 'rgba(75, 192, 192, 1)',
                            borderWidth: 2,
                            fill: false
                        }]
                },
                options: {
                    scales: {
                        x: [
                            {
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Month'
                                }
                            }
                        ],
                        y: [
                            {
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Total'
                                },
                                beginAtZero: true
                            }
                        ]
                    }
                }
            });
            </c:if>

        </script>
        <br><!-- comment -->
        <br><!-- comment -->
        <br>

        <!-- Breadcrumbs -->

        <!-- Modal end -->

        <!-- Start Footer Area -->

        <!-- /End Footer Area -->

        <!-- Jquery -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.0.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <!-- Popper JS -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap JS -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Color JS -->
        <script src="js/colors.js"></script>
        <!-- Slicknav JS -->
        <script src="js/slicknav.min.js"></script>
        <!-- Owl Carousel JS -->
        <script src="js/owl-carousel.js"></script>
        <!-- Magnific Popup JS -->
        <script src="js/magnific-popup.js"></script>
        <!-- Fancybox JS -->
        <script src="js/facnybox.min.js"></script>
        <!-- Waypoints JS -->
        <script src="js/waypoints.min.js"></script>
        <!-- Countdown JS -->
        <script src="js/finalcountdown.min.js"></script>
        <!-- Nice Select JS -->
        <script src="js/nicesellect.js"></script>
        <!-- Ytplayer JS -->
        <script src="js/ytplayer.min.js"></script>
        <!-- Flex Slider JS -->
        <script src="js/flex-slider.js"></script>
        <!-- ScrollUp JS -->
        <script src="js/scrollup.js"></script>
        <!-- Onepage Nav JS -->
        <script src="js/onepage-nav.min.js"></script>
        <!-- Easing JS -->
        <script src="js/easing.js"></script>
        <!-- Active JS -->
        <script src="js/active.js"></script>
    </body>
</html>