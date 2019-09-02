# codefellowship

An app that allows users to create their profile on CodeFellowship. They can write posts and find other users to follow.

#### Live Site

- [CodeFellowShip](http://codefellowshipblogger-env.dm5sqkm7uk.us-west-2.elasticbeanstalk.com) Some information about the site and ability to register (and have an encrypted password) and login.

### Instructions

In your terminal:
`git clone https://github.com/rnmessick/codefellowship.git`

Type `psql` and type `CREATE DATABASE fellows;` You can replace "fellows" with anything you want.

Navigate to /codefellowship and
type:
`gradle bootRun`

visit: http://localhost:8080/users/{userid}
Check out another user's profile and make a friend!

visit: http://localhost:8080/feed
See what your friends are up to!

visit: http://localhost:8080/userProfile
Your profile. You can see your own posts here too.

visit: http://localhost:8080/addPost
Add a new post here.

### Collaborators and Resources

Fabian Brooks

Jack Kinne

Nick Paro

Melfi Perez

Matt Stuhring

https://www.baeldung.com/spring-security-login

https://www.baeldung.com/java-set-operations

https://www.baeldung.com/hibernate-many-to-many

https://www.baeldung.com/spring-data-rest-relationships

https://formden.com/blog/date-picker

https://mdbootstrap.com/docs/jquery/forms/validation/#datepicker
