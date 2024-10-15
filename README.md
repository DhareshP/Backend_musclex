dto - data transfer object,design pattern used to transfer data between different layers of an application,
      especially between the client (e.g., front-end) and server (e.g., back-end)

      added: org,glassfish.jaxb : for java version 9 and higher
              java.xml.bind : for DataTypeConverter

              Working of api's 

              1. Signup: pass the username, password and email @http://localhost/signup
                           all three fields are required, after he entries method returns 200 ok, with ("user registered successfully").

              2. login : pass the username and password @http://localhost:8080/login
                        if it matches the username and password with the entries by userRepository.findByUsername(), else wrong or invalid user return 401 with message ("invalid username or password"), if pass and user matches, the token is generated via jwtUtil.generateToken() using the usernmae,
                        and return and ok 200response with generated JWT.

                        password needs to be converted into more secure format
