<%--
  Created by IntelliJ IDEA.
  User: sport
  Date: 3/8/2023
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <link rel="stylesheet" type="text/css" href="homePage.css">
    <link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
<header>
    <nav>
        <a href="#">Home</a>
        <a href="#">Profile</a>
        <a href="#">Settings</a>
        <a href="#">Logout</a>
    </nav>
    <form>
        <input type="text" placeholder="Search...">
        <button type="submit">Go</button>
    </form>
</header>

<main>
    <section id="welcome">
        <h1>Welcome back, [username]!</h1>
        <p>Here's a quick overview of your account:</p>
        <div class="overview">
            <div class="card">
                <h2>[number of followers]</h2>
                <p>Followers</p>
            </div>
            <div class="card">
                <h2>[number of posts]</h2>
                <p>Posts</p>
            </div>
            <div class="card">
                <h2>[number of likes]</h2>
                <p>Likes</p>
            </div>
        </div>
    </section>

    <section id="profile">
        <div class="profile-card">
            <img src="[profile picture URL]" alt="[username]'s profile picture">
            <div class="details">
                <h2>[username]</h2>
                <p>[user bio]</p>
                <ul>
                    <li><strong>Email:</strong> [user email]</li>
                    <li><strong>Location:</strong> [user location]</li>
                    <li><strong>Website:</strong> <a href="[user website URL]">[user website URL]</a></li>
                </ul>
            </div>
        </div>
    </section>

    <section id="activity">
        <h2>Recent Activity</h2>
        <ul>
            <li>
                <span class="date">[date]</span>
                <span class="description">[user] posted a new photo</span>
            </li>
            <li>
                <span class="date">[date]</span>
                <span class="description">[user] liked [another user]'s post</span>
            </li>
            <li>
                <span class="date">[date]</span>
                <span class="description">[user] commented on [another user]'s post</span>
            </li>
        </ul>
    </section>

    <section id="recommendations">
        <h2>Recommended for You</h2>
        <div class="grid-container">
            <div class="item">
                <img src="[item 1 image URL]" alt="[item 1 name]">
                <h3>[item 1 name]</h3>
                <p>[item 1 description]</p>
                <button>Learn More</button>
            </div>
            <div class="item">
                <img src="[item 2 image URL]" alt="[item 2 name]">
                <h3>[item 2 name]</h3>
                <p>[item 2 description]</p>
                <button>Learn More</button>
            </div>
            <div class="item">
                <img src="[item 3 image URL]" alt="[item 3 name]">
                <h3>[item 3 name]</h3>
                <p>[item 3 description]</p>
                <button>Learn More</button>
            </div>
        </div>
    </section>
</main>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6">
                <h3>About Us</h3>
                <p class="abt-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <h3>Contact Us</h3>
                <ul>
                    <li>Address: 123 Main St, Anytown USA</li>
                    <li>Phone: 555-123-4567</li>
                    <li>Email: info@example.com</li>
                </ul>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12">
                <h3>Follow Us</h3>
                <ul>
                    <li><a href="#">Facebook</a></li>
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">Instagram</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <p>&copy; 2023 MySite.com. All rights reserved.</p>
            </div>
        </div>
    </div>
</footer>

</body>
</html>
