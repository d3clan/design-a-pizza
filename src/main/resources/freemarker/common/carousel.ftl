<!-- CAROUSEL -->
<div id="myCarousel" class="carousel slide">
    <div class="carousel-inner custom-carousel-height">
        <div class="item active">
            <img src="<@spring.url '/resources/img/slide-01.jpg'/>" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Scrumptious pizza.</h1>
                    <p class="lead">You won't find better.</p>
                    <a class="btn btn-warning" href="<@spring.url '/pizza'/>">Order Now</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="<@spring.url '/resources/img/slide-02.jpg'/>" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Traditional oven</h1>
                    <p class="lead">No gas here. It's all real.</p>
                    <a class="btn btn-warning" href="<@spring.url '/pizza'/>">Order Now</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="<@spring.url '/resources/img/slide-03.jpg'/>" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Fast delivery</h1>
                    <p class="lead">State of the art delivery methods.</p>
                    <a class="btn btn-warning" href="<@spring.url '/pizza'/>">Order Now</a>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>
<script>
    function carousel($) {
        $(function(){
            $('#myCarousel').carousel()
        })
    }(window.jQuery)
</script>