<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
		<title>{{ title }} - {{ subtitle }}</title>

		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        {{ stylesheet_link('css/bootstrap/bootstrap.min.css') }}
        {{ stylesheet_link('css/icomoon/icomoon-social.css') }}
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

        {{ stylesheet_link('css/leaflet.css') }}
		<!--[if lte IE 8]>
			{{ stylesheet_link('css/leaflet.ie.css') }}
		<![endif]-->
		{{ stylesheet_link('css/main-orange.css') }}
		{{ javascript_include('js/modernizr/modernizr-2.6.2-respond-1.1.0.min.js') }}
	</head>
	<body>
		<!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <!-- Navigation & Logo-->
        <div class="mainmenu-wrapper">
	        <div class="container">
	        	<div class="menuextras">
					<div class="extras">
						<ul>
							<li class="shopping-cart-items"><i class="glyphicon glyphicon-shopping-cart icon-white"></i> <a href="page-shopping-cart.html"><b>3 items</b></a></li>
							<li>
								<div class="dropdown choose-country">
									<a class="#" data-toggle="dropdown" href="#"><img src="img/flags/gb.png" alt="Great Britain"> UK</a>
									<ul class="dropdown-menu" role="menu">
										<li role="menuitem"><a href="#"><img src="img/flags/us.png" alt="United States"> US</a></li>
										<li role="menuitem"><a href="#"><img src="img/flags/de.png" alt="Germany"> DE</a></li>
										<li role="menuitem"><a href="#"><img src="img/flags/es.png" alt="Spain"> ES</a></li>
									</ul>
								</div>
							</li>
			        		<li><a href="page-login.html">Login</a></li>
			        	</ul>
					</div>
		        </div>
		        <nav id="mainmenu" class="mainmenu">
					<ul>
						<li class="logo-wrapper"><a href="index.html"><img src="http://i.imgur.com/aiD8EXw.png" width="100" alt="bitPin">  bitPin</a></li>
						<li class="active">
							<a href="index.html">Home</a>
						</li>
						<li>
							<a href="features.html">Features</a>
						</li>
						<li class="has-submenu">
							<a href="#">Pages +</a>
							<div class="mainmenu-submenu">
								<div class="mainmenu-submenu-inner"> 
									<div>
										<h4>Homepage</h4>
										<ul>
											<li><a href="index.html">Homepage (Sample 1)</a></li>
											<li><a href="page-homepage-sample.html">Homepage (Sample 2)</a></li>
										</ul>
										<h4>Services & Pricing</h4>
										<ul>
											<li><a href="page-services-1-column.html">Services/Features (Rows)</a></li>
											<li><a href="page-services-3-columns.html">Services/Features (3 Columns)</a></li>
											<li><a href="page-services-4-columns.html">Services/Features (4 Columns)</a></li>
											<li><a href="page-pricing.html">Pricing Table</a></li>
										</ul>
										<h4>Team & Open Vacancies</h4>
										<ul>
											<li><a href="page-team.html">Our Team</a></li>
											<li><a href="page-vacancies.html">Open Vacancies (List)</a></li>
											<li><a href="page-job-details.html">Open Vacancies (Job Details)</a></li>
										</ul>
									</div>
									<div>
										<h4>Our Work (Portfolio)</h4>
										<ul>
											<li><a href="page-portfolio-2-columns-1.html">Portfolio (2 Columns, Option 1)</a></li>
											<li><a href="page-portfolio-2-columns-2.html">Portfolio (2 Columns, Option 2)</a></li>
											<li><a href="page-portfolio-3-columns-1.html">Portfolio (3 Columns, Option 1)</a></li>
											<li><a href="page-portfolio-3-columns-2.html">Portfolio (3 Columns, Option 2)</a></li>
											<li><a href="page-portfolio-item.html">Portfolio Item (Project) Description</a></li>
										</ul>
										<h4>General Pages</h4>
										<ul>
											<li><a href="page-about-us.html">About Us</a></li>
											<li><a href="page-contact-us.html">Contact Us</a></li>
											<li><a href="page-faq.html">Frequently Asked Questions</a></li>
											<li><a href="page-testimonials-clients.html">Testimonials & Clients</a></li>
											<li><a href="page-events.html">Events</a></li>
											<li><a href="page-404.html">404 Page</a></li>
											<li><a href="page-sitemap.html">Sitemap</a></li>
											<li><a href="page-login.html">Login</a></li>
											<li><a href="page-register.html">Register</a></li>
											<li><a href="page-password-reset.html">Password Reset</a></li>
											<li><a href="page-terms-privacy.html">Terms & Privacy</a></li>
											<li><a href="page-coming-soon.html">Coming Soon</a></li>
										</ul>
									</div>
									<div>
										<h4>eShop</h4>
										<ul>
											<li><a href="page-products-3-columns.html">Products listing (3 Columns)</a></li>
											<li><a href="page-products-4-columns.html">Products listing (4 Columns)</a></li>
											<li><a href="page-products-slider.html">Products Slider</a></li>
											<li><a href="page-product-details.html">Product Details</a></li>
											<li><a href="page-shopping-cart.html">Shopping Cart</a></li>
										</ul>
										<h4>Blog</h4>
										<ul>
											<li><a href="page-blog-posts.html">Blog Posts (List)</a></li>
											<li><a href="page-blog-post-right-sidebar.html">Blog Single Post (Right Sidebar)</a></li>
											<li><a href="page-blog-post-left-sidebar.html">Blog Single Post (Left Sidebar)</a></li>
											<li><a href="page-news.html">Latest & Featured News</a></li>
										</ul>
									</div>
								</div><!-- /mainmenu-submenu-inner -->
							</div><!-- /mainmenu-submenu -->
						</li>
						<li>
							<a href="credits.html">Credits</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- End Navigation & Logo-->


		 <!-- Homepage Slider -->
        <div class="homepage-slider">
        	<div id="sequence">
				<ul class="sequence-canvas">
					<!-- Slide 1 -->
					<li class="bg4">
						<!-- Slide Title -->
						<h2 class="title">The future of payments: bitPin</h2>
						<!-- Slide Text -->
						<h3 class="subtitle">
							bitPin allows for easy, secure and anonymous transactions in stores all around the globe! 
							<br /><br />
							Manage your money via web or mobile!
							<br /><br />
							Easily transfer funds to other bitPin cards or crypto addresses!
						</h3>
						<!-- Slide Image -->
						<img class="slide-img" src="img/homepage-slider/slide1.png" alt="Slide 1" />
					</li>
					<!-- End Slide 1 -->
				</ul>
			</div>
        </div>
        <!-- End Homepage Slider -->

        <!-- Press Coverage -->
        <div class="section">
	    	<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-18 text-center">
						<a href="#" class="btn get-bitpin">Get bitPin now!</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Press Coverage -->

		<!-- Services -->
        <div class="section">
	        <div class="container">
	        	<div class="row">
	        		<div class="col-md-4 col-sm-6">
	        			<div class="service-wrapper">
		        			<img src="img/service-icon/diamond.png" alt="Service 1">
		        			<h3>Easy to use</h3>
		        			<p>With easy access to our web and mobile application, nothing can stop you from spending your money.</p>
		        			<a href="#" class="btn">Read more</a>
		        		</div>
	        		</div>
	        		<div class="col-md-4 col-sm-6">
	        			<div class="service-wrapper">
		        			<img src="img/service-icon/ruler.png" alt="Service 2">
		        			<h3>Safe & Secure</h3>
		        			<p>Your bitPin is secured with an RSA certificate so nobody can come between you and our servers.</p>
		        			<a href="#" class="btn">Read more</a>
		        		</div>
	        		</div>
	        		<div class="col-md-4 col-sm-6">
	        			<div class="service-wrapper">
		        			<img src="img/service-icon/box.png" alt="Service 3">
		        			<h3>Completely anonymous</h3>
		        			<p>We will store no information about your transaction history unless you tell us to. Not even the NSA will know what you bought.</p>
		        			<a href="#" class="btn">Read more</a>
		        		</div>
	        		</div>
	        	</div>
	        </div>
	    </div>
	    <!-- End Services -->


	    <!-- Call to Action Bar -->
	    <div class="section section-white">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="calltoaction-wrapper">
							<h3>We don't ship to your area? Create your own bitPin!</h3> <a href="http://www.dragdropsite.com" class="btn btn-orange">See how!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Call to Action Bar -->

		<!-- Testimonials -->
	    <div class="section">
			<div class="container">
				<h2>Testimonials</h2>
				<div class="row">
					<!-- Testimonial -->
					<div class="testimonial col-md-4 col-sm-6">
						<!-- Author Photo -->
						<div class="author-photo">
							<img src="img/user1.jpg" alt="Author 1">
						</div>
						<div class="testimonial-bubble">
							<blockquote>
								<!-- Quote -->
								<p class="quote">
		                            "Very nice. Many wow. Such bitPin!"
                        		</p>
                        		<!-- Author Info -->
                        		<cite class="author-info">
                        			- Internet Doge,<br>Creator of <a href="#">DogeCoin</a>
                        		</cite>
                        	</blockquote>
                        	<div class="sprite arrow-speech-bubble"></div>
                        </div>
                    </div>
                    <!-- End Testimonial -->
                    <div class="testimonial col-md-4 col-sm-6">
						<div class="author-photo">
							<img src="img/user5.jpg" alt="Author 2">
						</div>
						<div class="testimonial-bubble">
							<blockquote>
								<p class="quote">
		                            "My hair is white but also a bit blue. It's very short too."
                        		</p>
                        		<cite class="author-info">
                        			- Punk lady
                        		</cite>
                        	</blockquote>
                        	<div class="sprite arrow-speech-bubble"></div>
                        </div>
                    </div>
					<div class="testimonial col-md-4 col-sm-6">
						<div class="author-photo">
							<img src="img/user2.jpg" alt="Author 3">
						</div>
						<div class="testimonial-bubble">
							<blockquote>
								<p class="quote">
		                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
                        		</p>
                        		<cite class="author-info">
                        			- Victoria,<br>Latin teacher at <a href="#">Oxford University</a>
                        		</cite>
                        	</blockquote>
                        	<div class="sprite arrow-speech-bubble"></div>
                        </div>
                    </div>
				</div>
			</div>
	    </div>
	    <!-- End Testimonials -->

		<!-- Our Clients -->
	    <div class="section">
	    	<div class="container">
	    		<h2>Our Clients</h2>
				<div class="clients-logo-wrapper text-center row">
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/canon.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/cisco.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/dell.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/ea.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/ebay.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/facebook.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/google.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/hp.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/microsoft.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/mysql.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/sony.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/yahoo.png" alt="Client Name"></a></div>
				</div>
			</div>
	    </div>
	    <!-- End Our Clients -->

	    <!-- Footer -->
	    <div class="footer">
	    	<div class="container">
		    	<div class="row">
		    		<div class="col-footer col-md-4 col-xs-6">
		    			<h3>Navigate</h3>
		    			<ul class="no-list-style footer-navigate-section">
		    				<li><a href="page-blog-posts.html">Blog</a></li>
		    				<li><a href="page-portfolio-3-columns-2.html">Portfolio</a></li>
		    				<li><a href="page-products-3-columns.html">eShop</a></li>
		    				<li><a href="page-services-3-columns.html">Services</a></li>
		    				<li><a href="page-pricing.html">Pricing</a></li>
		    				<li><a href="page-faq.html">FAQ</a></li>
		    			</ul>
		    		</div>
		    		
		    		<div class="col-footer col-md-5 col-xs-6">
		    			<h3>Contacts</h3>
		    			<p class="contact-us-details">
	        				<b>Address:</b> Zernikedreef 11, 2333 CK, Leiden, The Netherlands<br/>
	        				<b>Phone:</b> +31 070 3688341<br/>
	        				<b>Email:</b> <a href="mailto:bitpin@steamep.com">bitpin@steamep.com</a>
	        			</p>
		    		</div>
		    		<div class="col-footer col-md-3 col-xs-6">
		    			<h3>Stay Connected</h3>
		    			<ul class="footer-stay-connected no-list-style">
		    				<li><a href="#" class="facebook"></a></li>
		    				<li><a href="#" class="twitter"></a></li>
		    			</ul>
		    		</div>
		    	</div>
		    	<div class="row">
		    		<div class="col-md-12">
		    			<div class="footer-copyright">&copy; 2014 bitPin. All rights reserved.</div>
		    		</div>
		    	</div>
		    </div>
	    </div>

        <!-- Javascripts -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>

        {{ javascript_include('js/jquery/jquery.fitvids.js') }}
		{{ javascript_include('js/jquery/jquery.sequence-min.js') }}
 		{{ javascript_include('js/jquery/jquery.bxslider.js') }}
        {{ javascript_include('js/bootstrap/bootstrap.min.js') }}

        {{ javascript_include('js/main-menu.js') }}
        {{ javascript_include('js/template.js') }}

		{{ content() }}
	</body>
</html>