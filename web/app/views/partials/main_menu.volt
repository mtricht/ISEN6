<!-- Navigation & Logo-->
    <div class="mainmenu-wrapper">
        <div class="container">
        	<br />
	        <nav id="mainmenu" class="mainmenu">
				<ul>
					<li class="logo-wrapper"><a href="{{ url('') }}">{{ image('img/logo.png', 'width': 100) }}  bitPin</a></li>
					<li{% if router.getRewriteUri() == '/' %}{{ ' class="active"'}}{% endif %}>{{ link_to('', 'Home') }}</li>
					{% if session.has('login') %}
					<li{% if router.getRewriteUri() == '/panel' %}{{ ' class="active"'}}{% endif %}>{{ link_to('panel', 'Panel') }}</li>
					<li>{{ link_to('logout', 'Logout') }}</li>
					{% else %}
					<li{% if router.getRewriteUri() == '/login' %}{{ ' class="active"'}}{% endif %}>{{ link_to('login', 'Login') }}</li>
					{% endif %}
				</ul>
			</nav>
		</div>
	</div>
<!-- End Navigation & Logo-->