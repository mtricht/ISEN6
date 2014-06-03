<!-- Navigation & Logo-->
    <div class="mainmenu-wrapper">
        <div class="container">
        	<br />
	        <nav id="mainmenu" class="mainmenu">
				<ul>
					<li class="logo-wrapper"><a href="{{ url('') }}">{{ image('img/logo.png', 'width': 100) }}  bitPin</a></li>
					<li class="active">{{ link_to('', 'Home') }}</li>
					<li>{{ link_to('features', 'Features') }}</li>
					<li>{{ link_to('login', 'Login') }}</li>
				</ul>
			</nav>
		</div>
	</div>
<!-- End Navigation & Logo-->