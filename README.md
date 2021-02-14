# note

## curls
### create user
curl -X POST \
http://localhost:8080/users \
-H 'content-type: application/json' \
-d '{
"username":"arshak@disqo.com",
"password":"123456"
}'

### get token
curl -X POST \
http://localhost:8080/oauth/token \
-H 'authorization: Basic Y2xpZW50OnNlY3JldA==' \
-H 'content-type: application/x-www-form-urlencoded' \
-d 'username=arshak%40disqo.com&password=123456sdfdsfsd&grant_type=password'

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