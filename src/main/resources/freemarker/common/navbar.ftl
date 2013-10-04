<!-- NAVBAR
================================================== -->
<div class="masthead">
    <h3 class="muted"><img src="<@spring.url '/resources/img/logo.png'/>"/></h3>
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <ul class="nav">
                    <li <#if activeNav == "home">class="active"</#if>><a href="<@spring.url '/'/>">Home</a></li>
                    <li <#if activeNav == "order">class="active"</#if>><a href="<@spring.url '/pizza'/>">Order</a></li>
                </ul>
            </div>
        </div>
    </div><!-- /.navbar -->
</div>