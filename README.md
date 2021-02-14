# note

The Application is using MySql db
The Sign in process is being done using oauth2 

The user endpoint is not authenticated so any number of user can be created with any credentials


## cURLs
### create user
curl -X POST \
http://localhost:8080/users \
-H 'content-type: application/json' \
-d '{
"email":"{email}",
"password":"{password}"
}'

### get access_token
curl -X POST \
http://localhost:8080/oauth/token \
-H 'authorization: Basic Y2xpZW50OnNlY3JldA==' \
-H 'content-type: application/x-www-form-urlencoded' \
-d 'username={email}&password={password}&grant_type=password'

### get access_token using refresh token
curl -X POST \
http://localhost:8080/oauth/token \
-H 'authorization: Basic Y2xpZW50OnNlY3JldA==' \
-H 'content-type: application/x-www-form-urlencoded' \
-d 'refresh_token={refresh_token}'

### create note
curl -X POST \
http://localhost:8080/notes \
-H 'authorization: Bearer token' \
-H 'content-type: application/json' \
-d '{
"title":"title1",
"note":"note1"
}'

### get note 
curl -X GET \
http://localhost:8080/notes/{noteId} \
-H 'authorization: Bearer token' \
-H 'content-type: application/json' \

### get all
curl -X GET \
http://localhost:8080/notes \
-H 'authorization: Bearer token' \
-H 'content-type: application/json' \

### update note
curl -X PUT \
http://localhost:8080/notes/{noteId} \
-H 'authorization: Bearer token' \
-H 'content-type: application/json' \
-d '{
"title":"title3",
"note":"note1"
}'

### delete note
curl -X DELETE \
http://localhost:8080/notes/{noteId} \
-H 'authorization: Bearer token' \
-H 'content-type: application/x-www-form-urlencoded' \