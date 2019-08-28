# codefellowship

Build an app that allows users to create their profile on CodeFellowship.

The site should have a splash page at the root route (/) that contains basic information about the site, as well as a link to the “sign up” page.

An ApplicationUser should have a username, password ( hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.

The site should allow users to create an ApplicationUser on the “sign up” page.

Your Controller should have an @Autowired private PasswordEncoder passwordEncoder; and use that to run passwordEncoder.encode(password) before saving the password into the new user.

The site should have a page which allows viewing the data about a single ApplicationUser, at a route like /users/{id}.
This should include a default profile picture, which is the same for every user, and their basic information.

Upon logging in, users should be taken to a /myprofile route that displays their information.
Ensure that user registration also logs users into your app automatically.

### Instructions

In your terminal:

`git clone https://github.com/rnmessick/codefellowship.git`

`./gradlew bootRun`

visit: http://localhost:8080/

### Collaborators and Resources

Fabian Brooks

Nick Paro

Melfi Perez

Matt Stuhring

https://www.baeldung.com/spring-security-login
