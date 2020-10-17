# springboot-rest-error-handling-sample
### Things todo list:
1. Clone this repository: `git clone https://github.com/hendisantika/springboot-rest-error-handling-sample.git`
2. Go inside the folder: `cd springboot-rest-error-handling-sample`
3. Run the application: `mvn clean spring-boot:run`
4. Open your favorite browser: http://localhost:8080

#### The following, are our API’s endpoints:

`GET /api/users` to get all Users

`GET /api/users/{id}` to retrieve single User by ID

`POST /api/users` to create new User

`PUT /api/users/{id}` to update User details

`DELETE /api/users/{id}` to delete User by ID

`GET /api/user?username={username}` to get User by username - this endpoint has no real value for our REST API, it is created just for testing purpose!

### Images Screen shot

List All Users

![List All Users](img/list.png "List All Users")

Add New User

![Add New User](img/add.png "Add New User")

Find a User

![Find a User](img/find.png "Find a User")

Find a user by username

![Find a user by username](img/username.png "Find a user by username")

Update a user

![Update a user](img/update.png "Update a user")

Delete user

![Delete user](img/delete.png "Delete user")

Constraint Violations

![Constraint Violations](img/constraint-violation.png "Constraint Violations")

Invalid JSON

![Invalid JSON](img/invalid-json.png "Invalid JSON")

Malformed JSOn Request

![Malformed JSOn Request](img/malformed.png "Malformed JSOn Request")

Method Not Found

![Method Not Found](img/method-not-found.png "Method Not Found")

Mismatch Type

![Mismatch Type](img/mismatch.png "Mismatch Type")

Missing Parameter

![Missing Parameter](img/missing%20parameters.png "Missing Parameter")

Resource Not Found

![Resource Not Found](img/notfound.png "Resource Not Found")

Validation Error

![Validation Error](img/validation-error.png "Validation Error")

