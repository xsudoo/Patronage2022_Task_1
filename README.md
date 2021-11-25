<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="_Patronage_2022_Task_1_Parking__0"></a><em>Patronage 2022 Task 1 Parking</em></h1>
<p class="has-line-data" data-line-start="2" data-line-end="3"><em>This is a simple REST Api that simulates parking management software. With this you can create new users, create parking spaces, add and remove reservations</em></p>
<h2 class="code-line" data-line-start=4 data-line-end=5 ><a id="Features_4"></a>Features</h2>
<ul>
<li class="has-line-data" data-line-start="6" data-line-end="7">Adding and viewing customers</li>
<li class="has-line-data" data-line-start="7" data-line-end="8">Add and view parking spaces</li>
<li class="has-line-data" data-line-start="8" data-line-end="9">Adding and deleting reservations</li>
<li class="has-line-data" data-line-start="9" data-line-end="10">Wyszukiwanie rezerwacji po kliencie</li>
<li class="has-line-data" data-line-start="10" data-line-end="11">Search for free parking spaces</li>
</ul>
<h2 class="code-line" data-line-start=13 data-line-end=14 ><a id="Tech_13"></a>Tech</h2>
<ul>
<li class="has-line-data" data-line-start="15" data-line-end="16"><a href="https://spring.io/">Spring</a> - 2.6.0</li>
<li class="has-line-data" data-line-start="16" data-line-end="18"><a href="https://www.oracle.com/java/">Java</a> - 11</li>
</ul>
<h2 class="code-line" data-line-start=18 data-line-end=19 ><a id="Build__Run_18"></a>Build / Run</h2>
<p class="has-line-data" data-line-start="20" data-line-end="21">App requires <a href="https://www.oracle.com/java/">Java</a> v11+ to run.</p>
<p class="has-line-data" data-line-start="22" data-line-end="24">Download latest comit, if you are using IDE run ParkingApplication, if not just click on Parking-0.0.1-RELEASE.jar<br>
Using a terminal with the curl command you can send requests, or using <a href="https://www.postman.com/">Postman</a> (a collection of requests in a directory)</p>
<h2 class="code-line" data-line-start=25 data-line-end=26 ><a id="Endpoints_25"></a>Endpoints</h2>
<blockquote>
<h5 class="code-line" data-line-start=27 data-line-end=28 ><a id="POST_27"></a>POST</h5>
</blockquote>
<p class="has-line-data" data-line-start="28" data-line-end="29">Add single customer</p>
<pre><code class="has-line-data" data-line-start="30" data-line-end="32">localhost:8080/customer
</code></pre>
<p class="has-line-data" data-line-start="32" data-line-end="36">Body raw (json)<br>
{<br>
“name”: “Jhon”<br>
}</p>
<h5 class="code-line" data-line-start=37 data-line-end=38 ><a id="GET_37"></a>GET</h5>
<p class="has-line-data" data-line-start="38" data-line-end="39">Get all customer :</p>
<pre><code class="has-line-data" data-line-start="40" data-line-end="42">localhost:8080/customer
</code></pre>
<h5 class="code-line" data-line-start=42 data-line-end=43 ><a id="POST_42"></a>POST</h5>
<p class="has-line-data" data-line-start="43" data-line-end="44">Add new parking spot</p>
<pre><code class="has-line-data" data-line-start="45" data-line-end="47">localhost:8080/spot
</code></pre>
<p class="has-line-data" data-line-start="47" data-line-end="53">Body raw (json)<br>
{<br>
“number”: 1,<br>
“storey”: 1,<br>
“isSpotForDisabled”: false<br>
}</p>
<h5 class="code-line" data-line-start=54 data-line-end=55 ><a id="GET_54"></a>GET</h5>
<p class="has-line-data" data-line-start="55" data-line-end="56">Get all spots from database</p>
<pre><code class="has-line-data" data-line-start="57" data-line-end="59">localhost:8080/spot
</code></pre>
<h5 class="code-line" data-line-start=60 data-line-end=61 ><a id="GET_60"></a>GET</h5>
<p class="has-line-data" data-line-start="61" data-line-end="62">Get all free spots from database</p>
<pre><code class="has-line-data" data-line-start="63" data-line-end="65">localhost:8080/spot/free
</code></pre>
<h5 class="code-line" data-line-start=66 data-line-end=67 ><a id="GET_66"></a>GET</h5>
<p class="has-line-data" data-line-start="67" data-line-end="68">Get spots reserved by Jhon</p>
<pre><code class="has-line-data" data-line-start="69" data-line-end="71">localhost:8080/spot?name=Jhon
</code></pre>
<h5 class="code-line" data-line-start=72 data-line-end=73 ><a id="POST_72"></a>POST</h5>
<p class="has-line-data" data-line-start="73" data-line-end="74">Add new reservation</p>
<pre><code class="has-line-data" data-line-start="75" data-line-end="77">localhost:8080/reservation
</code></pre>
<p class="has-line-data" data-line-start="77" data-line-end="82">Body raw (json)<br>
{<br>
“spotId”: 1,<br>
“customerId”: 1<br>
}</p>
<h5 class="code-line" data-line-start=83 data-line-end=84 ><a id="GET_83"></a>GET</h5>
<p class="has-line-data" data-line-start="84" data-line-end="85">Get all reservation</p>
<pre><code class="has-line-data" data-line-start="86" data-line-end="88">localhost:8080/reservation
</code></pre>
<h5 class="code-line" data-line-start=89 data-line-end=90 ><a id="DELETE_89"></a>DELETE</h5>
<p class="has-line-data" data-line-start="90" data-line-end="91">Delate reservation by ID</p>
<pre><code class="has-line-data" data-line-start="92" data-line-end="94">localhost:8080/reservation/1
</code></pre>
<h5 class="code-line" data-line-start=95 data-line-end=96 ><a id="GET_95"></a>GET</h5>
<p class="has-line-data" data-line-start="96" data-line-end="97">Get reservation by customer name</p>
<pre><code class="has-line-data" data-line-start="98" data-line-end="100">localhost:8080/reservation?name=Jhon
</code></pre>
<h2 class="code-line" data-line-start=101 data-line-end=102 ><a id="CURL_101"></a>CURL</h2>
<p class="has-line-data" data-line-start="103" data-line-end="105">Customer:<br>
Get all customer :</p>
<pre><code class="has-line-data" data-line-start="106" data-line-end="108">curl -X GET localhost:8080/customer
</code></pre>
<p class="has-line-data" data-line-start="108" data-line-end="109">Add single customer :</p>
<pre><code class="has-line-data" data-line-start="110" data-line-end="112">curl -d &quot;{\&quot;name\&quot;:\&quot;Jhon\&quot;}&quot; -H &quot;Content-Type: application/json&quot; -X POST localhost:8080/customer
</code></pre>
<p class="has-line-data" data-line-start="112" data-line-end="114">Spot:<br>
Get all spots:</p>
<pre><code class="has-line-data" data-line-start="115" data-line-end="117">curl -X GET localhost:8080/spot
</code></pre>
<p class="has-line-data" data-line-start="117" data-line-end="118">Add spot:</p>
<pre><code class="has-line-data" data-line-start="119" data-line-end="121">curl -d &quot;{\&quot;number\&quot;:1,\&quot;storey\&quot;:1,\&quot;spotForDisabled\&quot;:false}&quot; -H &quot;Content-Type:application/json&quot; -X POST localhost:8080/spot
</code></pre>
<p class="has-line-data" data-line-start="121" data-line-end="122">Get free spots :</p>
<pre><code class="has-line-data" data-line-start="123" data-line-end="125">curl -X GET localhost:8080/spot/free
</code></pre>
<p class="has-line-data" data-line-start="125" data-line-end="126">Get all spot by customer name Jhon :</p>
<pre><code class="has-line-data" data-line-start="127" data-line-end="129">curl -X GET localhost:8080/spot?name=Jhon
</code></pre>
<p class="has-line-data" data-line-start="129" data-line-end="130">Get all reservation</p>
<pre><code class="has-line-data" data-line-start="131" data-line-end="133">curl -X GET localhost:8080/reservation
</code></pre>
<p class="has-line-data" data-line-start="133" data-line-end="134">Add reservation</p>
<pre><code class="has-line-data" data-line-start="135" data-line-end="137">curl -d &quot;{\&quot;customerId\&quot;:1,\&quot;spotId\&quot;:1}&quot; -H &quot;Content-Type:application/json&quot; -X POST localhost:8080/reservation
</code></pre>
<p class="has-line-data" data-line-start="137" data-line-end="138">Delete reservation by id</p>
<pre><code class="has-line-data" data-line-start="139" data-line-end="141">curl -X DELETE localhost:8080/reservation/1
</code></pre>
<p class="has-line-data" data-line-start="141" data-line-end="142">Get all reservation by customer name Jhon</p>
<pre><code class="has-line-data" data-line-start="143" data-line-end="145">curl -X GET localhost:8080/reservation?name=Jhon
</code></pre>
<h2 class="code-line" data-line-start=147 data-line-end=148 ><a id="License_147"></a>License</h2>
<p class="has-line-data" data-line-start="149" data-line-end="150"><strong>Free Software, Hell Yeah!</strong></p>
