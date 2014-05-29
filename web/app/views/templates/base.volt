<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
		<title>{{ title }} - bitPin</title>

		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        {{ stylesheet_link('css/bootstrap/bootstrap.min.css') }}
        {{ stylesheet_link('css/icomoon/icomoon-social.css') }}
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

        {{ stylesheet_link('css/leaflet.css') }}
		<!--[if lte IE 8]> {{ stylesheet_link('css/leaflet.ie.css') }} <![endif]-->
		{{ stylesheet_link('css/main-orange.css') }}
		{{ javascript_include('js/modernizr/modernizr-2.6.2-respond-1.1.0.min.js') }}
	</head>
	<body>
		<!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        
        {% include "partials/main_menu.volt" %}

		{{ content() }}

	   	{% include "partials/footer.volt" %}

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
        {{ javascript_include('js/jquery/jquery.fitvids.js') }}
		{{ javascript_include('js/jquery/jquery.sequence-min.js') }}
 		{{ javascript_include('js/jquery/jquery.bxslider.js') }}
        {{ javascript_include('js/bootstrap/bootstrap.min.js') }}
        {{ javascript_include('js/main-menu.js') }}
        {{ javascript_include('js/template.js') }}
	</body>
</html>