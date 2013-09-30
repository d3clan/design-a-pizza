<!DOCTYPE html>
<html>
<head>
    <title>Design a pizza!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!– Bootstrap –>
    <link href="<@spring.url '/resources/css/bootstrap.css'/>" rel="stylesheet" media="screen">
    <link href="<@spring.url '/resources/css/bootstrap-responsive.css'/>" rel="stylesheet" media="screen">
    <link href="<@spring.url '/resources/css/styles.css'/>" rel="stylesheet" media="screen">
</head>
<body>

<!-- NAVBAR
================================================== -->
<div class="navbar-wrapper">
    <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
    <div class="container">

        <div class="navbar navbar-inverse">
            <div class="navbar-inner">
                <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="#">Project name</a>
                <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                        <!-- Read about Bootstrap dropdowns at http://twbs.github.com/bootstrap/javascript.html#dropdowns -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li class="nav-header">Nav header</li>
                                <li><a href="#">Separated link</a></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->

    </div> <!-- /.container -->
</div><!-- /.navbar-wrapper -->

<!-- CAROUSEL -->

<div id="myCarousel" class="carousel slide">
    <div class="carousel-inner">
        <div class="item active">
            <img src="<@spring.url '/resources/img/slide-01.jpg'/>" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Scrumptious pizza.</h1>
                    <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <a class="btn btn-large btn-primary" href="#">Sign up today</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="<@spring.url '/resources/img/slide-02.jpg'/>" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Made to order in our traditional oven</h1>
                    <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <a class="btn btn-large btn-primary" href="#">Learn more</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="<@spring.url '/resources/img/slide-03.jpg'/>" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Fast delivery</h1>
                    <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <a class="btn btn-large btn-primary" href="#">Browse gallery</a>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="span4">
            <img class="img-circle" data-src="<@spring.url '/resources/js/holder.js/140x140'/>">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
        </div><!-- /.span4 -->
        <div class="span4">
            <img class="img-circle" data-src="<@spring.url '/resources/js/holder.js/140x140'/>">
            <h2>Heading</h2>
            <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
        </div><!-- /.span4 -->
        <div class="span4">
            <img class="img-circle" data-src="<@spring.url '/resources/js/holder.js/140x140'/>">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="featurette">
        <img class="featurette-image pull-right" src="<@spring.url '/resources/img/browser-icon-chrome.png'/>">
        <h2 class="featurette-heading">First featurette headling. <span class="muted">It'll blow your mind.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
    </div>

    <hr class="featurette-divider">

    <div class="featurette">
        <img class="featurette-image pull-left" src="<@spring.url '/resources/img/browser-icon-firefox.png'/>">
        <h2 class="featurette-heading">Oh yeah, it's that good. <span class="muted">See for yourself.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
    </div>

    <hr class="featurette-divider">

    <div class="featurette">
        <img class="featurette-image pull-right" src="<@spring.url '/resources/img/browser-icon-safari.png'/>">
        <h2 class="featurette-heading">And lastly, this one. <span class="muted">Checkmate.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
    </div>

    <hr class="featurette-divider">

    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>

</div>

<script src="<@spring.url '/resources/js/jquery.js"'/>></script>
<script src="<@spring.url '/resources/js/transition.js'/>"></script>
<script src="<@spring.url '/resources/js/alert.js'/>"></script>
<script src="<@spring.url '/resources/js/modal.js'/>"></script>
<script src="<@spring.url '/resources/js/dropdown.js'/>"></script>
<script src="<@spring.url '/resources/js/scrollspy.js'/>"></script>
<script src="<@spring.url '/resources/js/tab.js'/>"></script>
<script src="<@spring.url '/resources/js/tooltip.js'/>"></script>
<script src="<@spring.url '/resources/js/popover.js'/>"></script>
<script src="<@spring.url '/resources/js/collapse.js'/>"></script>
<script src="<@spring.url '/resources/js/carousel.js'/>"></script>
<script src="<@spring.url '/resources/js/typeahead.js'/>"></script>
<script>
    !function ($) {
        $(function(){
            // carousel demo
            $('#myCarousel').carousel()
        })
    }(window.jQuery)
</script>
<script src="<@spring.url '/resources/js/holder.js'/>"></script>
</body>
</html>