<@page title="Design-a pizza &#10102; Choose your base size" activeNav="order">
<div class="container">
    <div class="hero-unit">
        <h1>Design your pizza!</h1>
    </div>
</div>
<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="span4">
            <h2>Choose base size</h2>
            <select id="selectable-size" size="${sizes?size}" class="selectpicker show-tick" data-style="btn-success">
                <#list sizes as size>
                    <option value="${size.id}" <#if size_index == 0>selected="selected"</#if>>${size.description}</option>
                </#list>
            </select>
        </div>
        <!-- /.span4 -->
        <div class="span4">
            <h2>Choose toppings</h2>
            <select id="selectable-toppings" size="${toppings?size}" class="selectpicker show-tick" multiple="multiple" data-style="btn-success">
                <#list toppings as topping>
                    <option value="${topping.id}">${topping.description} ${topping.formattedPrice}</option>
                </#list>
            </select>
        </div>
        <!-- /.span4 -->
        <div class="span4">
            <h2>Your pizza (<span id="pizza-price">&pound;0.00</span>)</h2>
            <h4>Pizza base size: <span id="pizza-base-size">Small (25 cm)</span></h4>
            <button class="btn btn-danger" type="button">Order now</button>
            <hr/>
            <h3>Toppings</h3>
            <ul id="pizza-toppings">
            </ul>
            </div>
        </div>
     </div>
<script type="text/javascript">
    $(function() {
        $("#selectable-size").change(function() {
            var pizzaSizeId = $("#selectable-size option:selected").attr('value');
            var pizzaSizeDesc = $("#selectable-size option:selected").text();
            $.getJSON( "<@spring.url '/pizza/toppings/'/>" + pizzaSizeId, function() {
                console.log( "success" );
            }).done(function(data) {
                var options = $("#selectable-toppings");
                $("#pizza-base-size").empty().append(pizzaSizeDesc);
                options.empty();
                $.each(data, function(i, item) {
                    options.append($("<option />").val(item.id).text(item.description  + ' ' +  item.formattedPrice));
                });
                updatePrice();
            }).fail(function() {
                console.log( "error" );
            }).always(function() {
                console.log( "complete");
            });
        }),
        $("#selectable-toppings").change(function() {
            updatePrice();
        });
    });
    function updatePrice() {
        var pizzaSizeId = $("#selectable-size option:selected").attr('value');
        var toppings = $("#selectable-toppings").val();

        $.ajax({
            type: "POST",
            url: "<@spring.url '/pizza/update'/>",
            traditional: true,
            data: { pizzaSizeId: pizzaSizeId, toppingIds: toppings }
        }).done(function( msg ) {
            $("#pizza-price").text(msg.formattedPrice);
            $("#pizza-base-size").text(msg.baseSize.descripton);
            $("#pizza-toppings").empty();
            $.each(msg.toppings, function(index, item) {
                $("#pizza-toppings").append($("<li />").text(item.description  + ' ' +  item.formattedPrice));
            });
       });
    };
</script>
</@page>