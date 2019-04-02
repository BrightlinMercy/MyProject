<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style>
@import
	url(http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700)
	;


body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 1.6;
	text-align: left;
	background-image: url("${cr}/resources/images/white.jpg");
}

a:hover {
	text-decoration: none;
}
/*.post { border-bottom:1px solid #DDD }*/
.post-title {
	color: red;
}
/*.post-header-line { border-top:1px solid #DDD; border-bottom:1px solid #DDD;}*/
.post-content {
	border-top: 1px solid #DDD;
	padding-bottom: 15px;
	padding-top: 15px;
}

/*mail list*/
ul.mail-list {
	padding: 0;
	margin: 0;
	list-style: none;
	/*margin-top:30px;*/
}

ul.mail-list li a {
	display: block;
	border-bottom: 1px dotted #CFCFCF;
	padding: 20px;
	text-decoration: none;
}

ul.mail-list li:last-child a {
	border-bottom: none;
}

ul.mail-list li span {
	display: block;
}

ul.mail-list li span.sub-heading {
	margin-bottom: 7px;
	font-weight: 600;
	color: red;
}

ul.mail-list li span.subtopic_description {
	display: block;
	color: black;
}
</style>
<div class="container mystyle2">
	<div class="row">
		<div class="col-md-12">
			<h4 class="post-title">
				<strong>ABOUT US</strong>
			</h4>
		</div>
	</div>

	<div class="row post-content">
		<div class="content-container clearfix">
			<div class="col-md-12">

				<ul class="mail-list">
					<li><a href=""> <span class="sub-heading">Details
								of Business</span> <span class="subtopic_description">Established
								in 2000, The Card Cottage is a leading manufacturer and supplier
								of Invitation cards in India. The Card Cottage became a private
								limited company in August 2003 and has been a major player in
								the invitation card industry. Miss.Brightlin Mercy, a printing
								technocrat having more than 10 years of experience in the
								printing industry is the promoter and CMD of The Card Cottage. A
								dedicated and talented workforce is involved to introduce
								innovations in The Card Cottage.The development of invitation
								card industry has been punctuated by a series build a reputation
								for reliability and quality. The Card Cottage is steadily
								heading to become the market leader in India by subjecting
								itself to rigorous standards of quality control. With 10 years
								of experience in designing and printing, The Card Cottage has a
								full-fledged infrastructure for effective production. Card
								Cottage latest technology in printing solution enables to offer
								one stop service from design to dispatch to all its customers
								for on time delivery. To further enhance their customer service
								a 24 hours delivery system has been introduced. The Card Cottage
								specializes in Screen, Offset printing, Hot foil stamping,
								Thermography, Embossing, UV coating and all kind of invitations
								made out of suitable paper, plastic, synthetic etc.</span>
					</a></li>
					<li><a href=""> <span class="sub-heading">Our
								Strengths</span> <span class="subtopic_description">Our Company
								has strong presence in the business of Wedding Cards for nearly
								2 decades. We manufacture Wedding Cards, Greeting Cards,
								Envelopes, Letter Heads, Business Cards, Calendars, Notebooks,
								Account Books, Files, etc. We are also involved in the trading
								of the items like Screen-Offset Inks.Our extensive experience in
								the industry enables us to guage and understand the changing
								trends and growth prospects associated with the industry. "The
								Card Cottageâ€ť Brand has become a household name for Wedding
								and Greeting Cards</span>
					</a></li>
					<li><a href=""> <span class="sub-heading">Marketing
								and Sales</span> <span class="subtopic_description">Our company
								has a big Showroom for its sales in the heart of the Chennai
								City at N.S.C.Bose Road (opposite to Broadway bus terminus). The
								Company also has its own sales showrooms at Kodambakkam,
								Thiruvanmiyur, T.Nagar, Velachery, Anna Nagar and Peravalur in
								Chennai and one more at Coimbatore and also appointed
								franchisees in Tamil Nadu. The Company is in the process of
								appointing more franchisees.</span>
					</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>